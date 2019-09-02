package com.minimall.user.annotation.support;

import com.minimall.user.annotation.LoginUser;
import com.minimall.user.service.impl.UserTokenManager;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author yanxubin
 * @Description
 * @date:2019/9/3
 * @mail yxb_825@163.com
 */
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    public static final String LOGIN_TOKEN_KEY = "X-Litemall-Token";
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Integer.class)&&parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

//        return new Integer(1);
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        if(token == null || token.isEmpty()){
            return null;
        }

        return UserTokenManager.getUserId(token);
    }
}
