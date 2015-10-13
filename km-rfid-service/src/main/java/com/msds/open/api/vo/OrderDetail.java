package com.msds.open.api.vo;

import java.io.Serializable;

public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -3462517368117693399L;
	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * @Description 获取 订单号
	 * @return String
	 */
	public String getOrderSn() {
		return orderSn;
	}

	/**
	 * @Description 设置 订单号
	 * @param orderSn
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

}
