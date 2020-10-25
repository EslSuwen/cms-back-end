package com.cqjtu.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 启动入口
 *
 * @author suwen
 * @date 2020/10/25 10:41
 */
@MapperScan(basePackages = {"com.cqjtu.cms.mapper"})
@SpringBootApplication
public class CmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(CmsApplication.class, args);
  }
}
