package com.cqjtu.cms.model.dto.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * CategoryDto
 *
 * @author suwen
 * @version 1.0
 * @date 2020/11/8 9:06
 */
@Data
@ApiModel(value = "课程类别dto", description = "CategoryDto")
public class CategoryDto implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "课程类别编号")
  private Integer categoryId;

  @ApiModelProperty(value = "课程类别名")
  private String categoryName;

  @ApiModelProperty(value = "专业编号")
  private Integer majorId;

  @ApiModelProperty(value = "专业名")
  private String majorName;

  @ApiModelProperty(value = "学院编号")
  private Integer collegeId;

  @ApiModelProperty(value = "学院名称")
  private String collegeName;

  @ApiModelProperty(value = "专业年级")
  private Integer grade;
}
