package com.linzlb.aspect;

import com.linzlb.consts.ExceptionEnum;
import com.linzlb.dto.ResponseDto;
import com.linzlb.utils.ResponseResultUtil;
import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/19 16:18
 * @Function: 统一异常处理，全部没处理的地方都返回统一的报错
 */
@ControllerAdvice
public class UnKnownErrorHandle {

    private Logger logger = Logger.getLogger(UnKnownErrorHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDto handle(Exception e){
        logger.error(e.getMessage());
        return ResponseResultUtil.generateErrorResult(ExceptionEnum.UNKNOWN_ERROR.getCode(),ExceptionEnum.UNKNOWN_ERROR.getMsg());
    }
}
