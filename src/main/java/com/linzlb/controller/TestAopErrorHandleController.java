package com.linzlb.controller;

import com.linzlb.dto.ResponseDto;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/16 17:47
 * @Function: 测试统一异常处理
 */

@Api(value="TestAopErrorHandleController", tags={"TestAopErrorHandleController"})
@RestController
public class TestAopErrorHandleController {

    @ApiOperation(value = "测试统一异常处理", notes = "测试统一异常处理")
    @RequestMapping(value = "/testError" , method= {RequestMethod.GET} )
    public ResponseDto testError(){
        int i = 1/0;
        return ResponseResultUtil.generateSuccessResult(null);
    }
}
