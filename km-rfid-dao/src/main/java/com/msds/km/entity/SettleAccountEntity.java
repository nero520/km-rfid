package com.msds.km.entity;

import java.math.BigDecimal;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-04 15:11:30 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class SettleAccountEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**修理厂Id*/
	private java.lang.Integer companyId;
	/**对账单号*/
	private java.lang.String settleSn;
	/**当次结算起始日期（格式：2015-06-01）*/
	private java.lang.String startDate;
	/**当次结算结束日期（格式：2015-06-30）*/
	private java.lang.String endDate;
	/**结算总金额*/
	private BigDecimal settleAllAmount;
	/**实际结算金额*/
	private BigDecimal actualAmount;
	/**对账状态 SettleStateEnum 1未确认 2已确认 3已结算*/
	private java.lang.Integer settleState;
	/**收款方式：BillingTypeEnum 1.银行卡*/
	private java.lang.Integer billingType;
	/**银行户名*/
	private java.lang.String accountName;
	/**开户行*/
	private java.lang.String accountBankName;
	/**卡号*/
	private java.lang.String accountNumber;
	/**备注*/
	private java.lang.String remark;

	
	/******** 显示使用 *****begin**/
	/** 修理厂名 */
	private String companyName;
	/** 修理厂名 */
	private String companyAddress;
	/** 状态名称 */
	private String settleStateName;
	/******** 显示使用 *****end**/
	
	/******** 条件使用 *****begin**/
	/** 大于开始日期 */
	private String afterDate;
	/** 小于结束日期 */
	private String beforeDate;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  修理厂Id
	 */
	public java.lang.Integer getCompanyId(){
		return this.companyId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  修理厂Id
	 */
	public void setCompanyId(java.lang.Integer companyId){
		this.companyId = companyId;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当次结算起始日期（格式：2015-06-01）
	 */
	public java.lang.String getStartDate(){
		return this.startDate;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当次结算起始日期（格式：2015-06-01）
	 */
	public void setStartDate(java.lang.String startDate){
		this.startDate = startDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当次结算结束日期（格式：2015-06-30）
	 */
	public java.lang.String getEndDate(){
		return this.endDate;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当次结算结束日期（格式：2015-06-30）
	 */
	public void setEndDate(java.lang.String endDate){
		this.endDate = endDate;
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
	 *@return: java.lang.Integer  对账状态 SettleStateEnum 1未确认 2已确认 3已结算
	 */
	public java.lang.Integer getSettleState(){
		return this.settleState;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  对账状态 SettleStateEnum 1未确认 2已确认 3已结算
	 */
	public void setSettleState(java.lang.Integer settleState){
		this.settleState = settleState;
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
	 * @return the 修理厂名
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param 修理厂名 the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the 修理厂名
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * @param 修理厂名 the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * @return the 显示使
	 */
	public String getAfterDate() {
		return afterDate;
	}
	/**
	 * @param 显示使 the afterDate to set
	 */
	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}
	/**
	 * @return the 小于结束日期
	 */
	public String getBeforeDate() {
		return beforeDate;
	}
	/**
	 * @param 小于结束日期 the beforeDate to set
	 */
	public void setBeforeDate(String beforeDate) {
		this.beforeDate = beforeDate;
	}
	/**
	 * @return the 状态名称
	 */
	public String getSettleStateName() {
		return settleStateName;
	}
	/**
	 * @param 状态名称 the settleStateName to set
	 */
	public void setSettleStateName(String settleStateName) {
		this.settleStateName = settleStateName;
	}
}

