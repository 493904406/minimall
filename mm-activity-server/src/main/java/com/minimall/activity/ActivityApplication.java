package com.minimall.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/12
 * @mail jiangbo.ge@kuwo.cn
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients
@EnableHystrix
public class ActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
