package com.msds.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.msds.util.XSSReplaceUtils;

public class XSSFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new RequestWrapper((HttpServletRequest) request),
				response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * 处理所有参数以及变量
	 * 
	 */
	final class RequestWrapper extends HttpServletRequestWrapper {
		public RequestWrapper(HttpServletRequest servletRequest) {
			super(servletRequest);
		}

		public String[] getParameterValues(String parameter) {
			String[] results = super.getParameterValues(parameter);
			if (results == null)
				return null;
			int count = results.length;
			String[] trimResults = new String[count];
			for (int i = 0; i < count; i++) {
				trimResults[i] = XSSReplaceUtils.antiXSS(results[i]);
			}
			return trimResults;
		}

		public String getParameter(String name) {
			String value = super.getParameter(name);
			if (value != null) {
				value = XSSReplaceUtils.antiXSS(value);
			}
			return value;
		}
	}
}
