package com.cqjtu.cms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 学生信息表
 *
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Student对象", description = "学生信息表")
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "学生学号")
  @TableId(type = IdType.INPUT)
  private String sno;

  @ApiModelProperty(value = "专业年级")
  private Integer grade;

  @ApiModelProperty(value = "专业编号")
  private Integer majorId;

  @ApiModelProperty(value = "学生姓名")
  private String name;

  @ApiModelProperty(value = "密码")
  private String password;
}
