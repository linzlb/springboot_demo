package com.linzlb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
/**
 * 用户Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
 
    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("login");
        return "测试拦截器";
    }
}
