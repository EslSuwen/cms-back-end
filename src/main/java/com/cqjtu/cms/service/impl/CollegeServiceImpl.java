package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.CollegeMapper;
import com.cqjtu.cms.model.entity.College;
import com.cqjtu.cms.service.CollegeService;
import org.springframework.stereotype.Service;

/**
 * 学院表 服务实现类
 *
 * @author suwen
 * @since 2020-11-05
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService {}
