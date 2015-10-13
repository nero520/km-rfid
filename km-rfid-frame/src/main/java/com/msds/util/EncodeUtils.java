package com.msds.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 创建时间：2014-12-18 下午4:36:23 项目名称：car_zone_base
 * 
 * @author lizhe
 * @version 1.0
 * @since JDK 1.6.0_21
 */
public class EncodeUtils {
	// MsDsKzB2BSecurityKey
	private static String SECURITY_PRIVATE_KEY = "MsDsKzB2BSecurityKey";

	/**
	 * 将指定的数进行加密
	 * 
	 * @str需要加密的数据
	 */
	public static String aesEncoder(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		try {
			return encrypt(SECURITY_PRIVATE_KEY, str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将指定的数进行解密
	 * 
	 * @str需要加密的数据
	 */
	public static String aesDecoder(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		try {
			return decrypt(SECURITY_PRIVATE_KEY, str);
		} catch (Exception e) {
		}
		return "";
	}
	
	public static String encrypt(String strKey, String strIn)
			throws Exception {
		SecretKeySpec skeySpec = getKey(strKey);
		//算法/模式/填充
		//模式：CBC，CFB，ECB，OFB，PCBC
		//填充： NoPadding，PKCS5Padding，ISO10126Padding
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec(
				"0102030405060708".getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(strIn.getBytes("UTF-8"));

		return Base64.encode(encrypted);
	}

	public static String decrypt(String strKey, String strIn)
			throws Exception {
		SecretKeySpec skeySpec = getKey(strKey);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec(
				"0102030405060708".getBytes());
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] encrypted1 = Base64.decode(strIn);

		byte[] original = cipher.doFinal(encrypted1);
		String originalString = new String(original, "UTF-8");
		return originalString;
	}

	private static SecretKeySpec getKey(String strKey) throws Exception {
		byte[] arrBTmp = strKey.getBytes();
		byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）

		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");

		return skeySpec;
	}


	public static class Base64 {
		private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
				.toCharArray();

		/**
		 * data[]进行编码
		 * 
		 * @param data
		 * @return
		 */
		public static String encode(byte[] data) {
			int start = 0;
			int len = data.length;
			StringBuffer buf = new StringBuffer(data.length * 3 / 2);

			int end = len - 3;
			int i = start;
			int n = 0;

			while (i <= end) {
				int d = ((((int) data[i]) & 0x0ff) << 16)
						| ((((int) data[i + 1]) & 0x0ff) << 8)
						| (((int) data[i + 2]) & 0x0ff);

				buf.append(legalChars[(d >> 18) & 63]);
				buf.append(legalChars[(d >> 12) & 63]);
				buf.append(legalChars[(d >> 6) & 63]);
				buf.append(legalChars[d & 63]);

				i += 3;

				if (n++ >= 14) {
					n = 0;
					buf.append(" ");
				}
			}

			if (i == start + len - 2) {
				int d = ((((int) data[i]) & 0x0ff) << 16)
						| ((((int) data[i + 1]) & 255) << 8);

				buf.append(legalChars[(d >> 18) & 63]);
				buf.append(legalChars[(d >> 12) & 63]);
				buf.append(legalChars[(d >> 6) & 63]);
				buf.append("=");
			} else if (i == start + len - 1) {
				int d = (((int) data[i]) & 0x0ff) << 16;

				buf.append(legalChars[(d >> 18) & 63]);
				buf.append(legalChars[(d >> 12) & 63]);
				buf.append("==");
			}

			return buf.toString();
		}

		private static int decode(char c) {
			if (c >= 'A' && c <= 'Z')
				return ((int) c) - 65;
			else if (c >= 'a' && c <= 'z')
				return ((int) c) - 97 + 26;
			else if (c >= '0' && c <= '9')
				return ((int) c) - 48 + 26 + 26;
			else
				switch (c) {
				case '+':
					return 62;
				case '/':
					return 63;
				case '=':
					return 0;
				default:
					throw new RuntimeException("unexpected code: " + c);
				}
		}

		/**
		 * Decodes the given Base64 encoded String to a new byte array. The byte
		 * array holding the decoded data is returned.
		 */

		public static byte[] decode(String s) {

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try {
				decode(s, bos);
			} catch (IOException e) {
				throw new RuntimeException();
			}
			byte[] decodedBytes = bos.toByteArray();
			try {
				bos.close();
				bos = null;
			} catch (IOException ex) {
				System.err.println("Error while decoding BASE64: "
						+ ex.toString());
			}
			return decodedBytes;
		}

		private static void decode(String s, OutputStream os)
				throws IOException {
			int i = 0;

			int len = s.length();

			while (true) {
				while (i < len && s.charAt(i) <= ' ')
					i++;

				if (i == len)
					break;

				int tri = (decode(s.charAt(i)) << 18)
						+ (decode(s.charAt(i + 1)) << 12)
						+ (decode(s.charAt(i + 2)) << 6)
						+ (decode(s.charAt(i + 3)));

				os.write((tri >> 16) & 255);
				if (s.charAt(i + 2) == '=')
					break;
				os.write((tri >> 8) & 255);
				if (s.charAt(i + 3) == '=')
					break;
				os.write(tri & 255);

				i += 4;
			}
		}

	}

	public static void main(String[] args) {

		// System.out.println( encoder("a=1&b=2&c=3"));
		// System.out.println( decoder(encoder("a=1&b=2&c=3")));
		//
		// System.out.println( encoder("是否支持中文加密"));
		// System.out.println( decoder(encoder("是否支持中文加密")));

		System.out.println(aesEncoder("111111"));
		System.out.println(aesDecoder(aesEncoder("111111")));

		System.out.println(aesEncoder("是否支持中文加密"));
		System.out.println(aesDecoder(aesEncoder("是否支持中文加密")));
	}
}
