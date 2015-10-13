package com.msds.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 一段时间内错误（/执行） 次数限制：超过最大错误次数就出现验证码
 * 
 * @author xiaoxiong
 * 
 */
public class LimitTimesUtils {

	/**
	 * 错误记录List Map包括以下属性： UserSessionID 用户标识 ActiveTimes 错误次数 ActiveAction 操作标识
	 * ActFirstTime 第一次错误 时间
	 */
	@SuppressWarnings("rawtypes")
	private static List<Map> LimitTimesErrorList = new ArrayList<Map>();

	/**
	 * 执行记录List Map包括以下属性： UserSessionID 用户标识 ActiveTimes 执行 次数 ActiveAction
	 * 操作标识 ActFirstTime 第一次操作 时间
	 */
	@SuppressWarnings("rawtypes")
	private static List<Map> LimitTimesActiveList = new ArrayList<Map>();

	// 超过错误次数返回验证码：时间、次数设置
	private static Long LimitTimeError = 30L;// 单位：分钟
	private static int LimitMaxErrorNum = 5;
	// 短时间内执行多次出现验证码：时间、次数设置
	private final static Long LimitTimeActive = 1L;
	private final static int LimitMaxActiveNum = 5;

	/***
	 * 是否显示验证码
	 * 
	 * @param UserSessionID
	 *            用户标识
	 * @return true：超过了最大错误（/执行）次数，显示验证码 false：没有超过最大错误（/执行）次数，不显示验证码
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isShowCAPTCHA(String UserSessionID) {
		int result = 0;

		// 判断错误记录
		for (int i = 0; i < LimitTimesErrorList.size(); i++) {
			Long minutes = getTimeDiff(String.valueOf(((Map) LimitTimesErrorList.get(i)).get("ActFirstTime")));
			if (minutes <= LimitTimeError) {// 如果在限制时间范围内
				// 判断是否符合条件，符合就判断错误次数
				if ((String.valueOf(((Map) LimitTimesErrorList.get(i))
						.get("UserSessionID"))).equals(UserSessionID)) {
					int activeNum = Integer.parseInt(String
							.valueOf(((Map) LimitTimesErrorList.get(i))
									.get("ActiveTimes")));
					if (activeNum >= LimitMaxErrorNum) {// 错误次数超过或者等于最大次数就要显示验证码
						result = result + 1;
					}
				}
			}
		}

		// 判断执行记录
		for (int i = 0; i < LimitTimesActiveList.size(); i++) {
			Long minutes = getTimeDiff(String
					.valueOf(((Map) LimitTimesActiveList.get(i))
							.get("ActFirstTime")));
			if (minutes <= LimitTimeActive) {// 如果在限制时间范围内
				// 判断是否符合条件，符合就判断执行次数
				if ((String.valueOf(((Map) LimitTimesActiveList.get(i))
						.get("UserSessionID"))).equals(UserSessionID)) {
					int activeNum = Integer.parseInt(String
							.valueOf(((Map) LimitTimesActiveList.get(i))
									.get("ActiveTimes")));
					if (activeNum >= LimitMaxActiveNum) {// 执行
															// 次数超过或者等于最大次数就要显示验证码
						result = result + 1;
					}
				}
			}
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/***
	 * 成功之后的操作：给执行记录+1，或者添加一条执行记录进去 同时把错误的记录删除 并清楚执行记录里面超时的记录
	 * 
	 * @param LimitTimesList
	 *            要操作的List对象 UserSessionID 用户标识 ActiveAction 操作标识
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sucActive(String UserSessionID) {
		// 清除超时的执行记录
		deleteList(LimitTimesActiveList, LimitTimeActive);
		int isNum = 0;// 符合条件的执行记录数
		// 如果有符合条件的执行记录，就给ActiveTimes+1
		for (int i = 0; i < LimitTimesActiveList.size(); i++) {
			if ((String.valueOf(((Map) LimitTimesActiveList.get(i))
					.get("UserSessionID"))).equals(UserSessionID)) {
				int activeNum = Integer.parseInt(String
						.valueOf(((Map) LimitTimesActiveList.get(i))
								.get("ActiveTimes")));
				((Map) LimitTimesActiveList.get(i)).put("ActiveTimes",
						activeNum + 1);
				isNum++;
			}
		}
		// 如果没有符合条件的执行记录，则增加一条执行记录进去
		if (isNum == 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("UserSessionID", UserSessionID);
			map.put("ActiveTimes", "1");
			map.put("ActFirstTime", getNowDate());
			LimitTimesActiveList.add(map);
		}

		// 成功后删除对应的错误记录
		Iterator<Map> ite = LimitTimesErrorList.iterator();
		while (ite.hasNext()) {
			if ((String.valueOf(((Map) ite.next()).get("UserSessionID")))
					.equals(UserSessionID)) {
				ite.remove();
			}
		}

	}

	/***
	 * 错误之后的操作：向错误记录添加一条记录，或者修改对应的ActiveTimes。 并删除超时的错误记录
	 * 
	 * @param LimitTimesList
	 *            要操作的List对象 UserSessionID 用户标识 ActiveAction 操作标识
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void errorActive(String UserSessionID) {
		// 删除超时的错误记录
		deleteList(LimitTimesErrorList, LimitTimeError);
		int isNum = 0;// 符合条件的记录数
		for (int i = 0; i < LimitTimesErrorList.size(); i++) {
			if ((String.valueOf(((Map) LimitTimesErrorList.get(i))
					.get("UserSessionID"))).equals(UserSessionID)) {
				// 如果有符合条件的记录，就给ActiveTimes+1
				int activeNum = Integer.parseInt(String
						.valueOf(((Map) LimitTimesErrorList.get(i))
								.get("ActiveTimes")));
				((Map) LimitTimesErrorList.get(i)).put("ActiveTimes",
						activeNum + 1);
				isNum++;
			}
		}
		// 如果没有符合条件的记录，则增加一条记录进去
		if (isNum == 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("UserSessionID", UserSessionID);
			map.put("ActiveTimes", "1");
			map.put("ActFirstTime", getNowDate());
			LimitTimesErrorList.add(map);
		}

	}

	/**
	 * 删除超时的记录公用方法
	 * 
	 * @param limitList
	 * 
	 * @param limitTime
	 */
	@SuppressWarnings("rawtypes")
	private static void deleteList(List<Map> limitList, Long limitTime) {

		Iterator<Map> ite = limitList.iterator();
		while (ite.hasNext()) {
			Long minutes = getTimeDiff(String.valueOf(ite.next().get(
					"ActFirstTime")));
			if (minutes > limitTime) {// 如果超时
				ite.remove();
			} else {// 当到达不超时的记录时，就跳出循环
				break;
			}
		}
	}

