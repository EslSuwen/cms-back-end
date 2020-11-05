package com.cqjtu.cms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程平台关系表
 *
 * @author suwen
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Tag对象", description = "课程平台关系表")
public class Tag implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程平台编号")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "课程类型编号")
  private Integer categoryId;

  @ApiModelProperty(value = "课程平台名称")
  private String name;

  @ApiModelProperty(value = "每学期建议修读学分(0:无限制)")
  private Integer each;

  @ApiModelProperty(value = "毕业要求修读学分")
  private Integer limit;
}
