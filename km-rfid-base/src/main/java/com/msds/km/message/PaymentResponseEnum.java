package com.msds.km.message;

import com.msds.enums.DescriptionEnum;

/**
 * 支付接口返回信息定义
 * 
 * @ClassName PaymentResponseEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年07月14日 上午9:42:03
 * 
 */
public enum PaymentResponseEnum implements DescriptionEnum {
	/** 支付流水生成出错。 */
	code_1500(1500, "支付流水生成出错。"),
	/** 订单状态信息或支付信息错误。 */
	code_1501(1501, "订单状态信息或支付信息错误。"),
	/** 微信下单处理错误。 */
	code_1502(1502, "微信下单处理错误。"),
	/** 支付方式不存在或未开启 。 */
	code_1503(1503, "支付方式不存在或未开启。");

	private int id;
	private String name;

	private PaymentResponseEnum(int id, String name) {
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
}
