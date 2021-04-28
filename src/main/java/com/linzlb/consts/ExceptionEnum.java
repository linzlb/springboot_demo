package com.linzlb.consts;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/19 16:23
 * @Function:异常错误码枚举
 */
public enum ExceptionEnum {

    SUCCESS("000000","success"),//正常返回
    UNKNOWN_ERROR("999999","UnknownError,Please contact the administrator");//统一异常返回

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
