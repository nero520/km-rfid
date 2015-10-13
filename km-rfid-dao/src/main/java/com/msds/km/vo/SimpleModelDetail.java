package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.List;

public class SimpleModelDetail extends BaseVo {

	private static final long serialVersionUID = -1105268670158764546L;

	/** 汽车品牌名称 */
	/*
	 * private java.lang.String brandName;
	 *//** 车系名称 */
	/*
	 * private java.lang.String seriesName;
	 *//** 年款 */
	/*
	 * private java.lang.String year;
	 *//** 排量 */
	/*
	 * private java.lang.String exhaustVolume;
	 */

	/**
	 * 我的爱车表id
	 */
	private Integer id;

	/**
	 * 车型id
	 */
	private Integer modelId;

	/** 车型组合名称(品牌车系排量年份) */
	private java.lang.String modelGroupName;

	/** 里程数 */
	private BigDecimal mileage;

	/** 所属区域 */
	private java.lang.String region;
	/** 车牌号 */
	private java.lang.String license;

	/** 品牌logo */
	private java.lang.String logo;

	/**
	 * 服务列表
	 */
	private List<Service> serviceList;

	public java.lang.String getRegion() {
		return region;
	}

	public void setRegion(java.lang.String region) {
		this.region = region;
	}

	public java.lang.String getLicense() {
		return license;
	}

	public void setLicense(java.lang.String license) {
		this.license = license;
	}

	public java.lang.String getLogo() {
		return logo;
	}

	public void setLogo(java.lang.String logo) {
		this.logo = logo;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	public java.lang.String getModelGroupName() {
		return modelGroupName;
	}

	public void setModelGroupName(java.lang.String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	public BigDecimal getMileage() {
		return mileage;
	}

	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 车型id
	 * 
	 * @return the modelId
	 */
	public Integer getModelId() {
		return modelId;
	}

	/**
	 * 车型id
	 * 
	 * @param modelId
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

}
