package com.cqjtu.cms.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * TagDto
 *
 * @author suwen
 * @version 1.0
 * @date 2020/11/8 8:42
 */
@Data
@ApiModel(value = "tagDto", description = "tag 传输对象")
public class TagDto implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程类别编号")
  private Integer categoryId;

  @ApiModelProperty(value = "课程类别名")
  private String categoryName;

  @ApiModelProperty(value = "专业编号")
  private Integer majorId;

  @ApiModelProperty(value = "专业年级")
  private Integer grade;

  @ApiModelProperty(value = "课程类型编号")
  private Integer tagId;

  @ApiModelProperty(value = "课程平台名称")
  private String tagName;

  @ApiModelProperty(value = "每学期建议修读学分(0:无限制)")
  private Integer each;

  @ApiModelProperty(value = "毕业要求修读学分")
  private Integer limit;

  @ApiModelProperty(value = "平台关联课程")
  List<CourseTagDto> courseTagDtoList;
}
