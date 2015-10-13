package com.msds.baseinfo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.msds.baseinfo.entity.AuthUser;
import com.msds.shiro.exception.VerificationCodeException;
import com.msds.shiro.filter.Constants;

/**
 * 登录
 * 
 */
@Controller
public class LoginController extends CommonActionSupport {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		AuthUser user = getUser();
		modelMap.put(Constants.CURRENT_USER, user);
		request.getSession().setAttribute(Constants.CURRENT_USER, user);
		return "/index";
	}

	/**
	 * 退出登录 清空session
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		this.getRequest().getSession().invalidate();
		return "/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		if (null != SecurityUtils.getSubject().getPrincipal()) {
			return "redirect:/index.action";
		}
		return "/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) {
		String exceptionClassName = (String) req
				.getAttribute("shiroLoginFailure");
		String error = "";
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(
				exceptionClassName)) {
			error = "用户名/密码错误";

		} else if (VerificationCodeException.class.getName().equals(
				exceptionClassName)) {
			error = "验证码错误";

		} else if (ExcessiveAttemptsException.class.getName().equals(
				exceptionClassName)) {
			error = "验证错误次数超过5次,请稍后重试！";

		} else if (LockedAccountException.class.getName().equals(
				exceptionClassName)) {
			error = "账号锁定，请与管理员联系";

		} else {
			error = "其他错误";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("error", error);
		return new ModelAndView("/login/login", map);
	}

}
