package com.minimall.user.controller;

import com.minimall.user.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(){
        return schedualServiceHi.sayHiFromClientOne();
    }
}