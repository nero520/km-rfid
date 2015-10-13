package com.msds.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间比较大小
 * 
 * @author rant
 * 
 */
public class TimeCompareUtil {
	public static void main(String args[]) {
		// timeCompare("2014-07-08 00:00:00","2014-07-08 00:00:00");

	}

	/**
	 * 时间比大小 有0,1,-1三种值 0 t1和t2相等 1 t1大于t2 -1 t1小于t2
	 * */
	public static int timeCompare(String t1, String t2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(formatter.parse(t1));
			c2.setTime(formatter.parse(t2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int result = c1.compareTo(c2);
		return result;
	}

	public static boolean timeCompareBoolean(String t1, String t2) {
		boolean flag = false;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(formatter.parse(t1));
			c2.setTime(formatter.parse(t2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int result = c1.compareTo(c2);

		if (result == 0) {
			flag = true;
		} else if (result < 0) {
			flag = false;

		} else {
			flag = true;
			// return result;
		}
		return flag;
	}

	// /获取系统时间到毫秒
	public static String GetSysLongTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		return formatter.format(new Date());
	}

	/**
	 * 判断促销时间
	 * */
	public static boolean checkProductLimitTime(String startDate, String endDate) {
		boolean flag = false;
		Date nowdate = new Date();
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.CHINA);
		String nowTime = format2.format(nowdate);
		// String nowTime="2014-06-19 00:00:00";
		// String timeArray []=time.split(",");

		boolean startFlag = TimeCompareUtil.timeCompareBoolean(nowTime,
				startDate);
		boolean endFlag = TimeCompareUtil.timeCompareBoolean(endDate, nowTime);
		if (startFlag && endFlag) {
			flag = true;
		}
		return flag;
	}

	public static Date pareStringToDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}