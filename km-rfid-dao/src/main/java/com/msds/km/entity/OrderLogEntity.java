package com.msds.km.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>OrderLogEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-18 17:11:43 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class OrderLogEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**订单编号*/
	private java.lang.String orderSn;
	/**下单客户*/
	private java.lang.Integer memberId;
	/**总金额*/
	private BigDecimal price;
	/**折扣*/
	private BigDecimal discount;
	/**实际价格*/
	private BigDecimal amount;
	/**订单类型 1保养 2洗车*/
	private java.lang.Integer orderType;
	/**订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成*/
	private java.lang.Integer orderState;
	/**支付状态 1未支付 2已支付 3已退款*/
	private java.lang.Integer paymentState;
	/**支付类型 1在线支付 2线下支付*/
	private java.lang.Integer paymentType;
	/**支付方式*/
	private java.lang.Integer paymentMethod;
	/**支付时间*/
	private java.util.Date paymentDate;
	/**联系人*/
	private java.lang.String contact;
	/**联系电话*/
	private java.lang.String phone;
	/**服务code*/
	private java.lang.String serviceCode;
	/**服务名称*/
	private java.lang.String serviceName;
	/**服务方式 1到店 2上门*/
	private java.lang.Integer serviceMethod;
	/**服务地址*/
	private java.lang.String serviceAddress;
	/**车型ID*/
	private java.lang.Integer modelId;
	/**车型组合名称(品牌车系排量年份)*/
	private java.lang.String modelGroupName;
	/**车牌号*/
	private java.lang.String license;
	/**里程数*/
	private BigDecimal mileage;
	/**vin*/
	private java.lang.String vin;
	/**buy_date*/
	private java.util.Date buyDate;
	/**商品集合JSON(id\数量\名称\价格)*/
	private java.lang.String productsJson;
	/**商品总价格(冗余)*/
	private BigDecimal productPrice;
	/**工时费集合*/
	private java.lang.String laborcostJson;
	/**服务时间*/
	private java.util.Date serviceTime;
	/**修理厂ID*/
	private java.lang.Integer companyId;
	/**修理厂名称*/
	private java.lang.String companyName;
	/**修理厂地址*/
	private java.lang.String companyAddress;
	/**修理厂电话*/
	private java.lang.String companyPhone;
	/**备注*/
	private java.lang.String remark;
	/**失效时间*/
	private java.util.Date invalidDate;
	/**来源 0网站 1App 2微信 4wap 5ios 6 android*/
	private java.lang.Integer source;
	/**配件单号*/
	private java.lang.String partsSn;
	/**配件单状态 1等待配送 2配送中 3配送完成 4已退货*/
	private java.lang.Integer partsState;
	/**直营店编号*/
	private java.lang.String directShopId;
	/**服务完成时间*/
	private java.util.Date serivceFinishDate;
	/**操作人*/
	private java.lang.String operationPerson;
	/**操作时间*/
	private java.util.Date operationDate;
	/**操作备注*/
	private java.lang.String operationRemark;

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
	 *@return: java.lang.Integer  下单客户
	 */
	public java.lang.Integer getMemberId(){
		return this.memberId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下单客户
	 */
	public void setMemberId(java.lang.Integer memberId){
		this.memberId = memberId;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  总金额
	 */
	public BigDecimal getPrice(){
		return this.price;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  总金额
	 */
	public void setPrice(BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  折扣
	 */
	public BigDecimal getDiscount(){
		return this.discount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  折扣
	 */
	public void setDiscount(BigDecimal discount){
		this.discount = discount;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  实际价格
	 */
	public BigDecimal getAmount(){
		return this.amount;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  实际价格
	 */
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单类型 1保养 2洗车
	 */
	public java.lang.Integer getOrderType(){
		return this.orderType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单类型 1保养 2洗车
	 */
	public void setOrderType(java.lang.Integer orderType){
		this.orderType = orderType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成
	 */
	public java.lang.Integer getOrderState(){
		return this.orderState;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成
	 */
	public void setOrderState(java.lang.Integer orderState){
		this.orderState = orderState;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支付状态 1未支付 2已支付 3已退款
	 */
	public java.lang.Integer getPaymentState(){
		return this.paymentState;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支付状态 1未支付 2已支付 3已退款
	 */
	public void setPaymentState(java.lang.Integer paymentState){
		this.paymentState = paymentState;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支付类型 1在线支付 2线下支付
	 */
	public java.lang.Integer getPaymentType(){
		return this.paymentType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支付类型 1在线支付 2线下支付
	 */
	public void setPaymentType(java.lang.Integer paymentType){
		this.paymentType = paymentType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  支付方式
	 */
	public java.lang.Integer getPaymentMethod(){
		return this.paymentMethod;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  支付方式
	 */
	public void setPaymentMethod(java.lang.Integer paymentMethod){
		this.paymentMethod = paymentMethod;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  支付时间
	 */
	public java.util.Date getPaymentDate(){
		return this.paymentDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  支付时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setPaymentDate(java.util.Date paymentDate){
		this.paymentDate = paymentDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	public java.lang.String getContact(){
		return this.contact;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setContact(java.lang.String contact){
		this.contact = contact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	public java.lang.String getPhone(){
		return this.phone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务code
	 */
	public java.lang.String getServiceCode(){
		return this.serviceCode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务code
	 */
	public void setServiceCode(java.lang.String serviceCode){
		this.serviceCode = serviceCode;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  服务方式 1到店 2上门
	 */
	public java.lang.Integer getServiceMethod(){
		return this.serviceMethod;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  服务方式 1到店 2上门
	 */
	public void setServiceMethod(java.lang.Integer serviceMethod){
		this.serviceMethod = serviceMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务地址
	 */
	public java.lang.String getServiceAddress(){
		return this.serviceAddress;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务地址
	 */
	public void setServiceAddress(java.lang.String serviceAddress){
		this.serviceAddress = serviceAddress;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车型ID
	 */
	public java.lang.Integer getModelId(){
		return this.modelId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车型ID
	 */
	public void setModelId(java.lang.Integer modelId){
		this.modelId = modelId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型组合名称(品牌车系排量年份)
	 */
	public java.lang.String getModelGroupName(){
		return this.modelGroupName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型组合名称(品牌车系排量年份)
	 */
	public void setModelGroupName(java.lang.String modelGroupName){
		this.modelGroupName = modelGroupName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */
	public java.lang.String getLicense(){
		return this.license;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setLicense(java.lang.String license){
		this.license = license;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  里程数
	 */
	public BigDecimal getMileage(){
		return this.mileage;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  里程数
	 */
	public void setMileage(BigDecimal mileage){
		this.mileage = mileage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  vin
	 */
	public java.lang.String getVin(){
		return this.vin;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  vin
	 */
	public void setVin(java.lang.String vin){
		this.vin = vin;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  buy_date
	 */
	public java.util.Date getBuyDate(){
		return this.buyDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  buy_date
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setBuyDate(java.util.Date buyDate){
		this.buyDate = buyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品集合JSON(id\数量\名称\价格)
	 */
	public java.lang.String getProductsJson(){
		return this.productsJson;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品集合JSON(id\数量\名称\价格)
	 */
	public void setProductsJson(java.lang.String productsJson){
		this.productsJson = productsJson;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  商品总价格(冗余)
	 */
	public BigDecimal getProductPrice(){
		return this.productPrice;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  商品总价格(冗余)
	 */
	public void setProductPrice(BigDecimal productPrice){
		this.productPrice = productPrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工时费集合
	 */
	public java.lang.String getLaborcostJson(){
		return this.laborcostJson;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工时费集合
	 */
	public void setLaborcostJson(java.lang.String laborcostJson){
		this.laborcostJson = laborcostJson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  服务时间
	 */
	public java.util.Date getServiceTime(){
		return this.serviceTime;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  服务时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setServiceTime(java.util.Date serviceTime){
		this.serviceTime = serviceTime;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修理厂名称
	 */
	public java.lang.String getCompanyName(){
		return this.companyName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修理厂名称
	 */
	public void setCompanyName(java.lang.String companyName){
		this.companyName = companyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修理厂地址
	 */
	public java.lang.String getCompanyAddress(){
		return this.companyAddress;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修理厂地址
	 */
	public void setCompanyAddress(java.lang.String companyAddress){
		this.companyAddress = companyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修理厂电话
	 */
	public java.lang.String getCompanyPhone(){
		return this.companyPhone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修理厂电话
	 */
	public void setCompanyPhone(java.lang.String companyPhone){
		this.companyPhone = companyPhone;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  失效时间
	 */
	public java.util.Date getInvalidDate(){
		return this.invalidDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  失效时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setInvalidDate(java.util.Date invalidDate){
		this.invalidDate = invalidDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  来源 0网站 1App 2微信 4wap 5ios 6 android
	 */
	public java.lang.Integer getSource(){
		return this.source;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  来源 0网站 1App 2微信 4wap 5ios 6 android
	 */
	public void setSource(java.lang.Integer source){
		this.source = source;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配件单号
	 */
	public java.lang.String getPartsSn(){
		return this.partsSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配件单号
	 */
	public void setPartsSn(java.lang.String partsSn){
		this.partsSn = partsSn;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  配件单状态 1等待配送 2配送中 3配送完成 4已退货
	 */
	public java.lang.Integer getPartsState(){
		return this.partsState;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  配件单状态 1等待配送 2配送中 3配送完成 4已退货
	 */
	public void setPartsState(java.lang.Integer partsState){
		this.partsState = partsState;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  直营店编号
	 */
	public java.lang.String getDirectShopId(){
		return this.directShopId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  直营店编号
	 */
	public void setDirectShopId(java.lang.String directShopId){
		this.directShopId = directShopId;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作人
	 */
	public java.lang.String getOperationPerson(){
		return this.operationPerson;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作人
	 */
	public void setOperationPerson(java.lang.String operationPerson){
		this.operationPerson = operationPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  操作时间
	 */
	public java.util.Date getOperationDate(){
		return this.operationDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  操作时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
	public void setOperationDate(java.util.Date operationDate){
		this.operationDate = operationDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作备注
	 */
	public java.lang.String getOperationRemark(){
		return this.operationRemark;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作备注
	 */
	public void setOperationRemark(java.lang.String operationRemark){
		this.operationRemark = operationRemark;
	}
}

