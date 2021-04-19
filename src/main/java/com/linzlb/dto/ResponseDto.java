package com.linzlb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/17 11:18
 * @Function:统一异常处理，统一返回的对象
 */
@Data
public class ResponseDto<T> {

    private String code;//返回码

    private String msg;//返回信息

    //加上这个，当body为null当时候不返回
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;//返回报文
}
