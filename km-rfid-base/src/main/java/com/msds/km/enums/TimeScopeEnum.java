package com.msds.km.enums;

import com.msds.enums.DescriptionEnum;

/**
 * 时间区间
 * 
 * @ClassName PaymentStateEnum
 * @Description 支付状态
 * @author LiLong
 * @date 2014年12月3日 下午2:21:46
 * 
 */
public enum TimeScopeEnum implements DescriptionEnum {
	/** 8:00:00 */
	_8(8, "8:00:00"),
	/** 9:00:00 */
	_9(9, "9:00:00"),
	/** 10:00:00 */
	_10(10, "10:00:00"),
	/** 11:00:00 */
	_11(11, "11:00:00"),
	/** 12:00:00 */
	_12(12, "12:00:00"),
	/** 13:00:00 */
	_13(13, "13:00:00"),
	/** 14:00:00 */
	_14(14, "14:00:00"),
	/** 15:00:00 */
	_15(15, "15:00:00"),
	/** 16:00:00 */
	_16(16, "16:00:00"),
	/** 17:00:00 */
	_17(17, "17:00:00"),
	/** 18:00:00 */
	_18(18, "18:00:00"),
	/** 19:00:00 */
	_19(19, "19:00:00"),
	/** 20:00:00 */
	_20(20, "20:00:00"),
	/** 21:00:00 */
	_21(21, "21:00:00"),
	/** 22:00:00 */
	_22(22, "22:00:00");

	private int id;
	private String name;

	private TimeScopeEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
