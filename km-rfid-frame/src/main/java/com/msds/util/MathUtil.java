package com.msds.util;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * <p>
 * Description: [计算工具类]
 * </p>
 * 
 * @category 系统_[子系统统名]_[模块名]
 * @author xmc
 * @version $Revision$ 2014年8月6日
 * @author (lastest modification by $Author$)
 * @since 1.0
 */
public class MathUtil {

	public MathUtil() {
	}

	public static Number getNumber(Object o) {
		if (o == null)
			return null;
		if (o instanceof Number)
			return (Number) o;
		if (o instanceof String) {
			if (StringUtils.isBlank(o.toString()))
				return null;
			String ss = ((String) o).trim();
			if (ss.indexOf(".") == -1) {
				if (ss.length() < 5)
					return Integer.valueOf((new BigDecimal(ss)).intValue());
				else
					return Long.valueOf((new BigDecimal(ss)).longValue());
			} else {
				return Double.valueOf((new BigDecimal(ss)).doubleValue());
			}
		} else {
			return Integer.valueOf(0);
		}
	}

	public static BigDecimal getBigDecimal(Object o) {
		if (o == null)
			return null;
		if (o instanceof BigDecimal)
			return (BigDecimal) o;
		if (o instanceof String) {
			String ss = ((String) o).trim();
			if ("".equals(ss))
				return null;
			else
				return new BigDecimal(ss);
		}
		if (o instanceof Number)
			return new BigDecimal(o.toString());
		else
			throw new IllegalArgumentException(
					"\u975E\u6CD5\u7684\u6570\u5B57\u7C7B\u578B");
	}

	public static int getInt(Object o) {
		if (o == null)
			return 0;
		if (o instanceof Number)
			return ((Number) o).intValue();
		if (o instanceof String)
			return Integer.parseInt((String) o);
		else
			return 0;
	}

	public static BigDecimal toBigDecimal(Object o) {
		if (o == null || "".equals(o))
			return new BigDecimal(0.0D);
		if (o instanceof BigDecimal)
			return (BigDecimal) o;
		else
			return new BigDecimal(o.toString(), MathContext.UNLIMITED);
	}

	public static int compare(double a, double b) {
		if (a + 9.9999999999999995E-008D > b
				&& a - 9.9999999999999995E-008D < b)
			return 0;
		return a <= b ? -1 : 1;
	}

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public static String add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).toString();
	}

	public static double subtract(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	public static String subtract(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).toString();
	}

	public static double multiply(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static String multiply(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).toString();
	}

	public static double divide(double v1, double v2) {
		return divide(v1, v2, 10);
	}

	public static double divide(double v1, double v2, int scale) {
		return divide(v1, v2, scale, 6);
	}

	public static double divide(double v1, double v2, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		} else {
			BigDecimal b1 = new BigDecimal(Double.toString(v1));
			BigDecimal b2 = new BigDecimal(Double.toString(v2));
			return b1.divide(b2, scale, round_mode).doubleValue();
		}
	}

	public static String divide(String v1, String v2) {
		return divide(v1, v2, 10);
	}

	public static String divide(String v1, String v2, int scale) {
		return divide(v1, v2, 10, 6);
	}

	public static String divide(String v1, String v2, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		} else {
			BigDecimal b1 = new BigDecimal(v1);
			BigDecimal b2 = new BigDecimal(v2);
			return b1.divide(b2, scale, round_mode).toString();
		}
	}

	public static double round(double v, int scale) {
		return round(v, scale, 6);
	}

	public static double round(double v, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		} else {
			BigDecimal b = new BigDecimal(Double.toString(v));
			return b.setScale(scale, round_mode).doubleValue();
		}
	}

	public static String round(String v, int scale) {
		return round(v, scale, 6);
	}

	public static String round(String v, int scale, int round_mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		} else {
			BigDecimal b = new BigDecimal(v);
			return b.setScale(scale, round_mode).toString();
		}
	}

	public static double round(BigDecimal value, int bit) {
		if (value == null || value.doubleValue() > -1.0000000000000001E-009D
				&& value.doubleValue() < 1.0000000000000001E-009D)
			return 0.0D;
		else
			return value.divide(new BigDecimal("1"), bit, 4).doubleValue();
	}

	public static BigDecimal roundToBigDecimal(BigDecimal value, int bit) {
		if (value == null || value.doubleValue() > -1.0000000000000001E-009D
				&& value.doubleValue() < 1.0000000000000001E-009D)
			return new BigDecimal(0.0D);
		else
			return value.divide(new BigDecimal("1"), bit, 4);
	}

	public static String toPlainString(BigDecimal value) {
		if (value == null)
			return null;
		String temp = value.toPlainString();
		int pos = temp.indexOf(".");
		BigDecimal tempN = null;
		if (pos == -1)
			tempN = value;
		else
			tempN = new BigDecimal((new StringBuilder())
					.append(temp.substring(0, pos)).append(".")
					.append(StringUtils.stripEnd(temp.substring(pos + 1), "0"))
					.toString());
		return tempN.toPlainString();
	}

	private static final int scale = 10;
}
