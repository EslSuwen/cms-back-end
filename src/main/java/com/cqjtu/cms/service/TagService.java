package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.output.TagDto;
import com.cqjtu.cms.model.entity.Tag;

import java.util.List;

/**
 * 课程平台关系表 服务类
 *
 * @author suwen
 * @since 2020-11-05
 */
public interface TagService extends IService<Tag> {

    /**
     * 通过课程类别编号获取课程平台信息
     *
     * @param categoryId 课程类别编号
     * @return java.util.List<com.cqjtu.cms.model.dto.output.TagDto>
     * @author suwen
     * @date 2020/11/8 9:02
     */
   List<TagDto> getByCategoryId(Integer categoryId);
}
