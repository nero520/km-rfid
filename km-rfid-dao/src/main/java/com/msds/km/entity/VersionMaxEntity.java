package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>VersionMaxEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-01-13 09:55:50 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class VersionMaxEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**系统 1iphone 2andriod*/
	private java.lang.Integer osType;
	/**c_m_version主键*/
	private java.lang.Integer versionId;
	/**冗余*/
	private java.lang.Integer versionCode;

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
	 *@return: java.lang.Integer  c_m_version主键
	 */
	public java.lang.Integer getVersionId(){
		return this.versionId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  c_m_version主键
	 */
	public void setVersionId(java.lang.Integer versionId){
		this.versionId = versionId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  冗余
	 */
	public java.lang.Integer getVersionCode(){
		return this.versionCode;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  冗余
	 */
	public void setVersionCode(java.lang.Integer versionCode){
		this.versionCode = versionCode;
	}
}

