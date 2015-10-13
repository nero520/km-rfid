package com.msds.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpServletRequestRedisWrapper extends
		javax.servlet.http.HttpServletRequestWrapper {

	String sid = "";

	public HttpServletRequestRedisWrapper(String sid, HttpServletRequest arg0) {
		super(arg0);
		this.sid = sid;
	}

	public HttpSession getSession(boolean create) {
		return new HttpSessionSidRedisWrapper(this.sid,
				super.getSession(create));
	}

	public HttpSession getSession() {
		return new HttpSessionSidRedisWrapper(this.sid, super.getSession());
	}

}
