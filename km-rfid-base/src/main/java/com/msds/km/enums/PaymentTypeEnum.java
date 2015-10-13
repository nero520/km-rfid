package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 支付类型
 * 
 * @ClassName PaymentTypeEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年4月28日 上午11:37:09
 * 
 */
public enum PaymentTypeEnum implements DescriptionEnum {
	/** 在线支付 */
	online(1, "在线支付"),
	/** 线下支付 */
	offline(2, "线下支付");

	private int id;
	private String name;

	private PaymentTypeEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return name;
	}

	public static PaymentTypeEnum getEnumById(int id) {
		PaymentTypeEnum[] values = PaymentTypeEnum.values();
		for (PaymentTypeEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		PaymentTypeEnum[] values = PaymentTypeEnum.values();
		for (PaymentTypeEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
