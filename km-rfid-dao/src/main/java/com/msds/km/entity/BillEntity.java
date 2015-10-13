package com.msds.km.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>BillEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-06 13:00:13 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class BillEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**结算单号*/
	private java.lang.String billSn;
	/**对账单号*/
	private java.lang.String settleSn;
	/**服务完成时间*/
	private java.util.Date serivceFinishDate;
	/**收款方式：BillingTypeEnum 1.银行卡*/
	private java.lang.Integer billingType;
	/**银行户名*/
	private java.lang.String accountName;
	/**开户行*/
	private java.lang.String accountBankName;
	/**卡号*/
	private java.lang.String accountNumber;
	/**结算总金额*/
	private BigDecimal settleAllAmount;
	/**实际结算金额*/
	private BigDecimal actualAmount;
	/**结算状态 BillStateEnum 1已结算*/
	private java.lang.Integer billState;
	/**备注*/
	private java.lang.String remark;
	
	
	/******** 条件使用 *****begin**/
	/** 大于结束日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
	private Date afterDate;
	/** 小于开始日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
	private Date beforeDate;
	/******** 条件使用 *****end**/
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
	 *@return: java.lang.String  结算单号
	 */
	public java.lang.String getBillSn(){
		return this.billSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单号
	 */
	public void setBillSn(java.lang.String billSn){
		this.billSn = billSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对账单号
	 */
	public java.lang.String getSettleSn(){
		return this.settleSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对账单号
	 */
	public void setSettleSn(java.lang.String settleSn){
		this.settleSn = settleSn;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  服务完成时间
	 */
	public java.util.Date getSerivceFinishDate(){
		return this.serivceFinishDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  服务完成时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setSerivceFinishDate(java.util.Date serivceFinishDate){
		this.serivceFinishDate = serivceFinishDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  收款方式：BillingTypeEnum 1.银行卡
	 */
	public java.lang.Integer getBillingType(){
		return this.billingType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  收款方式：BillingTypeEnum 1.银行卡
	 */
	public void setBillingType(java.lang.Integer billingType){
		this.billingType = billingType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行户名
	 */
	public java.lang.String getAccountName(){
		return this.accountName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行户名
	 */
	public void setAccountName(java.lang.String accountName){
		this.accountName = accountName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户行
	 */
	public java.lang.String getAccountBankName(){
		return this.accountBankName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户行
	 */
	public void setAccountBankName(java.lang.String accountBankName){
		this.accountBankName = accountBankName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卡号
	 */
	public java.lang.String getAccountNumber(){
		return this.accountNumber;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卡号
	 */
	public void setAccountNumber(java.lang.String accountNumber){
		this.accountNumber = accountNumber;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  结算总金额
	 */
	public BigDecimal getSettleAllAmount(){
		return this.settleAllAmount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  结算总金额
	 */
	public void setSettleAllAmount(BigDecimal settleAllAmount){
		this.settleAllAmount = settleAllAmount;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  实际结算金额
	 */
	public BigDecimal getActualAmount(){
		return this.actualAmount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  实际结算金额
	 */
	public void setActualAmount(BigDecimal actualAmount){
		this.actualAmount = actualAmount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  结算状态 BillStateEnum 1已结算
	 */
	public java.lang.Integer getBillState(){
		return this.billState;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  结算状态 BillStateEnum 1已结算
	 */
	public void setBillState(java.lang.Integer billState){
		this.billState = billState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 * 获取  大于结束日期
	 * @return  afterDate  大于结束日期
	 */
	public Date getAfterDate() {
		return afterDate;
	}
	/**
	 * 设置  大于结束日期
	 * @param  afterDate  大于结束日期
	 */
	public void setAfterDate(Date afterDate) {
		this.afterDate = afterDate;
	}
	/**
	 * 获取  小于开始日期
	 * @return  beforeDate  小于开始日期
	 */
	public Date getBeforeDate() {
		return beforeDate;
	}
	/**
	 * 设置  小于开始日期
	 * @param  beforeDate  小于开始日期
	 */
	public void setBeforeDate(Date beforeDate) {
		this.beforeDate = beforeDate;
	}
}

