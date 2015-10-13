package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>ReturnEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ReturnEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**退货单编号*/
	private java.lang.String returnSn;
	/**订单编号*/
	private java.lang.String orderSn;
	/**商品对象JSON*/
	private java.lang.String productJson;
	/**直营店ID*/
	private java.lang.String directShopId;
	/**修理厂ID*/
	private java.lang.Integer companyId;
	/**退货状态  0等待退货 1退货确认*/
	private java.lang.Integer status;
	/**退货备注*/
	private java.lang.String remark;
	/**配件退货单号*/
	private java.lang.String partsReturnSn;
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
	 *@return: java.lang.String  退货单编号
	 */
	public java.lang.String getReturnSn(){
		return this.returnSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退货单编号
	 */
	public void setReturnSn(java.lang.String returnSn){
		this.returnSn = returnSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单编号
	 */
	public java.lang.String getOrderSn(){
		return this.orderSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
	 */
	public void setOrderSn(java.lang.String orderSn){
		this.orderSn = orderSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品对象JSON
	 */
	public java.lang.String getProductJson(){
		return this.productJson;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品对象JSON
	 */
	public void setProductJson(java.lang.String productJson){
		this.productJson = productJson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  直营店ID
	 */
	public java.lang.String getDirectShopId(){
		return this.directShopId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  直营店ID
	 */
	public void setDirectShopId(java.lang.String directShopId){
		this.directShopId = directShopId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  修理厂ID
	 */
	public java.lang.Integer getCompanyId(){
		return this.companyId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  修理厂ID
	 */
	public void setCompanyId(java.lang.Integer companyId){
		this.companyId = companyId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  退货状态  0等待退货 1退货确认
	 */
	public java.lang.Integer getStatus(){
		return this.status;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  退货状态  0等待退货 1退货确认
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退货备注
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退货备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配件退货单号
	 */
	public java.lang.String getPartsReturnSn(){
		return this.partsReturnSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配件退货单号
	 */
	public void setPartsReturnSn(java.lang.String partsReturnSn){
		this.partsReturnSn = partsReturnSn;
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

