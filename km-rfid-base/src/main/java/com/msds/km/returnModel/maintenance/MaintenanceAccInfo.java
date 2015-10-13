package com.msds.km.returnModel.maintenance;

import java.math.BigDecimal;



public class MaintenanceAccInfo {

	/** 配件康众编码 */
	private String accId;
	/** 品牌名称 */
	private String brandName;
	/** 配件名称 */
	private String name;
	/** 普通价 */
	private BigDecimal genaralPrice;
	/** 零售价 */
	private BigDecimal retailPrice;
	/**
	 * 获取  配件康众编码
	 * @return  accId  配件康众编码
	 */
	public String getAccId() {
		return accId;
	}
	/**
	 * 设置  配件康众编码
	 * @param  accId  配件康众编码
	 */
	public void setAccId(String accId) {
		this.accId = accId;
	}
	/**
	 * 获取  品牌名称
	 * @return  brandName  品牌名称
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 设置  品牌名称
	 * @param  brandName  品牌名称
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取  配件名称
	 * @return  name  配件名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置  配件名称
	 * @param  name  配件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取  普通价
	 * @return  genaralPrice  普通价
	 */
	public BigDecimal getGenaralPrice() {
		return genaralPrice;
	}
	/**
	 * 设置  普通价
	 * @param  genaralPrice  普通价
	 */
	public void setGenaralPrice(BigDecimal genaralPrice) {
		this.genaralPrice = genaralPrice;
	}
	/**
	 * 获取  零售价
	 * @return  retailPrice  零售价
	 */
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	/**
	 * 设置  零售价
	 * @param  retailPrice  零售价
	 */
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

}
