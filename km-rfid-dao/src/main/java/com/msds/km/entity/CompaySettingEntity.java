package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CompaySettingEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:07 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CompaySettingEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**修理厂id*/
	private java.lang.Integer companyId;
	/**结算周期*/
	private java.lang.String settleCycle;
	/**上次结算日期*/
	private java.lang.String lastEndDate;

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
	 *@return: java.lang.Integer  修理厂id
	 */
	public java.lang.Integer getCompanyId(){
		return this.companyId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  修理厂id
	 */
	public void setCompanyId(java.lang.Integer companyId){
		this.companyId = companyId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算周期
	 */
	public java.lang.String getSettleCycle(){
		return this.settleCycle;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算周期
	 */
	public void setSettleCycle(java.lang.String settleCycle){
		this.settleCycle = settleCycle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上次结算日期
	 */
	public java.lang.String getLastEndDate(){
		return this.lastEndDate;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上次结算日期
	 */
	public void setLastEndDate(java.lang.String lastEndDate){
		this.lastEndDate = lastEndDate;
	}
}

