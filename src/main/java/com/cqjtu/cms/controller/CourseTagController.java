package com.cqjtu.cms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.CourseTag;
import com.cqjtu.cms.service.CourseTagService;
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
 * @since 2020-11-05
 */
@Api(tags = "课程平台关联课程-前端控制器")
@RestController
@RequestMapping("/course-tag")
public class CourseTagController {

  private CourseTagService courseTagService;

  @Autowired
  public void setCourseTagService(CourseTagService courseTagService) {
    this.courseTagService = courseTagService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有关联课程信息")
  public ResponseEntity<Result> getAllCourseTagInfo() {
    return Result.success(courseTagService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取关联课程信息")
  public ResponseEntity<Result> getCourseTagById(
      @ApiParam(value = "关联课程编号", required = true) @PathVariable String id) {
    return Result.success(courseTagService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByTagId/{id}")
  @ApiOperation("通过编号获取关联课程信息")
  public ResponseEntity<Result> getCourseTagByTagId(
      @ApiParam(value = "课程平台关系编号", required = true) @PathVariable String id) {
    return Result.success(
        courseTagService.list(new QueryWrapper<CourseTag>().eq("tag_id", id)),
        ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByTagAndMajor")
  @ApiOperation("通过课程平台编号专业获取关联课程信息")
  public ResponseEntity<Result> getByTagIdAndMajor(
      @ApiParam(value = "课程平台编号", required = true) @RequestParam Integer id,
      @ApiParam(value = "专业编号", required = true) @RequestParam Integer majorId,
      @ApiParam(value = "学期") @RequestParam(required = false) String term) {
    return Result.success(
        courseTagService.getByTagAndMajor(id, majorId, term), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加关联课程信息")
  public ResponseEntity<Result> addCourseTag(
      @ApiParam(value = "关联课程信息", required = true) @RequestBody CourseTag courseTag) {
    return Result.success(courseTagService.save(courseTag), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改关联课程信息")
  public ResponseEntity<Result> updateCourseTag(
      @ApiParam(value = "关联课程信息", required = true) @RequestBody CourseTag courseTag) {
    return Result.success(courseTagService.updateById(courseTag), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除关联课程信息")
  public ResponseEntity<Result> removeCourseTagById(
      @ApiParam(value = "关联课程编号", required = true) @PathVariable String id) {
    return Result.success(courseTagService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
