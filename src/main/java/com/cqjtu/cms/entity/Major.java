package com.cqjtu.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 专业信息
 *
 * @author suwen
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Major对象", description = "专业信息")
public class Major implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "专业编号")
  @TableId(type = IdType.INPUT)
  private Integer majorId;

  @ApiModelProperty(value = "专业名")
  private String name;

  @ApiModelProperty(value = "所属学院")
  private String college;
}
