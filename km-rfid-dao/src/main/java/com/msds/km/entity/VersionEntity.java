package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>VersionEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-09 14:05:51 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class VersionEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**系统 1iphone 2andriod*/
	private java.lang.Integer osType;
	/**版本号（内部识别）*/
	private java.lang.Integer versionCode;
	/**版本名称（外部显示）*/
	private java.lang.String versionName;
	/**下载链接*/
	private java.lang.String url;
	/**是否强制升级 0否 1是*/
	private java.lang.Integer forceUpdate;
	/**升级描述*/
	private java.lang.String description;

		/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */
	public java.lang.Integer getId(){
		return this.id;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  系统 1iphone 2andriod
	 */
	public java.lang.Integer getOsType(){
		return this.osType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  系统 1iphone 2andriod
	 */
	public void setOsType(java.lang.Integer osType){
		this.osType = osType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  版本号（内部识别）
	 */
	public java.lang.Integer getVersionCode(){
		return this.versionCode;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  版本号（内部识别）
	 */
	public void setVersionCode(java.lang.Integer versionCode){
		this.versionCode = versionCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  版本名称（外部显示）
	 */
	public java.lang.String getVersionName(){
		return this.versionName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  版本名称（外部显示）
	 */
	public void setVersionName(java.lang.String versionName){
		this.versionName = versionName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下载链接
	 */
	public java.lang.String getUrl(){
		return this.url;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下载链接
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否强制升级 0否 1是
	 */
	public java.lang.Integer getForceUpdate(){
		return this.forceUpdate;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否强制升级 0否 1是
	 */
	public void setForceUpdate(java.lang.Integer forceUpdate){
		this.forceUpdate = forceUpdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  升级描述
	 */
	public java.lang.String getDescription(){
		return this.description;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  升级描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
}

