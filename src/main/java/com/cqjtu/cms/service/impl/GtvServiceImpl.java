package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.entity.Gtv;
import com.cqjtu.cms.mapper.GtvMapper;
import com.cqjtu.cms.service.GtvService;
import org.springframework.stereotype.Service;

/**
 * 毕业学分阈值 graduate threshold value 服务实现类
 *
 * @author suwen
 * @since 2020-10-25
 */
@Service
public class GtvServiceImpl extends ServiceImpl<GtvMapper, Gtv> implements GtvService {}
