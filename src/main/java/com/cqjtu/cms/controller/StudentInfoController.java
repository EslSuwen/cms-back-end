package com.cqjtu.cms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.dto.Result;
import com.cqjtu.cms.entity.Gtv;
import com.cqjtu.cms.entity.Student;
import com.cqjtu.cms.service.CurriculumStudyService;
import com.cqjtu.cms.service.GtvService;
import com.cqjtu.cms.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生信息-前端控制器
 *
 * @author suwen
 * @since 2020-10-25
 */
@Api(tags = "学生信息-前端控制器")
@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

  private StudentService studentService;
  private GtvService gtvService;
  private CurriculumStudyService studyService;

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }

  @Autowired
  public void setGtvService(GtvService gtvService) {
    this.gtvService = gtvService;
  }

  @Autowired
  public void setStudyService(CurriculumStudyService studyService) {
    this.studyService = studyService;
  }

  @GetMapping("/getInfo/{sno}")
  @ApiOperation("获取学生学分信息")
  public ResponseEntity<Result> getAllStudentInfo(@ApiParam("学生编号") @PathVariable String sno) {
    Student student = studentService.getById(sno);
    List<Gtv> gtvList =
        gtvService.list(new QueryWrapper<Gtv>().eq("major_id", student.getMajorId()));
    for (Gtv each : gtvList) {
      each.setFinishCredit(
          studyService.getSumCredit(sno, each.getCourseType(), each.getCourseAttribute()));
    }
    return Result.success(gtvList, ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取学生信息")
  public ResponseEntity<Result> getStudentById(@ApiParam("学生编号") @PathVariable String id) {
    return Result.success(studentService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加学生信息")
  public ResponseEntity<Result> addStudent(@ApiParam("学生信息") @RequestBody Student student) {
    return Result.success(studentService.save(student), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改学生信息")
  public ResponseEntity<Result> updateStudent(@ApiParam("学生信息") @RequestBody Student student) {
    return Result.success(studentService.updateById(student), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除学生信息")
  public ResponseEntity<Result> removeStudentById(@ApiParam("学生编号") @PathVariable String id) {
    return Result.success(studentService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
