package com.msds.open.api.vo;

import java.io.Serializable;

public class OrderResponse implements Serializable {

	private static final long serialVersionUID = 7120535325446809747L;
	/**
	 * 返回码
	 */
	private String code;
	/**
	 * 详情
	 */
	private OrderDetail detail;
	/**
	 * 消息
	 */
	private String message;

	/**
	 * @Description 获取 返回码
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @Description 设置 返回码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @Description 获取 详情
	 * @return OrderDetail
	 */
	public OrderDetail getDetail() {
		return detail;
	}

	/**
	 * @Description 设置 详情
	 * @param detail
	 */
	public void setDetail(OrderDetail detail) {
		this.detail = detail;
	}

	/**
	 * @Description 获取 消息
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @Description 设置 消息
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
