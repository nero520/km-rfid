package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>ReasonEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ReasonEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**退货原因*/
	private java.lang.String reason;

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
	 *@return: java.lang.String  退货原因
	 */
	public java.lang.String getReason(){
		return this.reason;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退货原因
	 */
	public void setReason(java.lang.String reason){
		this.reason = reason;
	}
}

