package com.msds.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserFilter
 * @Description TODO
 * @author LiLong
 * @date 2015年6月1日 上午10:46:55
 * 
 */
public class UserFilter extends org.apache.shiro.web.filter.authc.UserFilter {

	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String requestType = httpServletRequest.getHeader("X-Requested-With");
		if (requestType != null
				&& requestType.equalsIgnoreCase("XMLHttpRequest")) {
			httpServletResponse.addHeader("loginStatus", "accessDenied");
			httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return super.onAccessDenied(request, response);
	}
}
