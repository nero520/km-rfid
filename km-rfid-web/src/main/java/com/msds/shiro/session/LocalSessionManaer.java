package com.msds.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * 创建时间：2014-10-20 下午2:20:40 项目名称：car_zone_web
 * 
 * @author lizhe
 * @version 1.0
 * @since JDK 1.6.0_21
 */
public interface LocalSessionManaer {
	void saveSession(Session session);

	void deleteSession(Serializable sessionId);

	Session getSession(Serializable sessionId);

	Collection<Session> getAllSessions();
}
