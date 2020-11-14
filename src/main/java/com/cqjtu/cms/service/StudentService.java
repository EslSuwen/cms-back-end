package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.output.StudentDto;
import com.cqjtu.cms.model.entity.Student;

/**
 * 学生信息表 服务类
 *
 * @author suwen
 * @since 2020-10-25
 */
public interface StudentService extends IService<Student> {
    /**
     * 通过学生编号获取信息
     *
     * @param sno 学生编号
     * @return 学生信息
     * @author suwen
     */
    StudentDto getInfoBySno( String sno);
}
