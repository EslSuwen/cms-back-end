package com.cqjtu.cms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.exception.ServiceException;
import com.cqjtu.cms.mapper.ProcessMapper;
import com.cqjtu.cms.model.dto.input.ProcessImportDto;
import com.cqjtu.cms.model.dto.output.CourseTagDto;
import com.cqjtu.cms.model.dto.output.ImportDataOutputDTO;
import com.cqjtu.cms.model.dto.output.ProcessDto;
import com.cqjtu.cms.model.entity.Category;
import com.cqjtu.cms.model.entity.Process;
import com.cqjtu.cms.service.CategoryService;
import com.cqjtu.cms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 教学执行表 服务实现类
 *
 * @author suwen
 * @since 2020-11-13
 */
@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, Process>
    implements ProcessService {

  private CategoryService categoryService;

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public ImportDataOutputDTO importExcel(
      Integer majorId, Integer grade, List<ProcessImportDto> processImportDtoList) {

    // 查找所有课程类别
    List<Category> categoryList = categoryService.getByGrade(grade);
    if (ArrayUtil.isEmpty(categoryList)) {
      throw new ServiceException("请先添加本年级的课程类别信息");
    }

    // 根据专业编号年级查询已有数据
    List<ProcessDto> processDtoList = getByMajorAndGrade(majorId, grade);

    // 导入excel中新增记录条数
    int newRecordNum = 0;
    // 导入excel中更新记录条数
    int modifyRecordNum = 0;
    // 导入excel中因数据自身问题忽略记录条数
    int ignoreRecordNum = 0;

    for (ProcessImportDto importDTO : processImportDtoList) {

      // 跳过必修课
      if ("必修".equals(importDTO.getCourseType())) {
        ignoreRecordNum++;
        continue;
      }

      // 如果导入数据中课程类别 学期 课程编码 课程名称 学分 有任意一个为空,该条数据就直接跳过
      if (StrUtil.isEmpty(importDTO.getCategoryName())
          || StrUtil.isEmpty(importDTO.getTerm())
          || StrUtil.isEmpty(importDTO.getCourseId().toString())
          || StrUtil.isEmpty(importDTO.getCourseName())
          || StrUtil.isEmpty(importDTO.getCredit())) {
        ignoreRecordNum++;
        continue;
      }

      // 跳过不存在课程类别的数据
      Optional<Category> category =
          categoryList.stream()
              .filter(each -> each.getName().equals(importDTO.getCategoryName()))
              .findFirst();
      if (!category.isPresent()) {
        ignoreRecordNum++;
        continue;
      }
      importDTO.setCategoryId(category.get().getId());

      // 如果该条教学计划信息存在 通过年级+专业编号+课程号 确定唯一键,更新这条数据
      if (!CollectionUtils.isEmpty(processDtoList)) {
        ProcessDto existProcess =
            processDtoList.stream()
                .filter(processDto -> processDto.getCourseId().equals(importDTO.getCourseId()))
                .findFirst()
                .orElse(null);
        if (existProcess != null) {
          Process updateProcess = BeanUtil.copyProperties(importDTO, Process.class);
          updateProcess.setId(existProcess.getProcessId());
          updateById(updateProcess);
          updateProcess.setMajorId(majorId);
          modifyRecordNum++;
          continue;
        }
      }

      // 新增教学计划信息信息
      Process newProcess = BeanUtil.copyProperties(importDTO, Process.class);
      newProcess.setMajorId(majorId);
      save(newProcess);
      newRecordNum++;
    }
    return new ImportDataOutputDTO(newRecordNum, modifyRecordNum, ignoreRecordNum);
  }

  @Override
  public List<ProcessDto> getByMajorAndGrade(Integer majorId, Integer grade) {
    return baseMapper.getByMajorAndGrade(majorId, grade);
  }
}
