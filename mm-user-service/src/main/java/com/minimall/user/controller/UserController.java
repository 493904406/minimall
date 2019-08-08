package com.minimall.user.controller;

import com.minimall.common.entity.User;
import com.minimall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/all")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }
}

