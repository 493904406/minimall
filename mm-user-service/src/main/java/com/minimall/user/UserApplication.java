package com.minimall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.minimall.user.mapper"})
public class UserApplication{
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
