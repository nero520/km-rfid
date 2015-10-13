package com.msds.util;

import java.util.regex.Pattern;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;

/**
 * @author LiLong
 * 
 */
public final class CheckUtils {

	/**
	 * 不可实例化
	 */
	private CheckUtils() {
	}

	/**
	 * 校验是否是email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		EmailValidator emailValidator = new EmailValidator();
		return emailValidator.isValid(email, null);
		// Pattern pattern =
		// Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		// return pattern.matcher(email).find();
	}

	/**
	 * 校验是否是手机号
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone) {
		Pattern pattern = Pattern.compile("^((00|\\+)86)?1[3-8]\\d{9}$");
		return pattern.matcher(phone).find();
	}
	
	/**
	 * 校验是否是名字
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean checkName(String name) {
		Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5]{2,5}$");
		return pattern.matcher(name).find();
	}

	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String email = "1231@2311.com";
		System.out.println(checkEmail(email));
		email = "12312311.com";
		System.out.println(checkEmail(email));
		String phone = "15201562911";
		System.out.println(checkPhone(phone));
		phone = "11111111111";
		System.out.println(checkPhone(phone));
		
		System.out.println("1"+checkPhone("12111111111"));
	}

}