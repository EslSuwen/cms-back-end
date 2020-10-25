package com.cqjtu.cms.entity;

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
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "CurriculumStudy对象", description = "学生课程信息修读表")
public class CurriculumStudy implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "编号")
  @TableId(type = IdType.AUTO)
  private Long id;

  @ApiModelProperty(value = "学生学号")
  private String sno;

  @ApiModelProperty(value = "课程编号")
  private Integer cno;

  @ApiModelProperty(value = "课程名")
  private String cname;

  @ApiModelProperty(value = "学分")
  private String credit;

  @ApiModelProperty(value = "课程性质")
  private String type;

  @ApiModelProperty(value = "课程属性")
  private String attribute;

  @ApiModelProperty(value = "成绩状态")
  private String result;
}
