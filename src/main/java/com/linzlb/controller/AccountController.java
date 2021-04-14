package com.linzlb.controller;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.linzlb.service.AccountService;

/**
 * 账户Controller类
 * @author user
 * https://xiaojin21cen.blog.csdn.net/article/details/78654652?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-5.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-5.control
 */
@Api(value="账户Controller", tags={"账户接口"})
@RestController
@RequestMapping("/account")
public class AccountController {
 
    @Resource
    private AccountService accountService;

    @ApiOperation(value = "账户转账", notes = "账户转账，不需要入参")
    @RequestMapping(value = "/transfer" , method= {RequestMethod.GET} )
    public String transferAccounts(){
        try{
            accountService.transferAccounts(1, 2, 100);
            return "ok";
        }catch(Exception e){
            return "no";
        }
    }

}
