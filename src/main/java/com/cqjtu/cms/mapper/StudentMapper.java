package com.cqjtu.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqjtu.cms.model.dto.output.StudentDto;
import com.cqjtu.cms.model.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * 学生信息表 Mapper 接口
 *
 * @author suwen
 * @since 2020-10-25
 */
public interface StudentMapper extends BaseMapper<Student> {

  /**
   * 通过学生编号获取信息
   *
   * @param sno 学生编号
   * @return 学生信息
   * @author suwen
   */
  StudentDto getInfoBySno(@Param("sno") String sno);
}
