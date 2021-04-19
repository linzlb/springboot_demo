package com.linzlb.utils;

import com.linzlb.consts.ExceptionEnum;
import com.linzlb.dto.ResponseDto;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/19 15:40
 * @Function: 避免每次重复的set操作
 */
public class ResponseResultUtil {

    //成功返回
    public static ResponseDto generateSuccessResult(final Object obj) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(ExceptionEnum.SUCCESS.getCode());
        responseDto.setMsg(ExceptionEnum.SUCCESS.getMsg());
        if (obj != null) {
            responseDto.setBody(obj);
        }
        return responseDto;
    }

    //失败返回
    public static ResponseDto generateErrorResult(final String errorCode, final String errorMsg) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(ExceptionEnum.UNKNOWN_ERROR.getCode());
        responseDto.setMsg(ExceptionEnum.UNKNOWN_ERROR.getMsg());
        return responseDto;
    }
}
