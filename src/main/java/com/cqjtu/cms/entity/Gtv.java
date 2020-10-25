package com.cqjtu.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 毕业学分阈值 graduate threshold value
 *
 * @author suwen
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Gtv对象", description = "毕业学分阈值 graduate threshold value")
public class Gtv implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "编号")
  @TableId(type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "课程类型名")
  private String courseType;

  @ApiModelProperty(value = "课程类型所需学分")
  private Integer limitCredit;

  private Integer majorId;
}
