package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>CompanyAccountEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:03 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CompanyAccountEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**修理厂Id*/
	private java.lang.Integer companyId;
	/**账号类型 BillTypeEnum 1银行卡号 2支付宝号3微信账号*/
	private java.lang.Integer billType;
	/**银行户名*/
	private java.lang.String accountName;
	/**开户行*/
	private java.lang.String accountBankName;
	/**卡号*/
	private java.lang.String accountNumber;

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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  账号类型 BillTypeEnum 1银行卡号 2支付宝号3微信账号
	 */
	public java.lang.Integer getBillType(){
		return this.billType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  账号类型 BillTypeEnum 1银行卡号 2支付宝号3微信账号
	 */
	public void setBillType(java.lang.Integer billType){
		this.billType = billType;
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
}

