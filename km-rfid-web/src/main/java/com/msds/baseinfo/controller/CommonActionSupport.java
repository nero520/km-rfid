package com.msds.baseinfo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.msds.baseinfo.entity.AuthUser;
import com.msds.baseinfo.service.UserService;

/**
 * 公用的Action 配置 主要支持序列化对象
 * 
 */
public class CommonActionSupport {

	@Resource(name = "userServiceImpl")
	private UserService userService;

	public AuthUser getUser() {
		AuthUser user = userService.findByUsername((String) SecurityUtils
				.getSubject().getPrincipal());
		return user;
	}

	/**
	 * ajax 返回执行结果
	 * 
	 * @param success
	 *            0为成功，其他未失败
	 * @param message
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map returnMessage(int success, String message) {
		Map map = new HashMap<String, Object>();
		map.put("success", success);
		map.put("errorMsg", message);
		return map;
	}

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();

	}

}
