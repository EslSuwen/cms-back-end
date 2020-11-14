package com.cqjtu.cms.model.dto.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * StudentDto
 *
 * @author pc
 * @version 1.0
 * @date 2020/11/8 10:07
 */
@Data
@ApiModel(value = "StudentDto", description = "Student 传输对象")
public class StudentDto implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "学生学号")
  private String sno;

  @ApiModelProperty(value = "专业年级")
  private Integer grade;

  @ApiModelProperty(value = "专业编号")
  private Integer majorId;

  @ApiModelProperty(value = "学院编号")
  private Integer collegeId;

  @ApiModelProperty(value = "学生姓名")
  private String studentName;

  @ApiModelProperty(value = "专业名称")
  private String majorName;

  @ApiModelProperty(value = "学院名称")
  private String collegeName;
}
