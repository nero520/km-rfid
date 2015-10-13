package com.msds.plugin.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigAttributeEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-26 10:58:08 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class PluginConfigAttributeEntity extends BaseEntity {

	/** 插件id */
	private java.lang.Integer pluginConfig;
	/** 参数值 */
	private java.lang.String attributes;
	/** 参数名 */
	private java.lang.String name;

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 插件id
	 */
	public java.lang.Integer getPluginConfig() {
		return this.pluginConfig;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 插件id
	 */
	public void setPluginConfig(java.lang.Integer pluginConfig) {
		this.pluginConfig = pluginConfig;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 参数值
	 */
	public java.lang.String getAttributes() {
		return this.attributes;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 参数值
	 */
	public void setAttributes(java.lang.String attributes) {
		this.attributes = attributes;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 参数名
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 参数名
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}
}
