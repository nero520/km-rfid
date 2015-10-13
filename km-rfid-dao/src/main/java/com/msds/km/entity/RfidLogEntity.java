package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>RfidLogEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-10 13:29:15 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class RfidLogEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**epc号*/
	private java.lang.String epcNo;
	/**省ID*/
	private java.lang.Integer proviceId;
	/**市ID*/
	private java.lang.Integer cityId;
	/**街道ID*/
	private java.lang.Integer streetId;
	/**地址全称*/
	private java.lang.String fullArea;

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
	 *@return: java.lang.Integer  省ID
	 */
	public java.lang.Integer getProviceId(){
		return this.proviceId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  省ID
	 */
	public void setProviceId(java.lang.Integer proviceId){
		this.proviceId = proviceId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  市ID
	 */
	public java.lang.Integer getCityId(){
		return this.cityId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  市ID
	 */
	public void setCityId(java.lang.Integer cityId){
		this.cityId = cityId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  街道ID
	 */
	public java.lang.Integer getStreetId(){
		return this.streetId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  街道ID
	 */
	public void setStreetId(java.lang.Integer streetId){
		this.streetId = streetId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址全称
	 */
	public java.lang.String getFullArea(){
		return this.fullArea;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址全称
	 */
	public void setFullArea(java.lang.String fullArea){
		this.fullArea = fullArea;
	}
}

