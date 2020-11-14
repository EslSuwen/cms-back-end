package com.cqjtu.cms.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程平台关联课程
 *
 * @author suwen
 * @since 2020-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "ProcessTag对象", description = "课程平台关联课程")
public class ProcessTag implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "编号")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "教学计划编号")
  private Integer processId;

  @ApiModelProperty(value = "课程平台编号")
  private Integer tagId;

  @ApiModelProperty(value = "是否为限选课程(0:false;1:true)")
  private String required;

  @ApiModelProperty(value = "备注")
  private String ps;
}
