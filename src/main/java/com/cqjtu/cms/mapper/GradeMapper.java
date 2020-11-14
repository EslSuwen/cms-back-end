package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.output.CourseTagDto;
import com.cqjtu.cms.model.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 修读课程信息 Mapper 接口
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface GradeMapper extends BaseMapper<Grade> {

  /**
   * 课程平台编号,学生编号查询修读信息
   *
   * @param tagId 课程平台编号
   * @param sno 学生编号
   * @param term
   * @return java.util.List<com.cqjtu.cms.model.dto.output.CourseTagDto>
   * @author suwen
   * @date 2020/11/8 9:41
   */
  List<CourseTagDto> getByTagIdAndSno(
      @Param("tagId") Integer tagId, @Param("sno") String sno, @Param("term") String term);
}
