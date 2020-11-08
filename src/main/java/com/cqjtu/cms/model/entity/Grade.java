package com.cqjtu.cms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 学生课程信息修读表
 *
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Grade对象", description = "学生课程信息修读表")
public class Grade implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "编号")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "学生学号")
  private String sno;

  @ApiModelProperty(value = "课程编号")
  private String courseId;

  @ApiModelProperty(value = "成绩状态")
  private String result;
}
