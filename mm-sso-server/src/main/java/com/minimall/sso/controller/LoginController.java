package com.minimall.sso.controller;

import com.minimall.common.enums.BaseResponseCode;
import com.minimall.common.responseDto.ResponseEntity;
import com.minimall.common.responseDto.ResponseEntityFactory;
import com.minimall.common.responseDto.ServiceResponse;
import com.minimall.sso.domain.requestparam.LoginParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanxubin
 * @Description
 * @date:2019/8/16
 * @mail yxb_825@163.com
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginParam loginParam){
        ServiceResponse serviceResponse = new ServiceResponse();
        if (loginParam.getUsername().equals("yanxubin") && loginParam.getPassword().equals("123456")){
            serviceResponse.setCode(BaseResponseCode.SUCCESS.getCode());
        }else {
            serviceResponse.setCode(BaseResponseCode.FAILURE.getCode());
            serviceResponse.setMsg(BaseResponseCode.FAILURE.getMsg());
        }
        return ResponseEntityFactory.build(serviceResponse);
    }
}
