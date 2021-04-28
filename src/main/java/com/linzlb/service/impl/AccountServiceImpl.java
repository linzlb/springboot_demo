package com.linzlb.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.linzlb.dao.AccountDao;
import com.linzlb.entity.Account;
import com.linzlb.service.AccountService;

/**
 * 帐号Service实现类
 * @author user
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{
 
    @Resource
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transferAccounts(int fromUserId, int toUserId, float account) {
        Account fromUserAccount=accountDao.getOne(fromUserId);
        fromUserAccount.setBalance(fromUserAccount.getBalance()-account);
        accountDao.save(fromUserAccount); // fromUser扣钱
         
        Account toUserAccount=accountDao.getOne(toUserId);
        toUserAccount.setBalance(toUserAccount.getBalance()+account);
        int zero = 1/0;//模拟异常情况
        accountDao.save(toUserAccount); // toUser加钱
    }

}
