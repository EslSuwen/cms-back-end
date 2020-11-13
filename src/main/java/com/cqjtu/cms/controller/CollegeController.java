package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.College;
import com.cqjtu.cms.service.CollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 学院表 前端控制器
 *
 * @author suwen
 * @since 2020-11-05
 */
@RestController
@RequestMapping("/college")
@Api(tags = "学院-前端控制器")
public class CollegeController {

  private CollegeService collegeService;

  @Autowired
  public void setCollegeService(CollegeService collegeService) {
    this.collegeService = collegeService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有学院信息")
  public ResponseEntity<Result> getAllCollegeInfo() {
    return Result.success(collegeService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取学院信息")
  public ResponseEntity<Result> getCollegeById(
      @ApiParam(value = "学院编号", required = true) @PathVariable String id) {
    return Result.success(collegeService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加学院信息")
  public ResponseEntity<Result> addCollege(
      @ApiParam(value = "学院信息", required = true) @RequestBody College college) {
    return Result.success(collegeService.save(college), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改学院信息")
  public ResponseEntity<Result> updateCollege(
      @ApiParam(value = "学院信息", required = true) @RequestBody College college) {
    return Result.success(collegeService.updateById(college), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除学院信息")
  public ResponseEntity<Result> removeCollegeById(
      @ApiParam(value = "学院编号", required = true) @PathVariable String id) {
    return Result.success(collegeService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
