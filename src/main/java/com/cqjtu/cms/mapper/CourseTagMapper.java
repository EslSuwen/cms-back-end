package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.CourseTagDto;
import com.cqjtu.cms.model.entity.CourseTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程平台关联课程 Mapper 接口
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface CourseTagMapper extends BaseMapper<CourseTag> {

  /**
   * 通过tagId,term查询
   *
   * @param tagId 课程平台编号
   * @param term 学期
   * @return java.util.List<com.cqjtu.cms.model.dto.CourseTagDto>
   * @author suwen
   * @date 2020/11/8 9:41
   */
  List<CourseTagDto> getByTagIdAndTerm(@Param("tagId") Integer tagId, @Param("term") String term);
}
