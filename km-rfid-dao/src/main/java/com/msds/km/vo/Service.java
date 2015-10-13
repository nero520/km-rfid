package com.msds.km.vo;

import java.math.BigDecimal;

/**
 * 
 * @Description: 服务列表
 * @author xiaoxiong
 * @date 2015-4-29
 */
public class Service extends BaseVo {

	private static final long serialVersionUID = -8729401139230193947L;

	/** 服务编码 */
	private java.lang.String serviceCode;
	/** 车型ID */
	private java.lang.String modelId;
	/** 服务名称 */
	private java.lang.String serviceName;
	/** 描述 */
	private java.lang.String describe;

	/** 总价 */
	private BigDecimal price;
	
	/**
	 * 市Id
	 */
	private Integer cityId;
	
	
    

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public java.lang.String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(java.lang.String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public java.lang.String getServiceName() {
		return serviceName;
	}

	public void setServiceName(java.lang.String serviceName) {
		this.serviceName = serviceName;
	}

	public java.lang.String getDescribe() {
		return describe;
	}

	public void setDescribe(java.lang.String describe) {
		this.describe = describe;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public java.lang.String getModelId() {
		return modelId;
	}

	public void setModelId(java.lang.String modelId) {
		this.modelId = modelId;
	}

}
