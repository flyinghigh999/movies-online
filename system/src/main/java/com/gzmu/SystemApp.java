package com.gzmu;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 系统模块
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.gzmu.server.mapper")
public class SystemApp {
    private static final Logger LOG = LoggerFactory.getLogger(SystemApp.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemApp.class);
        ConfigurableEnvironment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("System地址：\thttp://127.0.0.1:{}",env.getProperty("server.port"));
    }
}
