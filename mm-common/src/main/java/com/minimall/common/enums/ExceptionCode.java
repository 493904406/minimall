package com.minimall.common.enums;

/**
 * @author yanxubin
 * @Description 自定义错误码
 * @date:2019/8/16
 * @mail yxb_825@163.com
 */
public enum ExceptionCode {
    NO_MONEY(1008,"余额不足"),

    /********************** 系统相关开始  **********************/
    JSON_ERROR(1007,"JSON格式错误"),
    O2O_EXCEPTION(1006,"业务异常"),
    UNKNOWN_EXCEPTION(1005,"未知错误"),
    ILLEGAL_ARGUMENT_EXCEPTION(1004,"参数错误"),
    LIMITER_EXCEPTION(1003,"请求过于频繁，请稍后再试"),
    DATA_NOT_EXIST(1002,"数据不存在"),
    DATA_EXIST(1011, "数据存在"),
    DATA_EXCEPTION(1010,"数据异常"),
    PARAM_LOST(1001,"参数丢失"),
    SYSTEM_EXCEPTION(-1,"系统异常"),
    OK(0, "ok");
    /********************** 系统相关结束  **********************/
    private Integer code;
    private String msg;

    ExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
