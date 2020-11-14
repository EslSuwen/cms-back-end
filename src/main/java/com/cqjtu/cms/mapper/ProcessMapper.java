package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.output.ProcessDto;
import com.cqjtu.cms.model.entity.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 教学执行表 Mapper 接口
 *
 * @author suwen
 * @since 2020-11-13
 */
public interface ProcessMapper extends BaseMapper<Process> {

  /**
   * 通过专业年级获取所有教学计划信息
   *
   * @param majorId 专业
   * @param grade 年级
   * @return java.util.List<com.cqjtu.cms.model.dto.output.ProcessDto>
   * @author suwen
   * @date 2020/11/14 17:27
   */
  List<ProcessDto> getByMajorAndGrade(@Param("majorId") Integer majorId, @Param("grade") Integer grade);
}
