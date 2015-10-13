package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.msds.base.entity.BaseEntity;


public class ServiceModelVo extends BaseVo {

	private static final long serialVersionUID = 4726411336603577966L;
	/** ID */
	private java.lang.Integer id;
	/** 服务车型代码 */
	private java.lang.String serviceModelCode;
	/** 服务代码 */
	private java.lang.String serviceCode;
	/** 车型ID */
	private java.lang.String modelId;
	
	/**
	 * 车型信息
	 */
	private String modelName;
	
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	/** 里程数范围 1 2 3 4 */
	private java.lang.Integer mileage;
	/** 工时费集合 */
	private java.lang.String laborcostJson;
	/** 总价 */
	private BigDecimal price;
	/** 操作人 */
	private java.lang.Integer operator;
	
	/**
	 * 操作人
	 */
	private String userName;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改时间
	 */
	private Date modifyDate;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
