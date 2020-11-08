package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Student;
import com.cqjtu.cms.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 学生管理-前端控制器
 *
 * @author suwen
 * @since 2020-10-25
 */
@Api(tags = "学生管理-前端控制器")
@RestController
@RequestMapping("/cms/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有学生信息")
  public ResponseEntity<Result> getAllStudentInfo() {
    return Result.success(studentService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取学生信息")
  public ResponseEntity<Result> getStudentById(
      @ApiParam(value = "学生编号", required = true) @PathVariable String id) {
    return Result.success(studentService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加学生信息")
  public ResponseEntity<Result> addStudent(
      @ApiParam(value = "学生信息", required = true) @RequestBody Student student) {
    return Result.success(studentService.save(student), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改学生信息")
  public ResponseEntity<Result> updateStudent(
      @ApiParam(value = "学生信息", required = true) @RequestBody Student student) {
    return Result.success(studentService.updateById(student), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除学生信息")
  public ResponseEntity<Result> removeStudentById(
      @ApiParam(value = "学生编号", required = true) @PathVariable String id) {
    return Result.success(studentService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
