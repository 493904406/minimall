package com.minimall.user.domain.dto;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/3
 * @mail yxb_825@163.com
 */
public class WxLoginInfo {
    private String code;
    private UserInfo userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
