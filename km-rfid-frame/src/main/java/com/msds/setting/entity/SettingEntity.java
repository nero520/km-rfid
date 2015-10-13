package com.msds.setting.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>SettingEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-26 10:58:07 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class SettingEntity extends BaseEntity {

	private java.lang.Integer id;
	/** name */
	private java.lang.String name;
	/** value */
	private java.lang.String value;
	/** operater_id */
	private java.lang.Integer operaterId;

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String name
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String value
	 */
	public java.lang.String getValue() {
		return this.value;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String value
	 */
	public void setValue(java.lang.String value) {
		this.value = value;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer operater_id
	 */
	public java.lang.Integer getOperaterId() {
		return this.operaterId;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer operater_id
	 */
	public void setOperaterId(java.lang.Integer operaterId) {
		this.operaterId = operaterId;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}
}
