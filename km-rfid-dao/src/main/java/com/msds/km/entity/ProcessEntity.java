package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>ProcessEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-06 18:33:25 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ProcessEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**process_name*/
	private java.lang.String processName;
	/**price*/
	private BigDecimal price;
	/**pid*/
	private java.lang.Integer pid;
	/**level*/
	private java.lang.Integer level;
	
	private Integer processId;
	private Integer processPid;
	private String processPname;
	

	public Integer getProcessId() {
		return processId;
	}
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	public Integer getProcessPid() {
		return processPid;
	}
	public void setProcessPid(Integer processPid) {
		this.processPid = processPid;
	}
	public String getProcessPname() {
		return processPname;
	}
	public void setProcessPname(String processPname) {
		this.processPname = processPname;
	}
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  pid
	 */
	public java.lang.Integer getPid(){
		return this.pid;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  pid
	 */
	public void setPid(java.lang.Integer pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  level
	 */
	public java.lang.Integer getLevel(){
		return this.level;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  level
	 */
	public void setLevel(java.lang.Integer level){
		this.level = level;
	}
}

