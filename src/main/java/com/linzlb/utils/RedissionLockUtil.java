package com.linzlb.utils;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.redisson.api.RLock;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedissionLockUtil {

    /**
      * 加锁 30s释放
      * @param lockname 名称
      */
    public Boolean lock(RedissonClient redissonClient, String lockname){
        try {
            if(null == redissonClient){
                log.error("RedissonClient is null");
                return false;
            }
            RLock lock = redissonClient.getLock(lockname);
            lock.lock(30, TimeUnit.SECONDS); //30秒后释放锁，防止客户端引起的死锁
            log.info("Thread [{}] lock [{}] success",Thread.currentThread().getName(),lockname);
            return true;
        } catch (Exception e) {
            log.info("lock [{}] exception",lockname,e);
            return false;
        }
    }

    /**
     * 释放锁
     * @param lockname 名称
     */
    public Boolean unlock(RedissonClient redissonClient, String lockname){
        try {
            if(null == redissonClient){
                log.error("RedissonClient is null");
               return false;
            }
            RLock lock = redissonClient.getLock(lockname);
            lock.unlock();
            log.info("Thread [{}] unlock [{}] success",Thread.currentThread().getName(),lockname);
            return true;
        } catch (Exception e) {
            log.info("unlock [{}] exception",lockname,e);
            return false;
        }
    }
}