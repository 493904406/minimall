package com.mm.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/12
 * @mail jiangbo.ge@kuwo.cn
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication{
    public static void main(String[] args) {
        SpringApplication.run( ServiceZuulApplication.class, args );
    }

}
