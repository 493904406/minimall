package com.minimall.base.service.impl;


import com.minimall.common.utils.JwtHelper;

/**
 * @author yanxubin
 * @Description 维护用户token
 * @date:2019/9/10
 * @mail yxb_825@163.com
 */
public class UserTokenManager {
	public static String generateToken(Integer id) {
        JwtHelper jwtHelper = new JwtHelper();
        return jwtHelper.createToken(id);
    }
    public static Integer getUserId(String token) {
    	JwtHelper jwtHelper = new JwtHelper();
    	Integer userId = jwtHelper.verifyTokenAndGetUserId(token);
    	if(userId == null || userId == 0){
    		return null;
    	}
        return userId;
    }
}
