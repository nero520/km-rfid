package com.msds.util;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * 
 * 原理： 正则表达式的白名单过滤机制
 * 
 */
public class XSSEncodeUtils {

	private static String EmptyString_JavaScript = "''";

	private static String EmptyString_VBS = "\"\"";

	private static String EmptyString = "";

	private static StringBuffer strb;

	private static StringCharacterIterator sci;

	private static String EncodeHtml(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString;
		}
		StringBuilder builder = new StringBuilder(strInput.length() * 2);
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch == ' ') || ((ch > '/') && (ch < ':'))) || (((ch == '.') || (ch == ',')) || ((ch == '-') || (ch == '_'))))) {
				builder.append(ch);
			} else {
				builder.append("&#" + (int) ch + ";");
			}
		}
		return builder.toString();
	}

	private static String EncodeHtmlAttribute(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString;
		}
		StringBuilder builder = new StringBuilder(strInput.length() * 2);
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch > '/') && (ch < ':')) || (((ch == '.') || (ch == ',')) || ((ch == '-') || (ch == '_'))))) {
				builder.append(ch);
			} else {
				builder.append("&#" + (int) ch + ";");
			}
		}
		return builder.toString();
	}

	private static String EncodeJs(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString_JavaScript;
		}
		StringBuilder builder = new StringBuilder("'");
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch == ' ') || ((ch > '/') && (ch < ':'))) || (((ch == '.') || (ch == ',')) || ((ch == '-') || (ch == '_'))))) {
				builder.append(ch);
			} else if (ch > '\u007f') {
				builder.append("\\u" + TwoByteHex(ch));
			} else {
				builder.append("\\x" + SingleByteHex(ch));
			}
		}
		builder.append("'");
		return builder.toString();
	}

	private static String EncodeUrl(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString;
		}
		StringBuilder builder = new StringBuilder(strInput.length() * 2);
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch > '/') && (ch < ':')) || (((ch == '.') || (ch == '-')) || (ch == '_')))) {
				builder.append(ch);
			} else if (ch > '\u007f') {
				builder.append("%u" + TwoByteHex(ch));
			} else {
				builder.append("%" + SingleByteHex(ch));
			}
		}
		return builder.toString();
	}

	private static String EncodeVbs(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString_VBS;
		}
		StringBuilder builder = new StringBuilder(strInput.length() * 2);
		boolean flag = false;
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch == ' ') || ((ch > '/') && (ch < ':'))) || (((ch == '.') || (ch == ',')) || ((ch == '-') || (ch == '_'))))) {
				if (!flag) {
					builder.append("&\"");
					flag = true;
				}
				builder.append(ch);
			} else {
				if (flag) {
					builder.append("\"");
					flag = false;
				}
				builder.append("&chrw(" + (long) ch + ")");
			}
		}
		if ((builder.length() > 0) && (builder.charAt(0) == '&')) {
			builder.delete(0, 1);
		}
		if (builder.length() == 0) {
			builder.insert(0, "\"\"");
		}
		if (flag) {
			builder.append("\"");
		}
		return builder.toString();
	}

	private static String EncodeXml(String strInput) {
		return EncodeHtml(strInput);
	}

	private static String EncodeXmlAttribute(String strInput) {
		return EncodeHtmlAttribute(strInput);
	}

	public static String HtmlAttributeEncode(String s) {
		return EncodeHtmlAttribute(s);
	}

	public static String HtmlEncode(String s) {
		return EncodeHtml(s);
	}

	public static String JavaScriptEncode(String s) {
		return EncodeJs(s);
	}

	private static String SingleByteHex(char c) {
		long num = c;
		return leftPad(Long.toString(num, 16), "0", 2);
	}

	private static String TwoByteHex(char c) {
		long num = c;
		return leftPad(Long.toString(num, 16), "0", 4);
	}

	public static String UrlEncode(String s) {
		return EncodeUrl(s);
	}

	public static String VisualBasicScriptEncodeString(String s) {
		return EncodeVbs(s);
	}

	public static String XmlAttributeEncode(String s) {
		return EncodeXmlAttribute(s);
	}

	public static String XmlEncode(String s) {
		return EncodeXml(s);
	}

	private static String leftPad(String stringToPad, String padder, int size) {
		if (padder.length() == 0) {
			return stringToPad;
		}
		strb = new StringBuffer(size);
		sci = new StringCharacterIterator(padder);

		while (strb.length() < (size - stringToPad.length())) {
			for (char ch = sci.first(); ch != CharacterIterator.DONE; ch = sci
					.next()) {
				if (strb.length() < size - stringToPad.length()) {
					strb.insert(strb.length(), String.valueOf(ch));
				}
			}
		}
		return strb.append(stringToPad).toString();
	}

}