package com.msds.baseinfo.common;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.msds.baseinfo.entity.AuthUser;
import com.msds.shiro.filter.Constants;

/**
 * 用户信息
 *
 */
public class UserInfo {
	
	
	private AuthUser user;
	
	public UserInfo() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		user = (AuthUser)request.getSession().getAttribute(Constants.CURRENT_USER);
	}
	public AuthUser getUser() {
		return user;
	}

	public void setUser(AuthUser user) {
		this.user = user;
	}




}
