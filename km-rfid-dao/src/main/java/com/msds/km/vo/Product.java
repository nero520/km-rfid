package com.msds.km.vo;

import java.math.BigDecimal;

/**
 * 前台商品信息包装类
 * 
 * @ClassName Product
 * @Description TODO
 * @author LiLong
 * @date 2015年4月28日 下午3:00:42
 * 
 */
public class Product extends BaseVo {

	private static final long serialVersionUID = 6147218861366418908L;

	/** 康众商品Id */
	private String productId;
	/** 商品名称 */
	private String productName;
	/** 康民价 */
	private BigDecimal KMPrice;
	/** 快修店价 */
	private BigDecimal marketPrice;
	/** 数量 */
	private Integer quantity = 1;
	/** 图片 */
	private String icon;
	/**卖家**/
	private String company;
	
	
	
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @Description 获取 康众商品Id
	 * @return String
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @Description 设置 康众商品Id
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @Description 获取 商品名称
	 * @return String
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @Description 设置 商品名称
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @Description 获取 kMPrice
	 * @return BigDecimal
	 */
	public BigDecimal getKMPrice() {
		return KMPrice;
	}

	/**
	 * @Description 设置 kMPrice
	 * @param kMPrice
	 */
	public void setKMPrice(BigDecimal kMPrice) {
		KMPrice = kMPrice;
	}

	/**
	 * @Description 获取 快修店价
	 * @return BigDecimal
	 */
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	/**
	 * @Description 设置 快修店价
	 * @param marketPrice
	 */
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * @Description 获取 数量
	 * @return Integer
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @Description 设置 数量
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @Description 获取 图片
	 * @return String
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @Description 设置 图片
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
