package com.minimall.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yanxubin
 * @Description
 * @date:2019/8/13
 * @mail yxb_825@163.com
 */

@SpringBootApplication(scanBasePackages = {"com.minimall.*"})
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.minimall.*"})
public class AdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
