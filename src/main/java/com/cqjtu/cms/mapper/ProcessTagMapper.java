package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.output.ProcessTagDto;
import com.cqjtu.cms.model.entity.ProcessTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程平台关联课程 Mapper 接口
 *
 * @author suwen
 * @since 2020-11-14
 */
public interface ProcessTagMapper extends BaseMapper<ProcessTag> {

  /**
   * 通过tagId,term查询
   *
   * @param tagId 课程平台编号
   * @param majorId 专业编号
   * @param term 学期
   * @return java.util.List<com.cqjtu.cms.model.dto.output.CourseTagDto>
   * @author suwen
   * @date 2020/11/8 9:41
   */
  List<ProcessTagDto> getByTagIdAndTerm(
      @Param("tagId") Integer tagId, @Param("majorId") Integer majorId, @Param("term") String term);
}
