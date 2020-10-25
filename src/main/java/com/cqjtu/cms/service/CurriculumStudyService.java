package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.entity.CurriculumStudy;

/**
 * 学生课程信息修读表 服务类
 *
 * @author suwen
 * @since 2020-10-25
 */
public interface CurriculumStudyService extends IService<CurriculumStudy> {
    String getSumCredit(String sno, String courseType, String courseAttribute);
}
