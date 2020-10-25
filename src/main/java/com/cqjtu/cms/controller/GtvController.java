package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.dto.Result;
import com.cqjtu.cms.entity.Gtv;
import com.cqjtu.cms.service.GtvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 毕业学分阈值 graduate threshold value 前端控制器
 *
 * @author suwen
 * @since 2020-10-25
 */
@Api(tags = "系学分管理-前端控制器")
@RestController
@RequestMapping("/gtv")
public class GtvController {

  private final GtvService gtvService;

  @Autowired
  public GtvController(GtvService gtvService) {
    this.gtvService = gtvService;
  }

  @GetMapping("/getAll")
  @ApiOperation("获取所有系学分管理信息")
  public ResponseEntity<Result> getAllGtvInfo() {
    return Result.success(gtvService.list(), ResultCode.SUCCESS_GET_DATA);
  }

  @GetMapping("/getById/{id}")
  @ApiOperation("通过编号获取系学分管理信息")
  public ResponseEntity<Result> getGtvById(@ApiParam("系学分管理编号") @PathVariable Integer id) {
    return Result.success(gtvService.getById(id), ResultCode.SUCCESS_GET_DATA);
  }

  @PostMapping("/add")
  @ApiOperation("增加系学分管理信息")
  public ResponseEntity<Result> addGtv(@ApiParam("系学分管理信息") @RequestBody Gtv gtv) {
    return Result.success(gtvService.save(gtv), ResultCode.SUCCESS_ADD_DATA);
  }

  @PutMapping("/update")
  @ApiOperation("修改系学分管理信息")
  public ResponseEntity<Result> updateGtv(@ApiParam("系学分管理信息") @RequestBody Gtv gtv) {
    return Result.success(gtvService.updateById(gtv), ResultCode.SUCCESS_UPDATE_DATA);
  }

  @DeleteMapping("/removeById/{id}")
  @ApiOperation("通过编号删除系学分管理信息")
  public ResponseEntity<Result> removeGtvById(@ApiParam("系学分管理编号") @PathVariable Integer id) {
    return Result.success(gtvService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
  }
}
