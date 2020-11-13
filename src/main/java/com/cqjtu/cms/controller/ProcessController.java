package com.cqjtu.cms.controller;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.cqjtu.cms.constant.Constants;
import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Process;
import com.cqjtu.cms.service.ProcessService;
import com.cqjtu.cms.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * 教学执行表 前端控制器
 *
 * @author suwen
 * @since 2020-11-13
 */
@Log4j2
@RestController
@RequestMapping("/process")
@Api(tags = "执行计划-前端控制器")
public class ProcessController {

  private ProcessService processService;

  @Autowired
  public void setProcessService(ProcessService processService) {
    this.processService = processService;
  }

  /** 排课信息导入excel表头字段 */
  private static final List<String> FIELD_NAMES =
      Arrays.asList(
          "curriculumNumber",
          "week",
          "weekTypeName",
          "learnTime",
          "studyPlace",
          "code",
          "name",
          "workNumber",
          "teacherName",
          "instituteName",
          "clazzName",
          "studyPeopleNum",
          "termNameImport");

  private RowHandler createRowHandler() {
    return new RowHandler() {
      @Override
      public void handle(int sheetIndex, long rowIndex, List<Object> rowlist) {
        Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
      }
    };
  }

  @ApiOperation("教学计划表导入")
  @PostMapping("/importProcessExcel")
  public ResponseEntity<Result> importProcessExcel(
      @ApiParam("专业编号") @RequestParam Integer majorId,
      @ApiParam("年级") @RequestParam Integer grade,
      @ApiParam("excel 文件") @RequestParam MultipartFile file) {
    String fileName = file.getOriginalFilename();
    // 判断文件是否是excel文件
    assert fileName != null;
    if (!fileName.endsWith(Constants.XLS_SUFFIX) && !fileName.endsWith(Constants.XLSX_SUFFIX)) {
      log.error("{}不是excel文件", fileName);
      return Result.failure(ResultCode.PARAM_ERROR);
    }
    try (InputStream inputStream = file.getInputStream()) {
      List<Process> processList =
          ExcelUtils.readExcel(inputStream, fileName, Process.class, 0, FIELD_NAMES, 1, 1);
      if (CollectionUtils.isEmpty(processList)) {
        return Result.failure(ResultCode.PARAM_ERROR);
      }
      return Result.success(processList);
      // return Result.success(processService.importExcel(majorId, grade, processList),
      // ResultCode.SUCCESS_ADD_DATA);
    } catch (IOException e) {
      log.error("上传文件失败", e);
      return Result.failure(ResultCode.PARAM_ERROR);
    }
  }
}
