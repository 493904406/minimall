package com.minimall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }
}

