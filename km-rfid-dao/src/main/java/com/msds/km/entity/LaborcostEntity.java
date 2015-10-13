package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>LaborcostEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class LaborcostEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**服务小项名称*/
	private java.lang.String itemName;
	/**价格*/
	private BigDecimal price;
	/**操作人*/
	private java.lang.Integer operator;

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
	 *@return: java.lang.String  服务小项名称
	 */
	public java.lang.String getItemName(){
		return this.itemName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务小项名称
	 */
	public void setItemName(java.lang.String itemName){
		this.itemName = itemName;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  价格
	 */
	public BigDecimal getPrice(){
		return this.price;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  价格
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  操作人
	 */
	public java.lang.Integer getOperator(){
		return this.operator;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  操作人
	 */
	public void setOperator(java.lang.Integer operator){
		this.operator = operator;
	}
}

