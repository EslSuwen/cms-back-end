package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.CourseMapper;
import com.cqjtu.cms.model.entity.Course;
import com.cqjtu.cms.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * 课程表 服务实现类
 *
 * @author suwen
 * @since 2020-11-05
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {}
