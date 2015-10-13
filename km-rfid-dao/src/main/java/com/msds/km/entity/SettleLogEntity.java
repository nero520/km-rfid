package com.msds.km.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>SettleLogEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:08 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class SettleLogEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**结算id*/
	private java.lang.Integer settleAccountId;
	/**操作人*/
	private java.lang.String operPerson;
	/**填写信息*/
	private java.lang.String remark;
	/**create_time*/
	private java.util.Date createTime;

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
	 *@return: java.lang.Integer  结算id
	 */
	public java.lang.Integer getSettleAccountId(){
		return this.settleAccountId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  结算id
	 */
	public void setSettleAccountId(java.lang.Integer settleAccountId){
		this.settleAccountId = settleAccountId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作人
	 */
	public java.lang.String getOperPerson(){
		return this.operPerson;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作人
	 */
	public void setOperPerson(java.lang.String operPerson){
		this.operPerson = operPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  填写信息
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  填写信息
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  create_time
	 */
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  create_time
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}

