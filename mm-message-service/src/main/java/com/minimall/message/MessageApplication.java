package com.minimall.message;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

}
