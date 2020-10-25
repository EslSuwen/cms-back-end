package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.entity.CurriculumStudy;

/**
 * 学生课程信息修读表 Mapper 接口
 *
 * @author suwen
 * @since 2020-10-25
 */
public interface CurriculumStudyMapper extends BaseMapper<CurriculumStudy> {


    String getSumCredit(String sno, String courseType, String courseAttribute);
}
