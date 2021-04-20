package com.linzlb.utils;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedissionUtils {

	private org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(RedissionUtils.class);

	private static RedissionUtils redisUtils;

	/**
	 * 提供单例模式
	 *
	 * @return RedissionUtils
	 */
	public static RedissionUtils getInstance() {
		if (redisUtils == null) {
			synchronized (RedissionUtils.class) {
				if (redisUtils == null) {
					redisUtils = new RedissionUtils();
				}
			}
		}
		return redisUtils;
	}
 
	/**
	 * 使用config创建Redisson Redisson是用于连接Redis Server的基础类
	 * 
	 * @param config
	 * @return
	 */
	public RedissonClient getRedisson(Config config) {
		RedissonClient redisson = Redisson.create(config);
		logger.info("成功连接Redis Server");
		return redisson;
	}
 
	/**
	 * 使用ip地址和端口创建Redisson
	 * @return
	 */
	public RedissonClient getRedisson() {

		RedissonClient redissonClient;
		Config config = new Config();


//		String url = "redis://" + host
//				+ ":" + port;
//		config.useSingleServer().setAddress(url) //单机
//				.setPassword(password)
//				.setDatabase(database);
		String url = "redis://127.0.0.1:6379";
		config.useSingleServer().setAddress(url);
		//添加主从配置
		//config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
//		config.useMasterSlaveServers()
//				.setMasterAddress("127.0.0.1:6379")
//				.addSlaveAddress("127.0.0.1:6389", "127.0.0.1:6332", "127.0.0.1:6419")
//				.addSlaveAddress("127.0.0.1:6399");

		//哨兵
//		config.useSentinelServers()
//				.setMasterName("mymaster")
//				.addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
//				.addSentinelAddress("127.0.0.1:26319");

		//集群
		//config.useClusterServers().addNodeAddress(new String[]{"",""}).setPassword("");
//		config.useClusterServers()
//				.setScanInterval(2000) // cluster state scan interval in milliseconds
//				.addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001")
//				.addNodeAddress("127.0.0.1:7002");
		try {
			redissonClient = Redisson.create(config);
			logger.info("成功连接Redis Server" + "\t"
					+ "服务器");
			return redissonClient;
		} catch (Exception e) {
			log.error("RedissonClient init redis url :[{}]",url,e.getMessage());
			return null;
		}
	}
 
	/**
	 * 关闭Redisson客户端连接
	 * 
	 * @param redisson
	 */
	public void closeRedisson(RedissonClient redisson) {
		redisson.shutdown();
		logger.info("成功关闭Redis Client连接");
	}
 
	/**
	 * 获取字符串对象
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <T> RBucket<T> getRBucket(RedissonClient redisson, String objectName) {
		RBucket<T> bucket = redisson.getBucket(objectName);
		return bucket;
	}
 
	/**
	 * 获取Map对象
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <K, V> RMap<K, V> getRMap(RedissonClient redisson, String objectName) {
		RMap<K, V> map = redisson.getMap(objectName);
		return map;
	}
 
	/**
	 * 获取有序集合
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <V> RSortedSet<V> getRSortedSet(RedissonClient redisson,
										   String objectName) {
		RSortedSet<V> sortedSet = redisson.getSortedSet(objectName);
		return sortedSet;
	}
 
	/**
	 * 获取集合
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <V> RSet<V> getRSet(RedissonClient redisson, String objectName) {
		RSet<V> rSet = redisson.getSet(objectName);
		return rSet;
	}
 
	/**
	 * 获取列表
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <V> RList<V> getRList(RedissonClient redisson, String objectName) {
		RList<V> rList = redisson.getList(objectName);
		return rList;
	}
 
	/**
	 * 获取队列
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <V> RQueue<V> getRQueue(RedissonClient redisson, String objectName) {
		RQueue<V> rQueue = redisson.getQueue(objectName);
		return rQueue;
	}
 
	/**
	 * 获取双端队列
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public <V> RDeque<V> getRDeque(RedissonClient redisson, String objectName) {
		RDeque<V> rDeque = redisson.getDeque(objectName);
		return rDeque;
	}
 
	/**
	 * 此方法不可用在Redisson 1.2 中 在1.2.2版本中 可用
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	/**
	 * public <V> RBlockingQueue<V> getRBlockingQueue(RedissonClient
	 * redisson,String objectName){ RBlockingQueue
	 * rb=redisson.getBlockingQueue(objectName); return rb; }
	 */
 
	/**
	 * 获取锁
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public RLock getRLock(RedissonClient redisson, String objectName) {
		RLock rLock = redisson.getLock(objectName);
		return rLock;
	}
 
	/**
	 * 获取原子数
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public RAtomicLong getRAtomicLong(RedissonClient redisson, String objectName) {
		RAtomicLong rAtomicLong = redisson.getAtomicLong(objectName);
		return rAtomicLong;
	}
 
	/**
	 * 获取记数锁
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
	public RCountDownLatch getRCountDownLatch(RedissonClient redisson,
			String objectName) {
		RCountDownLatch rCountDownLatch = redisson
				.getCountDownLatch(objectName);
		return rCountDownLatch;
	}
 
	/**
	 * 获取消息的Topic
	 * 
	 * @param redisson
	 * @param objectName
	 * @return
	 */
//	public <M> RTopic<M> getRTopic(RedissonClient redisson, String objectName) {
//		RTopic<M> rTopic = redisson.getTopic(objectName);
//		return rTopic;
//	}
 
}

//原文链接：https://blog.csdn.net/liuxiao723846/article/details/88131065