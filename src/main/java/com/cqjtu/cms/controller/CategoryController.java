package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.output.Result;
import com.cqjtu.cms.model.entity.Category;
import com.cqjtu.cms.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 课程类别表 前端控制器
 *
 * @author suwen
 * @since 2020-11-05
 */
@Api(tags = "课程类别-前端控制器")
@RestController
@RequestMapping("/category")
public class CategoryController {

  private CategoryService categoryService;

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有课程类别信息")
  public ResponseEntity<Result> getAllCategoryInfo() {
    return Result.success(categoryService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取课程类别信息")
  public ResponseEntity<Result> getCategoryById(
      @ApiParam(value = "课程类别编号", required = true) @PathVariable String id) {
    return Result.success(categoryService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByMajorIdAndGrade")
  @ApiOperation("通过专业编号年级获取课程类别信息")
  @Deprecated
  public ResponseEntity<Result> getCategoryByMajorIdAndGrade(
      @ApiParam(value = "专业编号", required = true) @RequestParam Integer majorId,
      @ApiParam(value = "年级", required = true) @RequestParam Integer grade) {
    return Result.success(
        categoryService.getByMajorIdAndGrade(majorId, grade), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getByGrade/{grade}")
  @ApiOperation("通过年级获取课程类别信息")
  public ResponseEntity<Result> getCategoryByMajorIdAndGrade(
      @ApiParam(value = "年级", required = true) @PathVariable Integer grade) {
    return Result.success(categoryService.getByGrade(grade), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加课程类别信息")
  public ResponseEntity<Result> addCategory(
      @ApiParam(value = "课程类别信息", required = true) @RequestBody Category category) {
    return Result.success(categoryService.save(category), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改课程类别信息")
  public ResponseEntity<Result> updateCategory(
      @ApiParam(value = "课程类别信息", required = true) @RequestBody Category category) {
    return Result.success(categoryService.updateById(category), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除课程类别信息")
  public ResponseEntity<Result> removeCategoryById(
      @ApiParam(value = "课程类别编号", required = true) @PathVariable String id) {
    return Result.success(categoryService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
