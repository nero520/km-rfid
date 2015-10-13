package com.msds.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtils {

	/**
	 * 格式化金额 保留两位小数 格式 0.00
	 * 
	 * @param money
	 * @return
	 */
	public static String formatMoney(BigDecimal money) {
		if (null == money) {
			return "0.00";
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(money);
	}

}
