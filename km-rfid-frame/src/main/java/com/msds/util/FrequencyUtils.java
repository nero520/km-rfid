package com.msds.util;

import java.util.concurrent.TimeUnit;

/**
 * 频率控制
 * 
 * @ClassName FrequencyUtils
 * @Description 可用于手机短息发送次数，密码错误次数等控制
 * @author LiLong
 * @date 2014年12月30日 上午9:42:39
 * 
 */
public class FrequencyUtils {
	/**
	 * 控制频率
	 * 
	 * @Description 时间间隔内超过控制次数，锁定一段时间
	 * @param key
	 *            需要控制的key
	 * @param intervalTime
	 *            时间间隔(分钟)
	 * @param count
	 *            控制次数
	 * @param lockTime
	 *            锁定时间(小时)
	 * @return
	 */
	public static boolean check(String key, int intervalTime, Integer count,
			int lockTime) {
		if (key == null)
			return false;
		Long sum = RedisUtil.incr(key, 1);
		if (sum == 1) {
			// RedisUtil.setValue(key, 0, intervalTime, TimeUnit.MINUTES);
			RedisUtil.expire(key, intervalTime, TimeUnit.MINUTES);
			return true;
		} else if (sum < count) {
			// sum++;
			// RedisUtil.setValue(key, sum);
			return true;
		} else if (sum > count) {
			return false;
		} else {
			// RedisUtil.setValue(key, sum, lockTime, TimeUnit.HOURS);
			RedisUtil.expire(key, lockTime, TimeUnit.HOURS);
			return false;
		}
	}

}
