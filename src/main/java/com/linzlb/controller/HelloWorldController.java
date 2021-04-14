package com.linzlb.controller;

import com.linzlb.configuration.LinzlbProperties;
import com.linzlb.dao.RedisDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/16 17:47
 * @Function: 自定义属性：需要读取配置文件的值只需要加@Value(“${属性名}”)
 */
@ApiIgnore
@RestController
public class HelloWorldController {

    //直接注入
    @Value("${helloWorld}")
    private String helloWorld;

    @Value("${linzlb.a}")
    private String a;

    @Value("${linzlb.b}")
    private String b;

    //使用ConfigurationProperties配置方式注入
    @Autowired
    private LinzlbProperties linzlbproperties;

    @RequestMapping("/hello")
    public String say(){
        return helloWorld;
    }

    @RequestMapping("/showLinzlbab")
    public String showLinzlbab(){
        return "linzlb.a="+a+"<br/>"
                +"linzlb.b="+b;
    }
    @RequestMapping("/showLinzlbxyz")
    public String showLinzlbxyz(){
        return "linzlb.x="+linzlbproperties.getX()+"<br/>"
                +"linzlb.y="+linzlbproperties.getY()+"<br/>"
                +"linzlb.z="+linzlbproperties.getZ();
    }


    //测试一下集成redis
    @Autowired
    RedisDao redisDao;
    @RequestMapping("/testRedis")
    public String testRedis(){
		redisDao.setKey("name","linzlb");
		redisDao.setKey("age","28");
		System.out.println(redisDao.getValue("name"));
		System.out.println(redisDao.getValue("age"));
		return redisDao.getValue("name")+"-"+redisDao.getValue("age");
    }

}
