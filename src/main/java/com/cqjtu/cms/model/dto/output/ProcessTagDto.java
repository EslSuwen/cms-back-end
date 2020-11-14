package com.cqjtu.cms.model.dto.output;

import com.cqjtu.cms.model.entity.Grade;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ProcessTagDto
 *
 * @author suwen
 * @version 1.0
 * @date 2020/11/8 8:46
 */
@Data
@ApiModel(value = "平台关联课程dto", description = "ProcessTagDto 传输对象")
public class ProcessTagDto implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "平台关联课程编号")
  private Integer processTagId;

  @ApiModelProperty(value = "教学计划编号")
  private Integer processId;

  @ApiModelProperty(value = "课程编号")
  private String courseId;

  @ApiModelProperty(value = "课程平台编号")
  private Integer tagId;

  @ApiModelProperty(value = "课程名称")
  private String courseName;

  @ApiModelProperty(value = "课程平台名称")
  private String tagName;

  @ApiModelProperty(value = "课程学分")
  private String credit;

  @ApiModelProperty(value = "开课学期")
  private String term;

  @ApiModelProperty(value = "是否为限选课程(0:false;1:true)")
  private String required;

  @ApiModelProperty(value = "备注")
  private String ps;

  @ApiModelProperty(value = "成绩")
  private Grade grade;
}
