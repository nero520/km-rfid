package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>RefundEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class RefundEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**退款单编号*/
	private java.lang.String refundSn;
	/**订单编号*/
	private java.lang.String orderSn;
	/**客户ID*/
	private java.lang.Integer memberId;
	/**退款金额*/
	private BigDecimal price;
	/**退款状态 0待处理 1已处理*/
	private java.lang.Integer state;
	/**退款支付流水*/
	private java.lang.String payCode;
	/**原支付方式保存字符串*/
	private java.lang.String oldPayMode;
	/**退款批次*/
	private java.lang.String batchNo;
	/**原支付流水*/
	private java.lang.String oldPayCode;
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
	 *@return: java.lang.String  退款单编号
	 */
	public java.lang.String getRefundSn(){
		return this.refundSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退款单编号
	 */
	public void setRefundSn(java.lang.String refundSn){
		this.refundSn = refundSn;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  客户ID
	 */
	public java.lang.Integer getMemberId(){
		return this.memberId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  客户ID
	 */
	public void setMemberId(java.lang.Integer memberId){
		this.memberId = memberId;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  退款金额
	 */
	public BigDecimal getPrice(){
		return this.price;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  退款金额
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  退款状态 0待处理 1已处理
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  退款状态 0待处理 1已处理
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退款支付流水
	 */
	public java.lang.String getPayCode(){
		return this.payCode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退款支付流水
	 */
	public void setPayCode(java.lang.String payCode){
		this.payCode = payCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原支付方式保存字符串
	 */
	public java.lang.String getOldPayMode(){
		return this.oldPayMode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原支付方式保存字符串
	 */
	public void setOldPayMode(java.lang.String oldPayMode){
		this.oldPayMode = oldPayMode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退款批次
	 */
	public java.lang.String getBatchNo(){
		return this.batchNo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退款批次
	 */
	public void setBatchNo(java.lang.String batchNo){
		this.batchNo = batchNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  原支付流水
	 */
	public java.lang.String getOldPayCode(){
		return this.oldPayCode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  原支付流水
	 */
	public void setOldPayCode(java.lang.String oldPayCode){
		this.oldPayCode = oldPayCode;
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

