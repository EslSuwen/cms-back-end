package com.cqjtu.cms.model.dto.output;

import lombok.Data;

/**
 * ProcessDto
 *
 * @author suwen
 * @version 1.0
 * @date 2020/11/14 17:25
 */
@Data
public class ProcessDto {

  private Integer processId;

  private Integer courseId;

  private String courseName;

  private String term;

  private String credit;

  private Integer categoryId;

  private Integer majorId;

  private String categoryName;

  private String grade;
}
