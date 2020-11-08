package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.model.dto.Result;
import com.cqjtu.cms.model.entity.Student;
import com.cqjtu.cms.service.GradeService;
import com.cqjtu.cms.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 学生信息-前端控制器
 *
 * @author suwen
 * @since 2020-10-25
 */
@Api(tags = "学生信息-前端控制器")
@RestController
@RequestMapping("/cms/studentInfo")
public class StudentInfoController {

  private StudentService studentService;
  private GradeService gradeService;

  @Autowired
  public void setGradeService(GradeService gradeService) {
    this.gradeService = gradeService;
  }

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/getCourseTagInfo")
  @ApiOperation("获取平台关联课程修读信息")
  public ResponseEntity<Result> getTagInfoByIdAndSno(
      @ApiParam(value = "课程平台编号", required = true) @RequestParam Integer id,
      @ApiParam(value = "学生编号", required = true) @RequestParam String sno,
      @ApiParam(value = "学期") @RequestParam(required = false) String term) {
    return Result.success(
        gradeService.getByTagIdAndSno(id, sno, term), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取学生信息")
  public ResponseEntity<Result> getStudentById(
      @ApiParam(value = "学生编号", required = true) @PathVariable String id) {
    return Result.success(studentService.getInfoBySno(id), ResultCode.SUCCESS_GET_DATA);
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
