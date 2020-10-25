package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.entity.Major;
import com.cqjtu.cms.mapper.MajorMapper;
import com.cqjtu.cms.service.MajorService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author suwen
 * @since 2020-10-25
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {}
