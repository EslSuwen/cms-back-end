package com.cqjtu.cms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程类别表
 *
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Category对象", description = "课程类别表")
public class Category implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程类别编号")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "课程类别名")
  private String name;

  @ApiModelProperty(value = "专业编号")
  private Integer majorId;

  @ApiModelProperty(value = "专业年级")
  private Integer grade;
}
