package com.linzlb.dto;

import lombok.Data;
import lombok.NonNull;
import sun.plugin2.message.Message;

import javax.validation.MessageInterpolator;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/17 11:39
 * @Function:s
 */
@Data
public class RequestDto<T> implements Serializable {

    @Pattern(regexp = "\\w+\\d+",message = "流水号需要符合\\w+\\d+的规则")
    private String seqNo;

    private T body;
}
