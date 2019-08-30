package com.minimall.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService() {
        return restTemplate.getForObject("http://MM-USER-SERVICE/user/all",String.class);
    }

}

