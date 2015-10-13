package com.msds.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 * Session数据存到Redis
 * 
 * @author dragon
 */
public class RedisSessionFilter implements Filter {

	private String sessionId = "mssc_sid";

	private String cookieDomain = "";

	private String cookiePath = "/";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.sessionId = filterConfig.getInitParameter("sessionId");
		this.cookieDomain = filterConfig.getInitParameter("cookieDomain");
		if (this.cookieDomain == null) {
			this.cookieDomain = "";
		}

		this.cookiePath = filterConfig.getInitParameter("cookiePath");
		if (this.cookiePath == null || this.cookiePath.length() == 0) {
			this.cookiePath = "/";
		}
	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 清除url链接上的jsessionid
		if (request.isRequestedSessionIdFromURL()) {
			HttpSession session = request.getSession();
			if (session != null)
				session.invalidate();
		}

		Cookie cookies[] = request.getCookies();
		Cookie sCookie = null;

		String sid = "";
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				sCookie = cookies[i];
				if (sCookie.getName().equals(sessionId)) {
					sid = sCookie.getValue();
				}
			}
		}

		if (sid == null || sid.length() == 0) {
			sid = java.util.UUID.randomUUID().toString();
			Cookie mycookies = new Cookie(sessionId, sid);
			mycookies.setMaxAge(-1);
			mycookies.setHttpOnly(true);
			if (this.cookieDomain != null && this.cookieDomain.length() > 0) {
				mycookies.setDomain(this.cookieDomain);
			}
			mycookies.setPath(this.cookiePath);
			response.addCookie(mycookies);
		}

		// 去除url中的jsessionid
		HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(
				response) {
			@Override
			public String encodeRedirectUrl(String url) {
				return url;
			}

			@Override
			public String encodeRedirectURL(String url) {
				return url;
			}

			@Override
			public String encodeUrl(String url) {
				return url;
			}

			@Override
			public String encodeURL(String url) {
				return url;
			}
		};

		filterChain.doFilter(new HttpServletRequestRedisWrapper(sid, request),
				wrappedResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
