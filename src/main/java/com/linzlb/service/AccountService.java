package com.linzlb.service;

/**
 * 帐号Service接口
 * @author user
 *
 */
public interface AccountService {
 
    void transferAccounts(int fromUser,int toUser,float account);

}