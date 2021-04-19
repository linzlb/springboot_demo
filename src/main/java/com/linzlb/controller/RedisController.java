package com.linzlb.controller;

import com.linzlb.dao.RedisDao;
import com.linzlb.dto.ResponseDto;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/16 17:47
 * @Function: test Redis
 */
@Api(value="RedisController", tags={"Redis接口"})
@RestController
public class RedisController {

    //测试一下集成redis
    @Autowired
    RedisDao redisDao;

    @ApiOperation(value = "测试Redis集成情况", notes = "测试Redis集成情况")
    @RequestMapping(value = "/testRedis" , method= {RequestMethod.GET} )
    public ResponseDto testRedis(){
        try {
            redisDao.setKey("name","linzlb");
            redisDao.setKey("age","28");
            System.out.println(redisDao.getValue("name"));
            System.out.println(redisDao.getValue("age"));
            return ResponseResultUtil.generateSuccessResult(redisDao.getValue("name")+"-"+redisDao.getValue("age"));
        }catch (Exception e){
            return ResponseResultUtil.generateErrorResult("100001", e.getMessage());
        }
    }

}
