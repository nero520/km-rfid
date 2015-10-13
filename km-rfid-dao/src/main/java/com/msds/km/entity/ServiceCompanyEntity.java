package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceCompanyEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-30 10:52:49 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ServiceCompanyEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 服务code */
	private java.lang.String serviceCode;
	/** 企业ID */
	private java.lang.Integer companyId;
	/** 操作人 */
	private java.lang.Integer operator;
	
	private String serviceName;
	
	
	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

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
	 * @return: java.lang.String 服务code
	 */
	public java.lang.String getServiceCode() {
		return this.serviceCode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 服务code
	 */
	public void setServiceCode(java.lang.String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 企业ID
	 */
	public java.lang.Integer getCompanyId() {
		return this.companyId;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 企业ID
	 */
	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 操作人
	 */
	public java.lang.Integer getOperator() {
		return this.operator;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 操作人
	 */
	public void setOperator(java.lang.Integer operator) {
		this.operator = operator;
	}
}
