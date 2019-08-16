package com.minimall.common.responseDto;


import com.minimall.common.enums.ExceptionCode;

/**
 * @author yanxubin
 * @Description
 * @date:2019/8/16
 * @mail yxb_825@163.com
 */
public class ResponseEntityFactory {
    /**
     * 生成ResponseEntity: 一般在系统异常的情况下使用
     *
     * @return
     */
    public static ResponseEntity build() {
        return build(ExceptionCode.OK);
    }

    /**
     * 生成ResponseEntity: 一般在系统异常的情况下使用
     *
     * @param exceptionCode
     * @return
     */
    public static ResponseEntity build(ExceptionCode exceptionCode) {
        return build(exceptionCode.getCode(), exceptionCode.getMsg(), null);
    }

    /**
     * 生成ResponseEntity : 一般在业务正常的情况下使用
     *
     * @param result
     * @return
     */
    public static ResponseEntity build(Object result) {
        return build(ExceptionCode.OK.getCode(), ExceptionCode.OK.getMsg(), result);
    }

    /**
     * 生成ResponseEntity
     *
     * @param code
     * @param msg
     * @param result
     * @return
     * @throws Exception
     */
    public static ResponseEntity build(Integer code, String msg, Object result) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(code);
        responseEntity.setMsg(msg);
        if (result != null) {
            responseEntity.setResult(result);
        }
        return responseEntity;
    }

    public static ResponseEntity build(ServiceResponse serviceResp){
        return build(Integer.valueOf(serviceResp.getCode()),serviceResp.getMsg(),serviceResp.getResult());
    }
}
