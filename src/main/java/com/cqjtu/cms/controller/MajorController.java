package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Major;
import com.cqjtu.cms.service.MajorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 专业-前端控制器
 *
 * @author suwen
 * @since 2020-10-25
 */
@Api(tags = "专业-前端控制器")
@RestController
@RequestMapping("/major")
public class MajorController {

  private final MajorService majorService;

  @Autowired
  public MajorController(MajorService majorService) {
    this.majorService = majorService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有专业信息")
  public ResponseEntity<Result> getAllMajorInfo() {
    return Result.success(majorService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取专业信息")
  public ResponseEntity<Result> getMajorById(@ApiParam("专业编号") @PathVariable Integer id) {
    return Result.success(majorService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加专业信息")
  public ResponseEntity<Result> addMajor(@ApiParam("专业信息") @RequestBody Major major) {
    return Result.success(majorService.save(major), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改专业信息")
  public ResponseEntity<Result> updateMajor(@ApiParam("专业信息") @RequestBody Major major) {
    return Result.success(majorService.updateById(major), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除专业信息")
  public ResponseEntity<Result> removeMajorById(@ApiParam("专业编号") @PathVariable Integer id) {
    return Result.success(majorService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
