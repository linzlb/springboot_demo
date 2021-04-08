package com.linzlb.dto;

import lombok.Data;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/17 11:18
 * @Function:
 */
@Data
public class ResponseDto<T> {

    private String code;

    private String msg;

    private T body;
}
