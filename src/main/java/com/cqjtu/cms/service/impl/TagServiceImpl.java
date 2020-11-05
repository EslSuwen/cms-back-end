package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.TagMapper;
import com.cqjtu.cms.model.entity.Tag;
import com.cqjtu.cms.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 课程平台关系表 服务实现类
 *
 * @author suwen
 * @since 2020-11-05
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {}
