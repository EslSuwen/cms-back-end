package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Tag;
import com.cqjtu.cms.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 课程平台关系表 前端控制器
 *
 * @author suwen
 * @since 2020-11-05
 */
@Api(tags = "课程平台关系-前端控制器")
@RestController
@RequestMapping("/cms/tag")
public class TagController {

  private TagService tagService;

  @Autowired
  public void setTagService(TagService tagService) {
    this.tagService = tagService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有课程平台关系信息")
  public ResponseEntity<Result> getAllTagInfo() {
    return Result.success(tagService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取课程平台关系信息")
  public ResponseEntity<Result> getTagById(
      @ApiParam(value = "课程平台关系编号", required = true) @PathVariable String id) {
    return Result.success(tagService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByCategoryId/{id}")
  @ApiOperation("通过课程平台编号获取课程平台关系信息")
  public ResponseEntity<Result> getTagByCategoryId(
      @ApiParam(value = "课程平台编号", required = true) @PathVariable Integer id) {
    return Result.success(tagService.getByCategoryId(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加课程平台关系信息")
  public ResponseEntity<Result> addTag(
      @ApiParam(value = "课程平台关系信息", required = true) @RequestBody Tag tag) {
    return Result.success(tagService.save(tag), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改课程平台关系信息")
  public ResponseEntity<Result> updateTag(
      @ApiParam(value = "课程平台关系信息", required = true) @RequestBody Tag tag) {
    return Result.success(tagService.updateById(tag), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除课程平台关系信息")
  public ResponseEntity<Result> removeTagById(
      @ApiParam(value = "课程平台关系编号", required = true) @PathVariable String id) {
    return Result.success(tagService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
