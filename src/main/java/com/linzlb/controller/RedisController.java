package com.linzlb.controller;

import com.linzlb.dao.RedisDao;
import com.linzlb.dto.ResponseDto;
import com.linzlb.utils.RedissionLockUtil;
import com.linzlb.utils.RedissionUtils;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/16 17:47
 * @Function: test Redis
 */
@Api(value="RedisController", tags={"Redis接口"})
@RestController
public class RedisController {

    private org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(RedisController.class);

    //测试一下集成redis
    @Autowired
    RedisDao redisDao;
    @Autowired
    private RedissionLockUtil redissionLockUtil;
    @Autowired
    private RedissionUtils redissionUtils;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;


    //原生
    @ApiOperation(value = "测试Redis集成情况", notes = "测试Redis集成情况")
    @RequestMapping(value = "/testRedis" , method= {RequestMethod.GET} )
    public ResponseDto testRedis(){
        try {
            redisDao.setKey("name","linzlb");
            redisDao.setKey("age","28");
            System.out.println(redisDao.getValue("name"));
            System.out.println(redisDao.getValue("age"));
            return ResponseResultUtil.generateSuccessResult(redisDao.getValue("name")+"-"+redisDao.getValue("age"));
        }catch (Exception e){
            return ResponseResultUtil.generateErrorResult("100001", e.getMessage());
        }
    }


    @ApiOperation(value = "测试redisLock", notes = "测试redisLock")
    @RequestMapping(value = "/redission" , method= {RequestMethod.GET} )
    public void redisLock() throws IOException, InterruptedException {

        //logger.info(host+port+password+database);
        Config config = new Config();
        String url = "redis://" + host + ":" + port;
		config.useSingleServer().setAddress(url);
        RedissonClient redission = //redissionUtils.getInstance().getRedisson(config);
            //不应该像上面这样，通过类实例来访问静态变量 这样会增肌编译器解析成本
            RedissionUtils.getInstance().getRedisson(config);

        //testRedisLock
        for (int i = 0;i < 50;i++) {
            new Thread(() -> {
                redissionLockUtil.lock(redission, "testLock");
            }).start();
        }


        // Redisson的分布式可重入锁RLock 最常见的使用方法
//        RLock lock = redission.getLock("anyLock");
//        lock.lock();
//        lock.unlock();
        //另外Redisson还通过加锁的方法提供了leaseTime的参数来指定加锁的时间。超过这个时间后锁便自动解开了。
        // 加锁以后10秒钟自动解锁
        // 无需调用unlock方法手动解锁
//        lock.lock(10, TimeUnit.SECONDS);
        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
//        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
//        if (res) {
//            try {
//
//            } finally {
//                lock.unlock();
//            }
//        }
        //大家都知道，如果负责储存这个分布式锁的Redisson节点宕机以后，而且这个锁正好处于锁住的状态时，这个锁会出现锁死的状态。为了避免这种情况的发生，Redisson内部提供了一个监控锁的看门狗，它的作用是在Redisson实例被关闭前，不断的延长锁的有效期。默认情况下，看门狗的检查锁的超时时间是30秒钟，也可以通过修改Config.lockWatchdogTimeout来另行指定。
//        Redisson同时还为分布式锁提供了异步执行的相关方法：
//        RLock lock = redisson.getLock("anyLock");
//        lock.lockAsync();
//        lock.lockAsync(10, TimeUnit.SECONDS);
//        Future<Boolean> res = lock.tryLockAsync(100, 10, TimeUnit.SECONDS);

//https://blog.csdn.net/liuxiao723846/article/details/88131065?utm_term=redission%E5%88%86%E5%B8%83%E5%BC%8F%E9%94%81&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-2-88131065&spm=3001.4430

//        分布式AtomicLong
//        RAtomicLong atomicLong = redission.getAtomicLong("myAtomicLong");
//        atomicLong.set(3);
//        atomicLong.incrementAndGet();
//        logger.info(atomicLong.get());

//        RList<String> list = redission.getList("anyList");
//        list.add(new String("abc"));
//        list.get(0);
//        logger.info(list.get(0));
//        list.remove(new String("abc"));
//
//        RBlockingQueue<String> queue = redission.getBlockingQueue("anyQueue");
//        queue.offer(new String("abc"));
//        String obj = queue.peek();
//        String someObj = queue.poll();
//        String ob = queue.poll(10, TimeUnit.MINUTES);
//        logger.info(ob);

//        RMap<String, String> map = redission.getMap("anyMap");
//        String prevObject = map.put("123", new String("123"));
//        String currentObject = map.putIfAbsent("323", new String("323"));
//        String obj = map.remove("123");
//        map.fastPut("321", new String("321"));
//        map.fastRemove("321");
//        Future<String> putAsyncFuture = map.putAsync("321");
//        Future<Void> fastPutAsyncFuture = map.fastPutAsync("321");
//        map.fastPutAsync("321", new String("321"));
//        map.fastRemoveAsync("321");

    }


}
