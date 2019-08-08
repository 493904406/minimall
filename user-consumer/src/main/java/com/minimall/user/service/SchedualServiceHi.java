package com.minimall.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@FeignClient(value = "mm-user-service")
public interface SchedualServiceHi {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String sayHiFromClientOne();
}
