//package com.linzlb.controller;
//
//import io.swagger.annotations.Api;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * 用户Controller
// * @author Administrator
// */
//@Api(value="用户Controller", tags={"用户接口"})
//@Controller
////@RequestMapping(value = "/user")
//@RequestMapping(value = "/user" , method= {RequestMethod.GET} )
//public class UserController {
//
//    @ResponseBody
//    @RequestMapping(value = "/login")
//    public String login(){
//        System.out.println("login");
//        return "测试拦截器";//没必要专门写个类，拦截的是所有controller
//    }
//}
