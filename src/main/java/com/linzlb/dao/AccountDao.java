package com.linzlb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.linzlb.entity.Account;
/**
 * 账户Dao接口
 * @author user
 *
 */
public interface AccountDao extends JpaRepository<Account, Integer>{

}
