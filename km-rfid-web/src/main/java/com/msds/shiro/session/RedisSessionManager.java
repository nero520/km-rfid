package com.msds.shiro.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import redis.clients.jedis.exceptions.JedisException;

import com.msds.util.RedisUtil;

/**
 * 创建时间：2014-10-20 下午2:25:08 项目名称：car_zone_web
 * 
 * @author lizhe
 * @version 1.0
 * @since JDK 1.6.0_21
 */
@Service
public class RedisSessionManager implements LocalSessionManaer {
	Logger logger = Logger.getLogger(RedisSessionManager.class);
	/**
	 * redis session key前缀
	 */
	private final String REDIS_SHIRO_SESSION = "shiro-session:";

	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null) {
			logger.error("session或者session id为空");
			return;
		}
		try {
			RedisUtil.setValue(getRedisSessionKey(session.getId()), session,
					session.getTimeout(), TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			logger.error("保存session失败");
		}
	}

	@Override
	public void deleteSession(Serializable id) {
		if (id == null) {
			logger.error("id为空");
			return;
		}
		try {
			RedisUtil.delValue(getRedisSessionKey(id));
		} catch (JedisException e) {
			logger.error("删除session失败");
		}
	}

	@Override
	public Session getSession(Serializable id) {
		if (id == null) {
			logger.error("id为空");
			return null;
		}
		Session session = null;
		try {

			session = RedisUtil.getValue(getRedisSessionKey(id));
		} catch (JedisException e) {
			logger.error("获取id为" + id + "的session失败");
		}
		return session;
	}

	@Override
	public Collection<Session> getAllSessions() {
		Set<Session> sessions = new HashSet<Session>();
		try {
			Set<String> keys = RedisUtil.keys(this.REDIS_SHIRO_SESSION + "*");
			if (keys != null && keys.size() > 0) {
				for (String key : keys) {
					Session s = getSession(key);
					sessions.add(s);
				}
			}
		} catch (JedisException e) {
			logger.error("获取所有session失败");
		}
		return sessions;
	}

	/**
	 * 获取redis中的session key
	 * 
	 * @param sessionId
	 * @return
	 */
	private String getRedisSessionKey(Serializable sessionId) {
		return this.REDIS_SHIRO_SESSION + sessionId;
	}
}
