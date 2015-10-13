package com.msds.common;

import java.io.Serializable;

/**
 * 身份信息
 * 
 */
public class Principal implements Serializable {

	private static final long serialVersionUID = 5798882004228239559L;

	/** ID */
	private Integer id;

	/** 用户名 */
	private String username;
	/**直营店ID**/
	private String direct_shop_id;
	/**康众的客户号（系统生成）**/
	private String customer_id;

	/**
	 * @param id
	 *            ID
	 * @param username
	 *            用户名
	 */
	
	public String getDirect_shop_id() {
		return direct_shop_id;
	}




	public Principal(Integer id, String username, String direct_shop_id,
			String customer_id) {
		super();
		this.id = id;
		this.username = username;
		this.direct_shop_id = direct_shop_id;
		this.customer_id = customer_id;
	}




	public void setDirect_shop_id(String direct_shop_id) {
		this.direct_shop_id = direct_shop_id;
	}




	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return username;
	}




	public String getCustomer_id() {
		return customer_id;
	}




	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
}