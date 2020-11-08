package com.cqjtu.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cms.mapper.StudentMapper;
import com.cqjtu.cms.model.dto.StudentDto;
import com.cqjtu.cms.model.entity.Student;
import com.cqjtu.cms.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * 学生信息表 服务实现类
 *
 * @author suwen
 * @since 2020-10-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

  @Override
  public StudentDto getInfoBySno(String sno) {
    return baseMapper.getInfoBySno(sno);
  }
}
