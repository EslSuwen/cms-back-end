package com.cqjtu.cms.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CourseTag对象", description = "")
public class CourseTag implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程编号")
  private String courseId;

  @ApiModelProperty(value = "课程平台编号")
  private Integer tagId;

  @ApiModelProperty(value = "是否为限选课程(0:false;1:true)")
  private String required;

  @ApiModelProperty(value = "备注")
  private String ps;
}
