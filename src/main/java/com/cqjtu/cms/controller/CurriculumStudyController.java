package com.cqjtu.cms.controller;

import com.cqjtu.cms.constant.ResultCode;
import com.cqjtu.cms.dto.Result;
import com.cqjtu.cms.entity.CurriculumStudy;
import com.cqjtu.cms.service.CurriculumStudyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 课程信息修读-前端控制器
 *
 * @author suwen
 * @since 2020-10-25
 */
@Api(tags = "课程信息修读-前端控制器")
@RestController
@RequestMapping("/cs")
public class CurriculumStudyController {

    private final CurriculumStudyService cSService;

    @Autowired
    public CurriculumStudyController(CurriculumStudyService cSService) {
        this.cSService = cSService;
    }

    @GetMapping("/getAll")
    @ApiOperation("获取所有修读信息信息")
    public ResponseEntity<Result> getAllCurriculumStudyInfo() {
        return Result.success(cSService.list(), ResultCode.SUCCESS_GET_DATA);
    }

    @GetMapping("/getById/{id}")
    @ApiOperation("通过编号获取修读信息信息")
    public ResponseEntity<Result> getCurriculumStudyById(@ApiParam("修读信息编号") @PathVariable Long id) {
        return Result.success(cSService.getById(id), ResultCode.SUCCESS_GET_DATA);
    }

    @PostMapping("/add")
    @ApiOperation("增加修读信息信息")
    public ResponseEntity<Result> addCurriculumStudy(@ApiParam("修读信息信息") @RequestBody CurriculumStudy cs) {
        return Result.success(cSService.save(cs), ResultCode.SUCCESS_ADD_DATA);
    }

    @PutMapping("/update")
    @ApiOperation("修改修读信息信息")
    public ResponseEntity<Result> updateCurriculumStudy(@ApiParam("修读信息信息") @RequestBody CurriculumStudy cs) {
        return Result.success(cSService.updateById(cs), ResultCode.SUCCESS_UPDATE_DATA);
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("通过编号删除修读信息信息")
    public ResponseEntity<Result> removeCurriculumStudyById(@ApiParam("修读信息编号") @PathVariable Long id) {
        return Result.success(cSService.removeById(id), ResultCode.SUCCESS_DELETE_DATA);
    }
}
