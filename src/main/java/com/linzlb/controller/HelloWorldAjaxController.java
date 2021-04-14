package com.linzlb.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 返回ajax json格式
 * @author user
 *
 */
//@Api(value="HelloWorldAjaxController", tags={"HelloWorldAjaxController接口"})
@ApiIgnore
@RestController //使用ajax刷新的时候用这个
@RequestMapping("/ajax")
public class HelloWorldAjaxController {
 
    @RequestMapping("/hello")
    public String say(){
        return "{'message1': 'SpringBoot你大爷','message2','SpringBoot你大爷2'}";
    }
}