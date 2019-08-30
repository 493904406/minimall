package com.minimall.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yanxubin
 * @Description
 * @date:2019/8/28
 * @mail yxb_825@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.minimall.sso.dao")
public class SsoApplication{
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }

}
