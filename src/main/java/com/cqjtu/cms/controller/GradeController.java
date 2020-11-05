package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Grade;
import com.cqjtu.cms.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 修读课程信息表 前端控制器
 *
 * @author suwen
 * @since 2020-11-05
 */
@Api(tags = "修读课程信息-前端控制器")
@RestController
@RequestMapping("/cms/grade")
public class GradeController {

  private GradeService gradeService;

  @Autowired
  public void setGradeService(GradeService gradeService) {
    this.gradeService = gradeService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有修读信息")
  public ResponseEntity<Result> getAllGradeInfo() {
    return Result.success(gradeService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取修读信息")
  public ResponseEntity<Result> getGradeById(@ApiParam("修读编号") @PathVariable String id) {
    return Result.success(gradeService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加修读信息")
  public ResponseEntity<Result> addGrade(@ApiParam("修读信息") @RequestBody Grade grade) {
    return Result.success(gradeService.save(grade), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改修读信息")
  public ResponseEntity<Result> updateGrade(@ApiParam("修读信息") @RequestBody Grade grade) {
    return Result.success(gradeService.updateById(grade), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除修读信息")
  public ResponseEntity<Result> removeGradeById(@ApiParam("修读编号") @PathVariable String id) {
    return Result.success(gradeService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
