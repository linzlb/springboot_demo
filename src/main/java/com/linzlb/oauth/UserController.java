//package com.linzlb.oauth;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 需要登录的接口用于测试
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @GetMapping("/getCurrentUser")
//    public Object getCurrentUser(Authentication authentication) {
//        return authentication.getPrincipal();
//    }
//}
