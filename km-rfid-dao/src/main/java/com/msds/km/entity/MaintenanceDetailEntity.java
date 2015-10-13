package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceDetailEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-10 15:51:20 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MaintenanceDetailEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**maintenance_id*/
	private java.lang.Integer maintenanceId;
	/**配件康众编码*/
	private java.lang.String accId;
	/**brand_name*/
	private java.lang.String brandName;
	/**配件名称*/
	private java.lang.String name;
	/**普通价格*/
	private BigDecimal genaralPrice;
	/**零售价*/
	private BigDecimal retailPrice;

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
	 *@return: java.lang.Integer  maintenance_id
	 */
	public java.lang.Integer getMaintenanceId(){
		return this.maintenanceId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  maintenance_id
	 */
	public void setMaintenanceId(java.lang.Integer maintenanceId){
		this.maintenanceId = maintenanceId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配件康众编码
	 */
	public java.lang.String getAccId(){
		return this.accId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配件康众编码
	 */
	public void setAccId(java.lang.String accId){
		this.accId = accId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  brand_name
	 */
	public java.lang.String getBrandName(){
		return this.brandName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  brand_name
	 */
	public void setBrandName(java.lang.String brandName){
		this.brandName = brandName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配件名称
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配件名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  普通价格
	 */
	public BigDecimal getGenaralPrice(){
		return this.genaralPrice;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  普通价格
	 */
	public void setGenaralPrice(BigDecimal genaralPrice){
		this.genaralPrice = genaralPrice;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  零售价
	 */
	public BigDecimal getRetailPrice(){
		return this.retailPrice;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  零售价
	 */
	public void setRetailPrice(BigDecimal retailPrice){
		this.retailPrice = retailPrice;
	}
}

