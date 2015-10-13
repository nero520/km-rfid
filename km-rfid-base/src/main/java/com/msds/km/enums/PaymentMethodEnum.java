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
public enum PaymentMethodEnum implements DescriptionEnum {
	/** 支付宝wap快捷 */
	alipay_wap(1, "alipayWapDirectPlugin"),
	/** 微信 */
	wexin(2, "weiXinPayPlugin"),
	/** 支付网关 */
	gateway(3, "heyihangpayPlugin"),
	/** 民生网银 */
	cmsb(4, "cmsbBankPlugin"),
	/** 支付宝app */
	alipay_app(5, "alipayAppDirectPlugin"),
	/** 微信app */
	wexin_app(6, "weiXinAppPayPlugin"),
	/** 微信Wap */
	wexin_wap(7, "weiXinWapPayPlugin");

	private int id;
	private String name;

	private PaymentMethodEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PaymentMethodEnum getEnumById(int id) {
		PaymentMethodEnum[] values = PaymentMethodEnum.values();
		for (PaymentMethodEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static PaymentMethodEnum getEnumByName(String name) {
		PaymentMethodEnum[] values = PaymentMethodEnum.values();
		for (PaymentMethodEnum en : values) {
			if (en.getName().equals(name)) {
				return en;
			}
		}
		return null;
	}
}
