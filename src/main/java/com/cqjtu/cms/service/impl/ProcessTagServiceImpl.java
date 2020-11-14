package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.ProcessTagMapper;
import com.cqjtu.cms.model.dto.output.ProcessTagDto;
import com.cqjtu.cms.model.entity.ProcessTag;
import com.cqjtu.cms.service.ProcessTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程平台关联课程 服务实现类
 *
 * @author suwen
 * @since 2020-11-14
 */
@Service
public class ProcessTagServiceImpl extends ServiceImpl<ProcessTagMapper, ProcessTag>
    implements ProcessTagService {

  @Override
  public List<ProcessTagDto> getByTagIdAndTerm(Integer tagId, Integer majorId, String term) {
    return baseMapper.getByTagIdAndTerm(tagId, majorId, term);
  }
}
