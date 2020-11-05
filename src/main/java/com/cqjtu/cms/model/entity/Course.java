package com.cqjtu.cms.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程表
 *
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Course对象", description = "课程表")
public class Course implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程编号")
  private String id;

  @ApiModelProperty(value = "课程名称")
  private String name;

  @ApiModelProperty(value = "课程学分")
  private String credit;

  @ApiModelProperty(value = "开课学期")
  private String term;
}
