package com.minimall.common.entity;

import lombok.Data;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/8/8
 * @mail jiangbo.ge@kuwo.cn
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Integer sex;
    private String account;
    private String password;
}
