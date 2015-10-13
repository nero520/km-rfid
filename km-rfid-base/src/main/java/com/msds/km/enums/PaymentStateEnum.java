package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 支付状态
 * 
 * @ClassName PaymentStateEnum
 * @Description 支付状态
 * @author LiLong
 * @date 2014年12月3日 下午2:21:46
 * 
 */
public enum PaymentStateEnum implements DescriptionEnum {
	/** 未支付 */
	UNPAID(1, "未支付"),
	/** 已支付 */
	PAID(2, "已支付"),
	/** 已退款 */
	REFUNDED(3, "已退款");

	private int id;
	private String name;

	private PaymentStateEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PaymentStateEnum getEnumById(int id) {
		PaymentStateEnum[] values = PaymentStateEnum.values();
		for (PaymentStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		PaymentStateEnum[] values = PaymentStateEnum.values();
		for (PaymentStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
