package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PrizeCordEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class PrizeCordEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 优惠码 */
	private java.lang.String sn;
	/** 活动编号 */
	private java.lang.String activitySn;
	/** 失效日期 */
	private java.util.Date expiryDate;
	/** 状态 1未使用 2使用 3过期 */
	private java.lang.Integer state;
	/** 手机 */
	private java.lang.String phone;
	/** 车牌号 */
	private java.lang.String license;
	/** 车型 */
	private java.lang.String model;
	/** openid */
	private java.lang.String openid;
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
	 * @return: java.lang.String 优惠码
	 */
	public java.lang.String getSn() {
		return this.sn;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 优惠码
	 */
	public void setSn(java.lang.String sn) {
		this.sn = sn;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 活动编号
	 */
	public java.lang.String getActivitySn() {
		return this.activitySn;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 活动编号
	 */
	public void setActivitySn(java.lang.String activitySn) {
		this.activitySn = activitySn;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 失效日期
	 */
	public java.util.Date getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 失效日期
	 */
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 状态 0未使用 1使用 2过期
	 */
	public java.lang.Integer getState() {
		return this.state;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 状态 1未使用 2使用 3过期
	 */
	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 手机
	 */
	public java.lang.String getPhone() {
		return this.phone;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 手机
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 车牌号
	 */
	public java.lang.String getLicense() {
		return this.license;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 车牌号
	 */
	public void setLicense(java.lang.String license) {
		this.license = license;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 车型
	 */
	public java.lang.String getModel() {
		return this.model;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 车型
	 */
	public void setModel(java.lang.String model) {
		this.model = model;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String openid
	 */
	public java.lang.String getOpenid() {
		return this.openid;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String openid
	 */
	public void setOpenid(java.lang.String openid) {
		this.openid = openid;
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
