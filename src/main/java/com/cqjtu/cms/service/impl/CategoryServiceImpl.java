package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.CategoryMapper;
import com.cqjtu.cms.model.dto.output.CategoryDto;
import com.cqjtu.cms.model.entity.Category;
import com.cqjtu.cms.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程类别表 服务实现类
 *
 * @author suwen
 * @since 2020-11-05
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService {

  @Override
  public List<CategoryDto> getByMajorIdAndGrade(Integer majorId, Integer grade) {
    return baseMapper.getByMajorIdAndGrade(majorId, grade);
  }

  @Override
  public List<Category> getByGrade(Integer grade) {
    return list(new QueryWrapper<Category>().eq("grade",grade));
  }
}
