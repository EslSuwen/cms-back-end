package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.entity.CurriculumStudy;
import com.cqjtu.cms.mapper.CurriculumStudyMapper;
import com.cqjtu.cms.service.CurriculumStudyService;
import org.springframework.stereotype.Service;

/**
 * 学生课程信息修读表 服务实现类
 *
 * @author suwen
 * @since 2020-10-25
 */
@Service
public class CurriculumStudyServiceImpl extends ServiceImpl<CurriculumStudyMapper, CurriculumStudy>
    implements CurriculumStudyService {}