	/***
	 * 
	 * 获取当前时间
	 * 
	 * @return String 类型：格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate() {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = df.format(new Date());
		return result;
	}

	/**
	 * 
	 * 计算时间差：返回值单位：分钟
	 * 
	 */
	public static long getTimeDiff(String tm) {

		long i = 0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = new Date();
		try {
			Date d2 = df.parse(tm);
			long diff = d1.getTime() - d2.getTime();
			i = diff / (1000 * 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 从request中获取客户端IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		if (ip != null) {
			int index = ip.indexOf(',');
			if (index > -1) {
				ip = ip.substring(0, index);
			}
		}
		return ip;
	}

	/**
	 * 执行成功，相关记录操作
	 * 
	 * @param request
	 */
	public static void sucActive(HttpServletRequest request) {
		String ipStr = getIpAddr(request);
		sucActive(ipStr);
	}

	/**
	 * 执行错误，相关记录操作
	 * 
	 * @param request
	 */
	public static void errorActive(HttpServletRequest request) {
		String ipStr = getIpAddr(request);
		errorActive(ipStr);
	}

	/**
	 * 判断是否获取显示验证码
	 * 
	 * @param request
	 */
	public static boolean isShowCAPTCHA(HttpServletRequest request) {
		String ipStr = getIpAddr(request);
		return isShowCAPTCHA(ipStr);
	}
	
	
	/**
	 * 成功后删除错误记录
	 */
	
	@SuppressWarnings("rawtypes")
	public static void deleteIPCount(HttpServletRequest request){
			// 成功后删除对应的错误记录
			Iterator<Map> ite = LimitTimesErrorList.iterator();
				while (ite.hasNext()) {
					if ((String.valueOf(((Map) ite.next()).get("UserSessionID")))
							.equals(getIpAddr(request))) {
						ite.remove();
					}
				}
	}
}