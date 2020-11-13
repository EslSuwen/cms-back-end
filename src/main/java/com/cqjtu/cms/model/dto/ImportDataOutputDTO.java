package com.cqjtu.cms.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 导入数据接口返回DTO
 *
 * @author hepengrui
 * @date 2019/2/24 14:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportDataOutputDTO implements Serializable {
  /** 导入excel中新增记录条数 */
  @ApiModelProperty(value = "导入excel中新增记录条数", name = "newRecordNum", example = "10")
  private Integer newRecordNum;

  /** 导入excel中更新记录条数 */
  @ApiModelProperty(value = "导入excel中更新记录条数", name = "modifyRecordNum", example = "10")
  private Integer modifyRecordNum;

  /** 导入excel中因数据自身问题忽略记录条数 */
  @ApiModelProperty(value = "导入excel中因数据自身问题忽略记录条数", name = "ignoreRecordNum", example = "0")
  private Integer ignoreRecordNum;
}
