package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>BespeakDetailEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-07 16:19:26 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class BespeakDetailEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**预约单号*/
	private java.lang.String bespeakSn;
	/**工序id*/
	private java.lang.Integer processId;
	/**process_name*/
	private java.lang.String processName;
	/**process_pid*/
	private java.lang.Integer processPid;
	/**process_pname*/
	private java.lang.String processPname;
	/**price*/
	private BigDecimal price;

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
	 *@return: java.lang.String  预约单号
	 */
	public java.lang.String getBespeakSn(){
		return this.bespeakSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预约单号
	 */
	public void setBespeakSn(java.lang.String bespeakSn){
		this.bespeakSn = bespeakSn;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  工序id
	 */
	public java.lang.Integer getProcessId(){
		return this.processId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  工序id
	 */
	public void setProcessId(java.lang.Integer processId){
		this.processId = processId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  process_name
	 */
	public java.lang.String getProcessName(){
		return this.processName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  process_name
	 */
	public void setProcessName(java.lang.String processName){
		this.processName = processName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  process_pid
	 */
	public java.lang.Integer getProcessPid(){
		return this.processPid;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  process_pid
	 */
	public void setProcessPid(java.lang.Integer processPid){
		this.processPid = processPid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  process_pname
	 */
	public java.lang.String getProcessPname(){
		return this.processPname;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  process_pname
	 */
	public void setProcessPname(java.lang.String processPname){
		this.processPname = processPname;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  price
	 */
	public BigDecimal getPrice(){
		return this.price;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  price
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
}

