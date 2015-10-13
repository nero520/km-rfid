package com.msds.util;

import java.io.UnsupportedEncodingException;

/**
 * 全角、半角相互 转换函数
 * 
 * @author xiaoxiong
 * 
 */
public class FullCharConverterUtils {

	/**
	 * 全角转半角的 转换函数
	 * 
	 * @param QJstr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static final String fullHalfChange(String QJstr) {

		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		if (QJstr != null) {
			for (int i = 0; i < QJstr.length(); i++) {
				Tstr = QJstr.substring(i, i + 1);
				// 全角空格转换成半角空格
				if (Tstr.equals("　")) {
					outStrBuf.append(" ");
					continue;
				}
				try {
					b = Tstr.getBytes("unicode");
					// 得到 unicode 字节数据
					if (b[2] == -1) {
						// 表示全角？
						b[3] = (byte) (b[3] + 32);
						b[2] = 0;
						outStrBuf.append(new String(b, "unicode"));

					} else {
						outStrBuf.append(Tstr);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

			} // end for.
		}
		return outStrBuf.toString();
	}

	/**
	 * 半角转全角
	 * 
	 * @param QJstr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static final String halfFullchange(String QJstr) {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		byte[] b = null;
		if (QJstr != null) {
			for (int i = 0; i < QJstr.length(); i++) {
				Tstr = QJstr.substring(i, i + 1);
				if (Tstr.equals(" ")) {
					// 半角空格
					outStrBuf.append(Tstr);
					continue;
				}
				try {
					b = Tstr.getBytes("unicode");
					if (b[2] == 0) {
						// 半角?
						b[3] = (byte) (b[3] - 32);
						b[2] = -1;
						outStrBuf.append(new String(b, "unicode"));
					} else {
						outStrBuf.append(Tstr);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return outStrBuf.toString();

	}

}
