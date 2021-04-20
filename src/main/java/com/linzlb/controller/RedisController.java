package com.linzlb.controller;

import com.linzlb.dao.RedisDao;
import com.linzlb.dto.ResponseDto;
import com.linzlb.utils.RedissionLockUtil;
import com.linzlb.utils.RedissionUtils;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/16 17:47
 * @Function: test Redis
 */
@Api(value="RedisController", tags={"Redis接口"})
@RestController
public class RedisController {

    private org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(RedisController.class);

    //测试一下集成redis
    @Autowired
    RedisDao redisDao;
    @Autowired
    private RedissionLockUtil redissionLockUtil;
    @Autowired
    private RedissionUtils redissionUtils;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;


    //原生
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


    @ApiOperation(value = "测试redisLock", notes = "测试redisLock")
    @RequestMapping(value = "/redisLock" , method= {RequestMethod.GET} )
    public void redisLock() throws IOException {

        logger.info(host+port+password+database);
        Config config = new Config();
        String url = "redis://" + host
				+ ":" + port;
		config.useSingleServer().setAddress(url);
        RedissonClient redission = redissionUtils.getInstance().getRedisson(config);
        for (int i = 0;i < 50;i++) {
            new Thread(() -> {
                redissionLockUtil.lock(redission, "testLock");
            }).start();
        }


        // 最常见的使用方法
//        RLock lock = redission.getLock("anyLock");
//        lock.lock();
//        logger.info("lock");
//        lock.unlock();
//        logger.info("unlock");
    }


}
