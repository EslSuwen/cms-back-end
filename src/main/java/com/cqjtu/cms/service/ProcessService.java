package com.cqjtu.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqjtu.cms.model.dto.ImportDataOutputDTO;
import com.cqjtu.cms.model.entity.Process;

import java.util.List;

/**
 * 教学执行表 服务类
 *
 * @author suwen
 * @since 2020-11-13
 */
public interface ProcessService extends IService<Process> {

  /** 导入排课信息 */
  ImportDataOutputDTO importExcel(Integer majorId, Integer grade, List<Process> processList);
}
