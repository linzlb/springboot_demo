package com.linzlb.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.linzlb.service.AccountService;

/**
 * 账户Controoler类
 * @author user
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController {
 
    @Resource
    private AccountService accountService;
     
    @RequestMapping("/transfer")
    public String transferAccounts(){
        try{
            accountService.transferAccounts(1, 2, 100);
            return "ok";
        }catch(Exception e){
            return "no";
        }
    }

}
