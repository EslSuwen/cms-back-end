package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.input.ProcessImportDto;
import com.cqjtu.cms.model.dto.output.ImportDataOutputDTO;
import com.cqjtu.cms.model.dto.output.ProcessDto;
import com.cqjtu.cms.model.entity.Process;

import java.util.List;

/**
 * 教学执行表 服务类
 *
 * @author suwen
 * @since 2020-11-13
 */
public interface ProcessService extends IService<Process> {

  /**
   * 导入排课信息
   *
   * @param majorId 专业编号
   * @param grade 年级
   * @param processImportDtoList 计划数据列表
   * @return com.cqjtu.cms.model.dto.output.ImportDataOutputDTO
   * @author suwen
   * @date 2020/11/14 17:03
   */
  ImportDataOutputDTO importExcel(
      Integer majorId, Integer grade, List<ProcessImportDto> processImportDtoList);

  /**
   * 通过专业年级获取所有教学计划信息
   *
   * @param majorId 专业
   * @param grade 年级
   * @return java.util.List<com.cqjtu.cms.model.dto.output.ProcessDto>
   * @author suwen
   * @date 2020/11/14 17:27
   */
  List<ProcessDto> getByMajorAndGrade(Integer majorId, Integer grade);
}
