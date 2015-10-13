package com.msds.km.vo;

import java.math.BigDecimal;

/**
 * 前台工时信息包装类
 * 
 * @ClassName Laborcost
 * @Description TODO
 * @author LiLong
 * @date 2015年4月29日 下午1:35:29
 * 
 */
public class Laborcost extends BaseVo {

	private static final long serialVersionUID = 8535523157450499360L;

	/** ID */
	private java.lang.Integer id;
	/** 服务小项名称 */
	private java.lang.String itemName;
	/** 价格 */
	private BigDecimal price;

	/**
	 * @Description 获取 ID
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * @Description 设置 ID
	 * @param id
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * @Description 获取 服务小项名称
	 * @return java.lang.String
	 */
	public java.lang.String getItemName() {
		return itemName;
	}

	/**
	 * @Description 设置 服务小项名称
	 * @param itemName
	 */
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @Description 获取 价格
	 * @return BigDecimal
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @Description 设置 价格
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
