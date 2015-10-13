package com.msds.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码处理
 * 
 * @ClassName CaptchaUtils
 * @Description 对kaptcha进行处理,不需要管验证码存储
 * @author LiLong
 * @date 2014年11月24日 下午5:31:19
 * 
 */
public class CaptchaUtils {

	/**
	 * 验证码校验 <br>
	 * 检查用户输入验证码，与内存中是否一致
	 * 
	 * @param request
	 * @param captcha
	 *            验证码(忽略大小写)
	 * @return 验证码验证是否通过
	 */
	public static boolean isValid(HttpServletRequest request, String captcha) {
		String kaptchaCode = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (captcha == null || !captcha.equalsIgnoreCase(kaptchaCode)) {
			return false;
		} else {
			return true;
		}
	}

}
