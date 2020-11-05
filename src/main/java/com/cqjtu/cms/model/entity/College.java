package com.cqjtu.cms.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 学院表
 *
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "College对象", description = "学院表")
public class College implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "学院编号")
  private Integer id;

  @ApiModelProperty(value = "学院名称")
  private String name;
}
