package com.msds.open.api.vo;

import java.io.Serializable;
import java.util.List;

public class OrderRequest implements Serializable {

	private static final long serialVersionUID = -2363079704539196565L;

	/**
	 * 客户号
	 */
	private String customerId;
	/**
	 * 商品信息
	 */
	private List<CartItem> cartItems;
	/**
	 * 收货地址
	 */
	private String receiverId;

	/**
	 * @Description 获取 客户号
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @Description 设置 客户号
	 * @param customerId
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @Description 获取 收货地址
	 * @return String
	 */
	public String getReceiverId() {
		return receiverId;
	}

	/**
	 * @Description 设置 收货地址
	 * @param receiverId
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * @Description 获取 商品信息
	 * @return List<CartItem>
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @Description 设置 商品信息
	 * @param cartItems
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
