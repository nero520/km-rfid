package com.msds.km.enums;

import com.msds.enums.DescriptionEnum;

/**
 * 支付方式
 * 
 * @ClassName PaymentMethodEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年5月7日 下午3:53:40
 * 
 */
public enum PaymentMethodNameEnum implements DescriptionEnum {
	/** 支付宝wap快捷 */
	alipay_wap(1, "支付宝"),
	/** 微信 */
	wexin(2, "微信"),
	/** 支付网关 */
	gateway(3, "支付网关"),
	/** 民生网银 */
	cmsb(4, "民生网银");

	private int id;
	private String name;

	private PaymentMethodNameEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PaymentMethodNameEnum getEnumById(int id) {
		PaymentMethodNameEnum[] values = PaymentMethodNameEnum.values();
		for (PaymentMethodNameEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static PaymentMethodNameEnum getEnumByName(String name) {
		PaymentMethodNameEnum[] values = PaymentMethodNameEnum.values();
		for (PaymentMethodNameEnum en : values) {
			if (en.getName().equals(name)) {
				return en;
			}
		}
		return null;
	}
}
