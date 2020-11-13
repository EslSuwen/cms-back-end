package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Course;
import com.cqjtu.cms.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 课程表 前端控制器
 *
 * @author suwen
 * @since 2020-11-05
 */
@Api(tags = "课程-前端控制器")
@RestController
@RequestMapping("/course")
public class CourseController {

  private CourseService courseService;

  @Autowired
  public void setCourseService(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有课程信息")
  public ResponseEntity<Result> getAllCourseInfo() {
    return Result.success(courseService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取课程信息")
  public ResponseEntity<Result> getCourseById(
      @ApiParam(value = "课程编号", required = true) @PathVariable String id) {
    return Result.success(courseService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加课程信息")
  public ResponseEntity<Result> addCourse(
      @ApiParam(value = "课程信息", required = true) @RequestBody Course course) {
    return Result.success(courseService.save(course), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改课程信息")
  public ResponseEntity<Result> updateCourse(
      @ApiParam(value = "课程信息", required = true) @RequestBody Course course) {
    return Result.success(courseService.updateById(course), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除课程信息")
  public ResponseEntity<Result> removeCourseById(
      @ApiParam(value = "课程编号", required = true) @PathVariable String id) {
    return Result.success(courseService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
