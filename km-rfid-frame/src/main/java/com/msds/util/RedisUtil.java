package com.msds.util;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import com.msds.setting.SettingUtils;

/**
 * 简单封装redis操作 <br>
 * 目前没有从DB层面做项目间区分，仅仅通过项目前缀
 * 
 * @author LiLong
 * 
 */
public class RedisUtil {

	@SuppressWarnings("unchecked")
	private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringUtils
			.getBean("redisTemplate");
	/** 缓存前缀，用于项目间区分 */
	private static String CACHE_NAME = SettingUtils.get().getCacheName();

	private RedisUtil() {
	}

	/**
	 * 保存数据到redis
	 * 
	 * @Description TODO
	 * @param key
	 * @param value
	 * @return void
	 */
	public static void setValue(String key, Object value) {
		redisTemplate.opsForValue().set(CACHE_NAME + key, value);
	}

	/**
	 * 保存数据到redis，有时效时间
	 * 
	 * @Description TODO
	 * @param key
	 * @param value
	 * @param timeout
	 * @param timeType
	 * @return void
	 */
	public static void setValue(String key, Object value, long timeout,
			TimeUnit timeType) {
		redisTemplate.opsForValue().set(CACHE_NAME + key, value);
		expire(key, timeout, timeType);
	}

	/**
	 * 保存Map值数据到redis
	 * 
	 * @Description TODO
	 * @param key
	 * @param hashKey
	 * @param value
	 * @return void
	 */
	public static void setMapValue(String key, String hashKey, Object value) {
		redisTemplate.opsForHash().put(CACHE_NAME + key, hashKey, value);
	}

	/**
	 * 保存Map值数据到redis，有时效时间
	 * 
	 * @Description TODO
	 * @param key
	 * @param hashKey
	 * @param value
	 * @param timeout
	 * @param timeType
	 * @return void
	 */
	public static void setMapValue(String key, String hashKey, Object value,
			long timeout, TimeUnit timeType) {
		redisTemplate.opsForHash().put(CACHE_NAME + key, hashKey, value);
		expire(key, timeout, timeType);
	}

	/**
	 * redis中获取数据
	 * 
	 * @Description TODO
	 * @param key
	 * @return
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(String key) {
		return (T) redisTemplate.opsForValue().get(CACHE_NAME + key);
	}

	/**
	 * redis中获取Map值数据
	 * 
	 * @Description TODO
	 * @param key
	 * @param hashKey
	 * @return
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getMapValue(String key, String hashKey) {
		return (T) redisTemplate.opsForHash().get(CACHE_NAME + key, hashKey);
	}

	/**
	 * 删除redis里某个Map中的值
	 * 
	 * @Description TODO
	 * @param key
	 * @param hashKey
	 * @return void
	 */
	public static void delMapValue(String key, String hashKey) {
		redisTemplate.opsForHash().delete(CACHE_NAME + key, hashKey);
	}

	/**
	 * 删除redis中某个值
	 * 
	 * @Description TODO
	 * @param key
	 * @return void
	 */
	public static void delValue(String key) {
		redisTemplate.delete(CACHE_NAME + key);
	}

	/**
	 * 设置失效时间
	 * 
	 * @Description TODO
	 * @param key
	 * @param timeout
	 * @param timeType
	 * @return void
	 */
	public static void expire(String key, long timeout, TimeUnit timeType) {
		redisTemplate.expire(CACHE_NAME + key, timeout, timeType);
	}

	/**
	 * 获取Map所有key
	 * 
	 * @Description TODO
	 * @param key
	 * @return
	 * @return Set<T>
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> getMapKeys(String key) {
		return (Set<T>) redisTemplate.opsForHash().keys(CACHE_NAME + key);
	}

	/**
	 * 判断时候存在这个key
	 * 
	 * @Description TODO
	 * @param key
	 * @return
	 * @return boolean
	 */
	public static boolean hasKey(String key) {
		return redisTemplate.hasKey(CACHE_NAME + key);
	}

	/**
	 * 获取满足条件的key集合
	 * 
	 * @Description TODO
	 * @param pattern
	 * @return
	 * @return Set<E>
	 */
	public static <E> Set<E> keys(String pattern) {
		return (Set<E>) redisTemplate.keys(pattern);
	}
    /**
	 * 数值增加(数字类型)
	 * 
	 * @Description TODO
	 * @param key
	 * @return
	 */
	public static Long incr(String key, long n) {
		return redisTemplate.opsForValue().increment(CACHE_NAME + key, n);
	}

   public static boolean zsetAadd(String key,Object value,double score){
		return redisTemplate.opsForZSet().add(CACHE_NAME + key, value, score);
	}
	
	public static Long zsetDel(String key,Object... value){
		return redisTemplate.opsForZSet().remove(CACHE_NAME + key, value);
	}
	
	public static Long zsetSize(String key){
		return redisTemplate.opsForZSet().size(CACHE_NAME + key);
	}
	
	/**
	 * 按照score正序分页查找zset 
	 * @param key
	 * @param start 起始条数（包含）
	 * @param end 结束条数（包含）
	 * @return
	 */
	public static Set zsetRange(String key,int start,int end){
		return redisTemplate.opsForZSet().range(CACHE_NAME + key, start, end);
	}
	

	/**
	 * 按照score倒序分页查找zset 
	 * @param key
	 * @param start 起始条数（包含）
	 * @param end 结束条数（包含）
	 * @return
	 */
	public static Set zsetRevRange(String key,int start,int end){
		return redisTemplate.opsForZSet().reverseRange(CACHE_NAME + key, start, end);
	}
	
	/**
	 * 放入列表尾部
	 * @param key
	 * @param value
	 * @return
	 */
	public static <V> Long  rpush(String key,V value){
		return redisTemplate.opsForList().rightPush(CACHE_NAME + key, value);
	}
	
	
	/**
	 * 查看列表大小
	 * @param key
	 * @return
	 */
	public static Long  llen(String key){
		return redisTemplate.opsForList().size(CACHE_NAME + key);
	}
	
	/**
	 * 查看列表数据
	 * @param key
	 * @param start 起始(包含)
	 * @param end 结束(包含)
	 * @return
	 */
	public static <V> List<V>  lrange(String key,int start,int end){
		return (List<V>)redisTemplate.opsForList().range(CACHE_NAME + key, start, end);
	}
	
	/**
	 * 从队头出队，先进先出
	 * @param key
	 * @return
	 */
	public static <V> V lpop(String key){
		return (V) redisTemplate.opsForList().leftPop(CACHE_NAME + key);
	}
	
	/**
	 * 删除指定的值
	 * @param key
	 * @param value 指定的值
	 * @return
	 */
	public static <V> V lremove(String key,V value){
		return (V) redisTemplate.opsForList().remove(CACHE_NAME + key, 0, value);
	}
}
