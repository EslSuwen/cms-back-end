package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.CourseTagMapper;
import com.cqjtu.cms.model.entity.CourseTag;
import com.cqjtu.cms.service.CourseTagService;
import org.springframework.stereotype.Service;

/**
 * 课程平台关联课程 服务实现类
 *
 * @author suwen
 * @since 2020-11-05
 */
@Service
public class CourseTagServiceImpl extends ServiceImpl<CourseTagMapper, CourseTag>
    implements CourseTagService {}
