package com.minimall.db;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/11
 * @mail yxb_825@163.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.minimall.db.dao"})
public class DbApplication{
    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }
}

