package com.msds.km.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountItemEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 16:10:24 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class SettleAccountItemEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**修理厂Id*/
	private java.lang.Integer companyId;
	/**对账单号*/
	private java.lang.String settleSn;
	/**订单号*/
	private java.lang.String orderSn;
	/**服务名称*/
	private java.lang.String serviceName;
	/**服务时间*/
	private java.lang.String serviceTime;
	/**对账金额*/
	private BigDecimal settleAmount;
	
	
	/** 下单时间 */
	private Date orderCreateDate;
	/** 服务完成时间 */
	private java.util.Date serivceFinishDate;
	/** 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成 */
	private java.lang.Integer orderState;
	/** 订单总金额 */
	private BigDecimal price;
	/** 车牌号 */
	private java.lang.String license;
	/** 车型组合名称(品牌车系排量年份) */
	private java.lang.String modelGroupName;
	/** 联系人 */
	private java.lang.String contact;
	/** 联系电话 */
	private java.lang.String phone;
	
	
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
	 *@return: java.lang.String  订单号
	 */
	public java.lang.String getOrderSn(){
		return this.orderSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单号
	 */
	public void setOrderSn(java.lang.String orderSn){
		this.orderSn = orderSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务名称
	 */
	public java.lang.String getServiceName(){
		return this.serviceName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务名称
	 */
	public void setServiceName(java.lang.String serviceName){
		this.serviceName = serviceName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务时间
	 */
	public java.lang.String getServiceTime(){
		return this.serviceTime;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务时间
	 */
	public void setServiceTime(java.lang.String serviceTime){
		this.serviceTime = serviceTime;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  对账金额
	 */
	public BigDecimal getSettleAmount(){
		return this.settleAmount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  对账金额
	 */
	public void setSettleAmount(BigDecimal settleAmount){
		this.settleAmount = settleAmount;
	}
	/**
	 * @return the 下单时间
	 */
	public Date getOrderCreateDate() {
		return orderCreateDate;
	}
	/**
	 * @param 下单时间 the orderCreateDate to set
	 */
	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}
	/**
	 * @return the 服务完成时间
	 */
	public java.util.Date getSerivceFinishDate() {
		return serivceFinishDate;
	}
	/**
	 * @param 服务完成时间 the serivceFinishDate to set
	 */
	public void setSerivceFinishDate(java.util.Date serivceFinishDate) {
		this.serivceFinishDate = serivceFinishDate;
	}
	/**
	 * @return the 订单状态99异常订单1待付款2待确认3待服务4已经完成11已取消12退款中13退款完成
	 */
	public java.lang.Integer getOrderState() {
		return orderState;
	}
	/**
	 * @param 订单状态99异常订单1待付款2待确认3待服务4已经完成11已取消12退款中13退款完成 the orderState to set
	 */
	public void setOrderState(java.lang.Integer orderState) {
		this.orderState = orderState;
	}
	/**
	 * @return the 订单总金额
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param 订单总金额 the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the 车牌号
	 */
	public java.lang.String getLicense() {
		return license;
	}
	/**
	 * @param 车牌号 the license to set
	 */
	public void setLicense(java.lang.String license) {
		this.license = license;
	}
	/**
	 * @return the 车型组合名称(品牌车系排量年份)
	 */
	public java.lang.String getModelGroupName() {
		return modelGroupName;
	}
	/**
	 * @param 车型组合名称(品牌车系排量年份) the modelGroupName to set
	 */
	public void setModelGroupName(java.lang.String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	/**
	 * @return the 联系人
	 */
	public java.lang.String getContact() {
		return contact;
	}
	/**
	 * @param 联系人 the contact to set
	 */
	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}
	/**
	 * @return the 联系电话
	 */
	public java.lang.String getPhone() {
		return phone;
	}
	/**
	 * @param 联系电话 the phone to set
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
}

