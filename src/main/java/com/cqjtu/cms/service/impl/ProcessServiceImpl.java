package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.ProcessMapper;
import com.cqjtu.cms.model.dto.ImportDataOutputDTO;
import com.cqjtu.cms.model.entity.Process;
import com.cqjtu.cms.service.CategoryService;
import com.cqjtu.cms.service.ProcessService;
import org.springframework.stereotype.Service;

import java.util.List;

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

  @Override
  public ImportDataOutputDTO importExcel(
      Integer majorId, Integer grade, List<Process> processList) {
    return null;
  }

  /* {

  // 查找所有课程类别
  List<Category> categoryList = categoryService.list();
  if (CollectionUtils.isEmpty(categoryList)) {
    throw new ServiceException("请先添加课程类别信息");
  }

  // 过滤出所有的学期学年
  Set<String> termNameSet =
      curriculumImportDTO.stream()
          .map(dto -> dto.getTermNameImport())
          .collect(Collectors.toSet());
  if (CollectionUtils.isEmpty(termNameSet) || termNameSet.size() != 1) {
    throw new ServiceException("导入数据中学期学年不能为空并且必须是同一学期学年数据");
  }

  // 查询导入数据中对应的学期是否存在
  String termName = termNameSet.iterator().next();
  if (StringUtils.isEmpty(termName)) {
    throw new ServiceException("表格中学期不能为空");
  }

  Optional<Term> optionalTerm =
      allTerm.stream().filter(term -> term.getName().equals(termName)).findFirst();
  if (!optionalTerm.isPresent()) {
    throw new ServiceException(termName + "不存在,请先添加该学期");
  }

  */
  /** 导入数据对应的学期 */
  /*
  Term term = optionalTerm.get();

  */
  /** 查询已有排课列表 */
  /*
  List<Curriculum> existCurriculums = curriculumRepository.findByTermId(term.getId());
  */
  /** 查询已有老师列表 */
  /*
  //        List<Teacher> existTeachers = teacherRepository.findAll();
  // 导入excel中新增记录条数
  int newRecordNum = 0;
  // 导入excel中更新记录条数
  int modifyRecordNum = 0;
  // 导入excel中因数据自身问题忽略记录条数
  int ignoreRecordNum = 0;

  for (CurriculumImportDTO importDTO : curriculumImportDTO) {

    */
  /** 如果导入数据中排课任务编号 教师工号 学期学年 有任意一个为空,该条数据就直接跳过 */
  /*
  if (StringUtils.isEmpty(importDTO.getCurriculumNumber())
      || StringUtils.isEmpty(importDTO.getWorkNumber())
      || StringUtils.isEmpty(importDTO.getTermNameImport())) {
    ignoreRecordNum++;
    continue;
  }

  // 学习时间  比如：20102 第一位2代表星期2  后面0102代表第1-2节课
  String learnTime = importDTO.getLearnTime() == null ? "" : importDTO.getLearnTime();
  // 星期几
  Integer dayOfWeek = null;
  // 上课节次
  String section = null;

  if (!StringUtils.isEmpty(learnTime)) {
    dayOfWeek = Integer.valueOf(learnTime.substring(0, 1));
    section = learnTime.substring(1);
  }

  */
  /** 如果该条排课信息是否存在 通过排课任务号+老师工号+学期+上课时间 确定唯一键,更新这条数据 */
  /*
  if (!CollectionUtils.isEmpty(existCurriculums)) {
    Curriculum existCurriculum =
        existCurriculums.stream()
            .filter(
                course ->
                    course.getCurriculumNumber().equals(importDTO.getCurriculumNumber())
                        && course.getWorkNumber().equals(importDTO.getWorkNumber())
                        && course.getTermId().equals(term.getId())
                        && learnTime.equals(course.getDayOfWeek() + course.getSection()))
            .findFirst()
            .orElse(null);
    if (existCurriculum != null) {
      BeanUtils.copyProperties(importDTO, existCurriculum);
      existCurriculum.setWeekType(
          WeekType.getEnumByDesc(importDTO.getWeekTypeName()).getValue());
      existCurriculum.setSection(section);
      existCurriculum.setDayOfWeek(dayOfWeek);
      curriculumRepository.save(existCurriculum);
      modifyRecordNum++;
      continue;
    }
  }

  */
  /** 新增排课信息 */
  /*
      Curriculum curriculum = new Curriculum();
      BeanUtils.copyProperties(importDTO, curriculum);
      curriculum.setTermId(term.getId());
      curriculum.setTermName(term.getName());
      // 目前只有土木学院  土木学院id=1
      curriculum.setInstituteId(1);
      curriculum.setWeekType(WeekType.getEnumByDesc(importDTO.getWeekTypeName()).getValue());
      curriculum.setDayOfWeek(dayOfWeek);
      curriculum.setSection(section);
      curriculumRepository.save(curriculum);
      newRecordNum++;
    }
    return new ImportDataOutputDTO(newRecordNum, modifyRecordNum, ignoreRecordNum);

  }*/
}
