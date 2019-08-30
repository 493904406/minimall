package com.minimall.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author yanxubin
 * @Description
 * @date:2019/8/28
 * @mail yxb_825@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
@MapperScan(basePackages = "com.minimall.sso.dao")
public class SsoApplication extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }

}
