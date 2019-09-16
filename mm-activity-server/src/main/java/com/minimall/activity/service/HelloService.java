package com.minimall.activity.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/12
 * @mail jiangbo.ge@kuwo.cn
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://MM-USER-SERVICE/user/all",String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
