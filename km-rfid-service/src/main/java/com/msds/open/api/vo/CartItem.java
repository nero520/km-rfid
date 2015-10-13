package com.msds.open.api.vo;

import java.io.Serializable;

public class CartItem implements Serializable {

	private static final long serialVersionUID = 3683502865351715071L;

	/**
	 * 商品ID
	 */
	private String productId;
	/**
	 * 数量
	 */
	private Integer quantity;

	/**
	 * @Description 获取 商品ID
	 * @return String
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @Description 设置 商品ID
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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

}
