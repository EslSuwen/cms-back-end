package com.cqjtu.cms.controller;

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
@RequestMapping("/cms/course-tag")
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
  public ResponseEntity<Result> getCourseTagById(@ApiParam("关联课程编号") @PathVariable String id) {
    return Result.success(courseTagService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加关联课程信息")
  public ResponseEntity<Result> addCourseTag(@ApiParam("关联课程信息") @RequestBody CourseTag courseTag) {
    return Result.success(courseTagService.save(courseTag), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改关联课程信息")
  public ResponseEntity<Result> updateCourseTag(
      @ApiParam("关联课程信息") @RequestBody CourseTag courseTag) {
    return Result.success(courseTagService.updateById(courseTag), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除关联课程信息")
  public ResponseEntity<Result> removeCourseTagById(@ApiParam("关联课程编号") @PathVariable String id) {
    return Result.success(courseTagService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
