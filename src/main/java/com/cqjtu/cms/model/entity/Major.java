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
@ApiModel(value = "Major对象", description = "")
public class Major implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "专业编号")
  private Integer id;

  @ApiModelProperty(value = "专业名")
  private String name;

  @ApiModelProperty(value = "所属学院编号")
  private Integer collegeId;
}
