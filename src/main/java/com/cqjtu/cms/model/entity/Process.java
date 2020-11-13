package com.cqjtu.cms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 教学执行表
 *
 * @author suwen
 * @since 2020-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Process对象", description = "教学执行表")
public class Process implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "执行计划编号")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "课程编号")
  private Integer courseId;

  @ApiModelProperty(value = "课程名")
  private String courseName;

  @ApiModelProperty(value = "行课学期")
  private String term;

  @ApiModelProperty(value = "学分")
  private String credit;

  @ApiModelProperty(value = "课程类别编号")
  private Integer categoryId;

  @ApiModelProperty(value = "专业编号")
  private Integer majorId;
}
