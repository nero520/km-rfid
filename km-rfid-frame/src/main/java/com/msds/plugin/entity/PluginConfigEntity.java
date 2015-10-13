package com.msds.plugin.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-26 10:58:07 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class PluginConfigEntity extends BaseEntity {

	private java.lang.Integer id;
	/** 排序 */
	private java.lang.Integer orders;
	/** 是否启用 */
	private Boolean isEnabled;
	/** 插件id */
	private java.lang.String pluginId;

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 排序
	 */
	public java.lang.Integer getOrders() {
		return this.orders;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 排序
	 */
	public void setOrders(java.lang.Integer orders) {
		this.orders = orders;
	}

	/**
	 * 方法: 取得Boolean
	 * 
	 * @return: Boolean 是否启用
	 */
	public Boolean getIsEnabled() {
		return this.isEnabled;
	}

	/**
	 * 方法: 设置Boolean
	 * 
	 * @param: Boolean 是否启用
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 插件id
	 */
	public java.lang.String getPluginId() {
		return this.pluginId;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 插件id
	 */
	public void setPluginId(java.lang.String pluginId) {
		this.pluginId = pluginId;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

}
