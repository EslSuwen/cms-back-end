package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.output.TagDto;
import com.cqjtu.cms.model.entity.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 课程平台关系表 Mapper 接口
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface TagMapper extends BaseMapper<Tag> {

  /**
   * 查询所有 tag
   *
   * @return java.util.List<com.cqjtu.cms.model.entity.Tag>
   * @author suwen
   * @date 2020/11/5 10:28
   */
  @Select("SELECT id,category_id,`name`,`each`,`limit`  FROM tag")
  List<Tag> list();

  /**
   * 通过课程类别编号获取课程平台信息
   *
   * @param categoryId 课程类别编号
   * @return java.util.List<com.cqjtu.cms.model.dto.output.TagDto>
   * @author suwen
   * @date 2020/11/8 9:02
   */
  List<TagDto> getByCategoryId(Integer categoryId);
}
