package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ActivityEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ActivityEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 活动sn */
	private java.lang.String sn;
	/** 活动名称 */
	private java.lang.String title;
	/** 活动描述 */
	private java.lang.String description;
	/** 奖品 */
	private java.lang.String prize;
	/** 总数 */
	private java.lang.Integer count;
	/** 数量 */
	private java.lang.Integer quantity;
	/** 状态 1未开始 2开始 3结束 4关闭 */
	private java.lang.Integer state;
	/** 开始时间 */
	private java.util.Date startTime;
	/** 结束时间 */
	private java.util.Date endTime;
	/** operator */
	private java.lang.Integer operator;

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer ID
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 活动sn
	 */
	public java.lang.String getSn() {
		return this.sn;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 活动sn
	 */
	public void setSn(java.lang.String sn) {
		this.sn = sn;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 活动名称
	 */
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 活动名称
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 活动描述
	 */
	public java.lang.String getDescription() {
		return this.description;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 活动描述
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 奖品
	 */
	public java.lang.String getPrize() {
		return this.prize;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 奖品
	 */
	public void setPrize(java.lang.String prize) {
		this.prize = prize;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 总数
	 */
	public java.lang.Integer getCount() {
		return this.count;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 总数
	 */
	public void setCount(java.lang.Integer count) {
		this.count = count;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 数量
	 */
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 数量
	 */
	public void setQuantity(java.lang.Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 状态 0未开始 1开始 2结束 3关闭
	 */
	public java.lang.Integer getState() {
		return this.state;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 状态 0未开始 1开始 2结束 3关闭
	 */
	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 开始时间
	 */
	public java.util.Date getStartTime() {
		return this.startTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 开始时间
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 结束时间
	 */
	public java.util.Date getEndTime() {
		return this.endTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 结束时间
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer operator
	 */
	public java.lang.Integer getOperator() {
		return this.operator;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer operator
	 */
	public void setOperator(java.lang.Integer operator) {
		this.operator = operator;
	}
}
