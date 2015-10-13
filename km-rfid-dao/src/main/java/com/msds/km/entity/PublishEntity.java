package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PublishEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-09 11:28:24 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class PublishEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 类型(1首页轮播图、2更多期待) */
	private java.lang.Integer type;
	/** 描述 */
	private java.lang.String display;
	/** 跳转地址 */
	private java.lang.String link;
	/** 图片地址 */
	private java.lang.String img;
	/** 平台 1通用 2微信 3web 4wap 5ios 6android */
	private java.lang.Integer os;
	/** 排序 */
	private java.lang.Integer sort;
	/** 是否启用（1启用0禁用） */
	private java.lang.Integer enabled;

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer ID
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 类型(首页轮播图、更多期待)
	 */
	public java.lang.Integer getType() {
		return this.type;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 类型(首页轮播图、更多期待)
	 */
	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 描述
	 */
	public java.lang.String getDisplay() {
		return this.display;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 描述
	 */
	public void setDisplay(java.lang.String display) {
		this.display = display;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 跳转地址
	 */
	public java.lang.String getLink() {
		return this.link;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 跳转地址
	 */
	public void setLink(java.lang.String link) {
		this.link = link;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 图片地址
	 */
	public java.lang.String getImg() {
		return this.img;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 图片地址
	 */
	public void setImg(java.lang.String img) {
		this.img = img;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 平台 1通用 2微信 3web 4wap 5ios 6android
	 */
	public java.lang.Integer getOs() {
		return this.os;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 平台 1通用 2微信 3web 4wap 5ios 6android
	 */
	public void setOs(java.lang.Integer os) {
		this.os = os;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 排序
	 */
	public java.lang.Integer getSort() {
		return this.sort;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 排序
	 */
	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 是否启用（1启用0禁用）
	 */
	public java.lang.Integer getEnabled() {
		return this.enabled;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 是否启用（1启用0禁用）
	 */
	public void setEnabled(java.lang.Integer enabled) {
		this.enabled = enabled;
	}
}
