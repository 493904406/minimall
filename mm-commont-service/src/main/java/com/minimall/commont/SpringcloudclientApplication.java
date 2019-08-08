package com.minimall.commont;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringcloudclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudclientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}