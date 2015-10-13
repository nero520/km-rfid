package com.msds.session;

import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import com.msds.util.RedisUtil;

public class HttpSessionSidRedisWrapper extends HttpSessionWrapper {

	private String sid = "sid:";
	private static final long timeout = 7 * 24 * 60;

	public HttpSessionSidRedisWrapper(String sid, HttpSession session) {
		super(session);
		this.sid += sid;
	}

	public Object getAttribute(String name) {
		RedisUtil.expire(this.sid, timeout, TimeUnit.MINUTES);
		return RedisUtil.getMapValue(this.sid, name);
	}

	@SuppressWarnings("rawtypes")
	public Enumeration getAttributeNames() {
		RedisUtil.expire(this.sid, timeout, TimeUnit.MINUTES);
		return (new Enumerator(RedisUtil.getMapKeys(this.sid), true));
	}

	public void invalidate() {
		RedisUtil.delValue(this.sid);
		super.invalidate();
	}

	public void removeAttribute(String name) {
		RedisUtil.delMapValue(this.sid, name);
	}

	public void setAttribute(String name, Object value) {
		RedisUtil.setMapValue(this.sid, name, value, timeout, TimeUnit.MINUTES);
	}

}
