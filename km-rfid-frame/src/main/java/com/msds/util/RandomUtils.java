package com.msds.util;

import java.util.Random;

/**
 * 生成随机数
 * 
 * @author nero
 * 
 */
public class RandomUtils {

	private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	private static char[] numSequence = { '1', '2', '3', '4', '5', '6', '7',
			'8', '9' };

	/**
	 * 
	 * 随机生成字母+数字
	 * 
	 * @param size
	 * 
	 * @return
	 */
	public static String getRandSeq(int size) {
		StringBuffer randSB = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			randSB.append(String.valueOf(codeSequence[random.nextInt(34)]));
		}
		return randSB.toString();
	}

	/**
	 * 
	 * 生成随机数字
	 * 
	 * @param size
	 * 
	 * @return
	 */
	public static String getRandNum(int size) {
		StringBuffer randSB = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			randSB.append(String.valueOf(numSequence[random.nextInt(9)]));
		}
		return randSB.toString();
	}

}
