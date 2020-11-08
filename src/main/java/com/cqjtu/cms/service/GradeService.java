package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.CourseTagDto;
import com.cqjtu.cms.model.entity.Grade;

import java.util.List;

/**
 * 修读课程信息 服务类
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface GradeService extends IService<Grade> {

  /**
   * 课程平台编号,学生编号查询修读信息
   *
   * @param tagId 课程平台编号
   * @param sno 学生编号
   * @param term 学期
   * @return java.util.List<com.cqjtu.cms.model.dto.CourseTagDto>
   * @author suwen
   * @date 2020/11/8 9:41
   */
  List<CourseTagDto> getByTagIdAndSno(Integer tagId, String sno, String term);
}
