package com.msds.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class GaFilter implements Filter {

	private static final Logger log = Logger.getLogger(GaFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// http://www.carzone.cn/__utm.gif?
		// utmwv=5.6.1&utms=2&utmn=265087275&
		// utmhn=www.zmparty.com&utmcs=utf-8&utmsr=1366x768&
		// utmvp=1366x645&utmsc=24-bit&utmul=zh-cn&utmje=1&utmfl=15.0%20r0&
		// utmhid=1229560709&utmr=-&utmp=%2F
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Map<String, String[]> dataMap = req.getParameterMap();
		Iterator<Entry<String, String[]>> itr = dataMap.entrySet().iterator();
		StringBuffer sb = new StringBuffer();
		while (itr.hasNext()) {
			Entry<String, String[]> entry = itr.next();
			sb.append(entry.getKey() + ":");
			for (String str : entry.getValue()) {
				sb.append(str);
			}
		}
		log.info("[weblog][" + sb.toString() + "]");
		String path = req.getRealPath("/");
		String imagePath = path + "1.gif";
		System.out.println(imagePath);
		FileInputStream fis = new FileInputStream(imagePath);
		int size = fis.available(); // 得到文件大小
		byte data[] = new byte[size];
		fis.read(data); // 读数据
		fis.close();
		res.setContentType("image/gif"); // 设置返回的文件类型
		OutputStream os = res.getOutputStream();
		os.write(data);
		os.flush();
		os.close();
		// chain.doFilter(req,null);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
