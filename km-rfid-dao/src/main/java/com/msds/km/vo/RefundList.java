package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>RefundEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class RefundList extends BaseEntity {
	
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
	/**操作时间*/
	private Date modifyDate;
	
	private String userPerson;
	/** 支付流水号 */
	private String paymentSerialNumber;
	
	/**
	 * 当前时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
	private Date nowDate;
	/**
	 * 之前时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
	private Date afterDate;
	/**
	 * 车主手机号
	 */
	private String phone;
	/**
	 * 车信息
	 */
	private String modelGroupName;
	/**
	 * 订单状态
	 */
	private String orderState;
	/**
	 * 车牌号
	 * 
	 */
	private String license;
	
	/**
	 * 预约服务
	 */
	private String serviceName;
	/**
	 * 车和车牌号信息
	 */
	private String carInfo;
	/**
	 * 配件单号
	 */
	private String partsSn;
	/**
	 * 退货单编号
	 * @return
	 */
	private String returnSn;
	/**
	 * 用户名
	 * @return
	 */
	private String name;
	
	
	public String getUserPerson() {
		return userPerson;
	}
	public void setUserPerson(String userPerson) {
		this.userPerson = userPerson;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartsSn() {
		return partsSn;
	}
	public void setPartsSn(String partsSn) {
		this.partsSn = partsSn;
	}
	public String getReturnSn() {
		return returnSn;
	}
	public void setReturnSn(String returnSn) {
		this.returnSn = returnSn;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getCarInfo() {
		return (license==null?"":license)+"<br>"+(modelGroupName==null?"":modelGroupName);
	}
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getModelGroupName() {
		return modelGroupName;
	}
	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
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
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public Date getAfterDate() {
		return afterDate;
	}
	public void setAfterDate(Date afterDate) {
		this.afterDate = afterDate;
	}
	/**
	 * @return the 支付流水号
	 */
	public String getPaymentSerialNumber() {
		return paymentSerialNumber;
	}
	/**
	 * @param 支付流水号 the paymentSerialNumber to set
	 */
	public void setPaymentSerialNumber(String paymentSerialNumber) {
		this.paymentSerialNumber = paymentSerialNumber;
	}
}

