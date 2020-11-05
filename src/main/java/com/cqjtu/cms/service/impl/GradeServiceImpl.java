package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.GradeMapper;
import com.cqjtu.cms.model.entity.Grade;
import com.cqjtu.cms.service.GradeService;
import org.springframework.stereotype.Service;

/**
 * 修读课程信息 服务实现类
 *
 * @author suwen
 * @since 2020-11-05
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {}
