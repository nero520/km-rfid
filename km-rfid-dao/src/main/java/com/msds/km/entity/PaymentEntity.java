package com.msds.km.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>PaymentEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class PaymentEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**支付编号*/
	private java.lang.String sn;
	/**订单编号*/
	private java.lang.String orderSn;
	/**付款金额*/
	private BigDecimal amount;
	/**支付手续费*/
	private BigDecimal fee;
	/**状态 1未支付 2已支付 3支付失败*/
	private java.lang.Integer status;
	/**付款日期*/
	private java.util.Date paymentDate;
	/**支付流水号*/
	private java.lang.String paymentSerialNumber;
	/**支付方式*/
	private java.lang.String paymentMethod;
	/**支付插件id*/
	private java.lang.String paymentPluginId;
	/**到期时间*/
	private java.util.Date expire;
	/**方式 1线上 2线下*/
	private java.lang.Integer method;
	/**收款账号*/
	private java.lang.String account;
	/**收款银行*/
	private java.lang.String bank;
	/**付款人*/
	private java.lang.String payer;
	/**备注*/
	private java.lang.String memo;
	/**支付来源 0网站 1ios 2android*/
	private java.lang.Integer payType;

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
	 *@return: java.lang.String  支付编号
	 */
	public java.lang.String getSn(){
		return this.sn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付编号
	 */
	public void setSn(java.lang.String sn){
		this.sn = sn;
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
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  付款金额
	 */
	public BigDecimal getAmount(){
		return this.amount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  付款金额
	 */
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  支付手续费
	 */
	public BigDecimal getFee(){
		return this.fee;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  支付手续费
	 */
	public void setFee(BigDecimal fee){
		this.fee = fee;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态 1未支付 2已支付 3支付失败
	 */
	public java.lang.Integer getStatus(){
		return this.status;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态 1未支付 2已支付 3支付失败
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  付款日期
	 */
	public java.util.Date getPaymentDate(){
		return this.paymentDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  付款日期
	 */
	public void setPaymentDate(java.util.Date paymentDate){
		this.paymentDate = paymentDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付流水号
	 */
	public java.lang.String getPaymentSerialNumber(){
		return this.paymentSerialNumber;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付流水号
	 */
	public void setPaymentSerialNumber(java.lang.String paymentSerialNumber){
		this.paymentSerialNumber = paymentSerialNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */
	public java.lang.String getPaymentMethod(){
		return this.paymentMethod;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付方式
	 */
	public void setPaymentMethod(java.lang.String paymentMethod){
		this.paymentMethod = paymentMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付插件id
	 */
	public java.lang.String getPaymentPluginId(){
		return this.paymentPluginId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付插件id
	 */
	public void setPaymentPluginId(java.lang.String paymentPluginId){
		this.paymentPluginId = paymentPluginId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到期时间
	 */
	public java.util.Date getExpire(){
		return this.expire;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到期时间
	 */
	public void setExpire(java.util.Date expire){
		this.expire = expire;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  方式 1线上 2线下
	 */
	public java.lang.Integer getMethod(){
		return this.method;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  方式 1线上 2线下
	 */
	public void setMethod(java.lang.Integer method){
		this.method = method;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款账号
	 */
	public java.lang.String getAccount(){
		return this.account;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款账号
	 */
	public void setAccount(java.lang.String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款银行
	 */
	public java.lang.String getBank(){
		return this.bank;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款银行
	 */
	public void setBank(java.lang.String bank){
		this.bank = bank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款人
	 */
	public java.lang.String getPayer(){
		return this.payer;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款人
	 */
	public void setPayer(java.lang.String payer){
		this.payer = payer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getMemo(){
		return this.memo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支付来源 0网站 1ios 2android
	 */
	public java.lang.Integer getPayType(){
		return this.payType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支付来源 0网站 1ios 2android
	 */
	public void setPayType(java.lang.Integer payType){
		this.payType = payType;
	}
}

