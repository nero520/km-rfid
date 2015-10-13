package com.msds.km.model;

import java.io.Serializable;

/**
 * 结算单明细
 * @author hebiao
 *
 */
public class SettleAccountItemModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单单号
	 */
	private String orderSn;
	/**
	 * 订单服务时间
	 */
	private String serviceTime;
	/**
	 * 订单服务名称
	 */
	private String serviceName;
	
	/**
	 * 金额
	 */
	private String price;

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	

	

}
