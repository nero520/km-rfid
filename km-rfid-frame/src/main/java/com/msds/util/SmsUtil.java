package com.msds.util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author LiLong
 * 
 */
public class SmsUtil {

	/** 时间间隔(分钟) */
	private static int INTERVALTIME = 10;
	/** 控制次数 */
	private static int COUNT = 10;
	/** 锁定时间(小时) */
	private static int LOCKTIME = 1;
	/** 短信次数统一Key */
	private static String SMS_COUNT = "SMS_COUNT:";

	public static int sendVerifyCode(String phone, String content, String url) {
		StringBuffer fullContent = new StringBuffer("验证码为:");
		int result = getCheckCode();
		fullContent.append(result).append(",  ").append(content);
		sendGet(phone, url, fullContent.toString());
		return result;
	}

	/**
	 * 发送短信
	 * 
	 * @param phone
	 *            手机号
	 * @param url
	 *            短信通道接口URL
	 * @param content
	 *            发送内容
	 */
	public static void send(String phone, String url, String content) {
		try {
			Map<String, String> bodys = new HashMap<>();
			bodys.put("mobile", phone);
			bodys.put("content", content);
			HttpRequest.post(url, bodys);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送短信
	 * 
	 * @param phone
	 *            手机号
	 * @param url
	 *            短信通道接口URL
	 * @param content
	 *            发送内容
	 */
	public static void sendGet(String phone, String url, String content) {
		try {
			StringBuffer sb = new StringBuffer(url);
			sb.append("&mobile=");
			sb.append(phone);
			sb.append("&content=");
			sb.append(URLEncoder.encode(content, "UTF-8"));
			HttpRequest.get(sb.toString(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int getCheckCode() {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = result * 10 + array[i];
		}
		if (String.valueOf(result).length() < 4) {
			result = result * 10;
		}
		return result;
	}

	/**
	 * 控制手机发送频率
	 * 
	 * @Description 时间间隔内超过控制次数，锁定一段时间
	 * @param phone
	 *            手机号
	 * @return
	 */
	public static boolean checkCount(String phone) {
		return FrequencyUtils.check(SMS_COUNT + phone, INTERVALTIME, COUNT,
				LOCKTIME);
	}

}