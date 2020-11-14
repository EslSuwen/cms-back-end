package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.output.CourseTagDto;
import com.cqjtu.cms.model.dto.output.ProcessTagDto;
import com.cqjtu.cms.model.entity.ProcessTag;

import java.util.List;

/**
 * 课程平台关联课程 服务类
 *
 * @author suwen
 * @since 2020-11-14
 */
public interface ProcessTagService extends IService<ProcessTag> {
  /**
   * 通过tagId,term查询
   *
   * @param tagId 课程平台编号
   * @param majorId 专业编号
   * @param term 学期
   * @return java.util.List<com.cqjtu.cms.model.dto.output.CourseTagDto>
   * @author suwen
   * @date 2020/11/8 9:41
   */
  List<ProcessTagDto> getByTagIdAndTerm(Integer tagId, Integer majorId, String term);
}
