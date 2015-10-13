package com.msds.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将用户状态存储到Redis(Token方式)
 * 
 * @ClassName RedisTokenSessionFilter
 * @Description 通过RequestHeader中Token控制状态
 * @author LiLong
 * @date 2015年4月27日 下午2:38:57
 * 
 */
public class RedisTokenSessionFilter implements Filter {

	private String sessionId = "Token";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.sessionId = filterConfig.getInitParameter("sessionId");
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String token = request.getHeader(sessionId);

		if (token == null || token.length() == 0) {
			token = java.util.UUID.randomUUID().toString();
			response.setHeader(sessionId, token);
		}

		filterChain.doFilter(
				new HttpServletRequestRedisWrapper(token, request), response);
	}

	@Override
	public void destroy() {
	}

}
