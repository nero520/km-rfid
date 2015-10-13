package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceLogEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-10 17:31:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MaintenanceLogEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**model_id*/
	private java.lang.Integer modelId;
	/**msg*/
	private java.lang.String msg;

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
	 *@return: java.lang.Integer  model_id
	 */
	public java.lang.Integer getModelId(){
		return this.modelId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  model_id
	 */
	public void setModelId(java.lang.Integer modelId){
		this.modelId = modelId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  msg
	 */
	public java.lang.String getMsg(){
		return this.msg;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  msg
	 */
	public void setMsg(java.lang.String msg){
		this.msg = msg;
	}
}

