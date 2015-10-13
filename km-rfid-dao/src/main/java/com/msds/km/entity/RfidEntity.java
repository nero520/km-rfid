package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>RfidEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-10 13:29:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class RfidEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**epc号*/
	private java.lang.String epcNo;
	/**用户ID*/
	private java.lang.Integer userId;
	/**状态：0.失效；1.有效*/
	private java.lang.Integer state;

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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  epc号
	 */
	public java.lang.String getEpcNo(){
		return this.epcNo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  epc号
	 */
	public void setEpcNo(java.lang.String epcNo){
		this.epcNo = epcNo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户ID
	 */
	public java.lang.Integer getUserId(){
		return this.userId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户ID
	 */
	public void setUserId(java.lang.Integer userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态：0.失效；1.有效
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态：0.失效；1.有效
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
}

