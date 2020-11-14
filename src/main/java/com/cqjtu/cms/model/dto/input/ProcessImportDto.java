package com.cqjtu.cms.model.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教学计划 dto
 *
 * @author pc
 * @version 1.0
 * @date 2020/11/14 14:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProcessImportDto {

  private Integer categoryId;

  private String categoryName;

  private String courseType;

  private String term;

  private Integer courseId;

  private String courseName;

  private String period;

  private String termPeriod;

  private String coursePeriod;

  private String expPeriod;

  private String pcPeriod;

  private String prPeriod;

  private String credit;

  private String categoryType;

  private String year;

  private String test;

  private String college;
}
