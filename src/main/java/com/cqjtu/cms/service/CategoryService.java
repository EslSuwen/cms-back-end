package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.output.CategoryDto;
import com.cqjtu.cms.model.entity.Category;

import java.util.List;

/**
 * 课程类别表 服务类
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface CategoryService extends IService<Category> {

  /**
   * 通过专业编号年级获取课程类别信息
   *
   * @param majorId 专业编号
   * @param grade 年级
   * @return java.util.List<com.cqjtu.cms.model.dto.output.CategoryDto>
   * @author suwen
   * @date 2020/11/8 9:18
   */
  List<CategoryDto> getByMajorIdAndGrade(Integer majorId, Integer grade);

  /**
   * 通过年级获取课程类别信息
   *
   * @param grade 年级
   * @return java.util.List<com.cqjtu.cms.model.dto.output.CategoryDto>
   * @author suwen
   * @date 2020/11/13 17:10
   */
  List<Category> getByGrade(Integer grade);
}
