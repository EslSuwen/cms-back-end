package com.cqjtu.cms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.output.Result;
import com.cqjtu.cms.model.entity.ProcessTag;
import com.cqjtu.cms.service.ProcessTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 课程平台关联课程 前端控制器
 *
 * @author suwen
 * @since 2020-11-14
 */
@Api(tags = "执行计划平台-前端控制器")
@RestController
@RequestMapping("/processTag")
public class ProcessTagController {

  private ProcessTagService processTagService;

  @Autowired
  public void setProcessTagService(ProcessTagService processTagService) {
    this.processTagService = processTagService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有关联课程信息")
  public ResponseEntity<Result> getAllProcessTagInfo() {
    return Result.success(processTagService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取关联课程信息")
  public ResponseEntity<Result> getProcessTagById(
      @ApiParam(value = "关联课程编号", required = true) @PathVariable String id) {
    return Result.success(processTagService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByTagId/{id}")
  @ApiOperation("通过编号获取关联课程信息")
  public ResponseEntity<Result> getProcessTagByTagId(
      @ApiParam(value = "课程平台关系编号", required = true) @PathVariable String id) {
    return Result.success(
        processTagService.list(new QueryWrapper<ProcessTag>().eq("tag_id", id)),
        ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByTagAndMajor")
  @ApiOperation("通过课程平台编号专业获取关联课程信息")
  public ResponseEntity<Result> getByTagIdAndMajor(
      @ApiParam(value = "课程平台编号", required = true) @RequestParam Integer id,
      @ApiParam(value = "专业编号", required = true) @RequestParam Integer majorId,
      @ApiParam(value = "学期") @RequestParam(required = false) String term) {
    return Result.success(
        processTagService.getByTagIdAndTerm(id, majorId, term), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加关联课程信息")
  public ResponseEntity<Result> addProcessTag(
      @ApiParam(value = "关联课程信息", required = true) @RequestBody ProcessTag processTag) {
    return Result.success(processTagService.save(processTag), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改关联课程信息")
  public ResponseEntity<Result> updateProcessTag(
      @ApiParam(value = "关联课程信息", required = true) @RequestBody ProcessTag processTag) {
    return Result.success(processTagService.updateById(processTag), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除关联课程信息")
  public ResponseEntity<Result> removeProcessTagById(
      @ApiParam(value = "关联课程编号", required = true) @PathVariable String id) {
    return Result.success(processTagService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
