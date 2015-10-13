package com.msds.km.entity;

import java.math.BigDecimal;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ServiceModelEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 服务车型代码 */
	private java.lang.String serviceModelCode;
	/** 服务代码 */
	private java.lang.String serviceCode;
	/** 车型ID */
	private java.lang.String modelId;
	/** 里程数范围 1 2 3 4 */
	private java.lang.Integer mileage;
	/** 工时费集合 */
	private java.lang.String laborcostJson;
	/** 总价 */
	private BigDecimal price;
	/** 操作人 */
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
	 * @return: java.lang.String 服务代码
	 */
	public java.lang.String getServiceCode() {
		return this.serviceCode;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 服务代码
	 */
	public void setServiceCode(java.lang.String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 车型ID
	 */
	public java.lang.String getModelId() {
		return this.modelId;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 车型ID
	 */
	public void setModelId(java.lang.String modelId) {
		this.modelId = modelId;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 里程数范围 1 2 3 4
	 */
	public java.lang.Integer getMileage() {
		return this.mileage;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 里程数范围 1 2 3 4
	 */
	public void setMileage(java.lang.Integer mileage) {
		this.mileage = mileage;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 工时费集合
	 */
	public java.lang.String getLaborcostJson() {
		return this.laborcostJson;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 工时费集合
	 */
	public void setLaborcostJson(java.lang.String laborcostJson) {
		this.laborcostJson = laborcostJson;
	}

	/**
	 * 方法: 取得BigDecimal
	 *
	 * @return: BigDecimal 总价
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 方法: 设置BigDecimal
	 *
	 * @param: BigDecimal 总价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
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

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 服务车型代码
	 */
	public java.lang.String getServiceModelCode() {
		return serviceModelCode;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 服务车型代码
	 */
	public void setServiceModelCode(java.lang.String serviceModelCode) {
		this.serviceModelCode = serviceModelCode;
	}
}
