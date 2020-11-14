package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.output.CategoryDto;
import com.cqjtu.cms.model.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程类别表 Mapper 接口
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 通过专业编号年级获取课程类别信息
     *
     * @param majorId 专业编号
     * @param grade 年级
     * @return java.util.List<com.cqjtu.cms.model.dto.output.CategoryDto>
     * @author suwen
     * @date 2020/11/8 9:18
     */
    List<CategoryDto> getByMajorIdAndGrade(Integer majorId,Integer grade);
}
