package com.msds.km.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.msds.base.entity.BaseEntity;
import com.msds.km.vo.Product;
import com.msds.util.JsonUtils;

/**
 * 
 * <br>
 * <b>功能：</b>OrderEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-28 09:59:26 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class OrderEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 订单编号 */
	private java.lang.String orderSn;
	/** 下单客户 */
	private java.lang.Integer memberId;
	/** 总金额 */
	private BigDecimal price;
	/** 折扣 */
	private BigDecimal discount;
	/** 实际价格 */
	private BigDecimal amount;
	/** 订单类型 1保养 2洗车 */
	private java.lang.Integer orderType;
	/** 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成 */
	private java.lang.Integer orderState;
	/** 支付状态 1未支付 2已支付 3已退款 */
	private java.lang.Integer paymentState;
	/** 支付类型 1在线支付 2线下支付 */
	private java.lang.Integer paymentType;
	/** 支付方式 */
	private java.lang.Integer paymentMethod;
	/** 支付时间 */
	private java.util.Date paymentDate;
	/** 联系人 */
	private java.lang.String contact;
	/** 联系电话 */
	private java.lang.String phone;
	/** 服务code */
	private java.lang.String serviceCode;
	/** 服务名称 */
	private java.lang.String serviceName;
	/** 服务方式 */
	private java.lang.Integer serviceMethod;
	/** 服务地址 */
	private java.lang.String serviceAddress;
	/** 车型ID */
	private java.lang.Integer modelId;
	/** 车型组合名称(品牌车系排量年份) */
	private java.lang.String modelGroupName;
	/** 车牌号 */
	private java.lang.String license;
	/** 里程数 */
	private BigDecimal mileage;
	/** 车架号 */
	private java.lang.String vin;
	/** 购车日期 */
	private java.util.Date buyDate;
	/** 商品集合JSON(id\数量\名称\价格) */
	private java.lang.String productsJson;
	/** 商品总价格(冗余) */
	private BigDecimal productPrice;
	/** 工时费集合 */
	private java.lang.String laborcostJson;
	/** 服务时间 */
	private java.util.Date serviceTime;
	/** 修理厂ID */
	private java.lang.Integer companyId;
	/** 修理厂名称 */
	private java.lang.String companyName;
	/** 修理厂地址 */
	private java.lang.String companyAddress;
	/** 修理厂电话 */
	private java.lang.String companyPhone;
	/** 备注 */
	private java.lang.String remark;
	/** 失效时间 */
	private java.util.Date invalidDate;
	/** 来源 0网站 1App 2微信 3wap */
	private java.lang.Integer source;
	/** 配件单号 */
	private java.lang.String partsSn;
	/** 配件单状态 1等待配送 2配送中 3配送完成 4已退货 */
	private java.lang.Integer partsState;
	/** 直营店编号 */
	private java.lang.String directShopId;
	/** 服务完成时间 */
	private java.util.Date serivceFinishDate;

	/** 用作条件 */

	/** 结算开始日期 */
	private Date startDate;
	/** 结算结束日期 */
	private Date endDate;
	/**
	 * 之前时间
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
	 * 上下午
	 * 
	 * @return
	 */
	private String halfDay;
	/**
	 * 记录取消订单日志
	 * 
	 * @return
	 */
	private String remarkLog;

	/**
	 * 历史车主维修信息
	 */
	private String content;

	public String getContent() {

		if (serviceName != null && productsJson != null) {
			String str = "";
			List<Product> productEntities = JsonUtils.toObject(productsJson,
					new TypeReference<List<Product>>() {
					});
			for (int i = 0; i < productEntities.size(); i++) {
				str = str + productEntities.get(i).getProductName();
			}
			content = "项目：" + serviceName + "<br/>材料：" + str;
			return content;
		}
		return null;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemarkLog() {
		return remarkLog;
	}

	public void setRemarkLog(String remarkLog) {
		this.remarkLog = remarkLog;
	}

	public String getHalfDay() {
		return halfDay;
	}

	public void setHalfDay(String halfDay) {
		this.halfDay = halfDay;
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
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer ID
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 订单编号
	 */
	public java.lang.String getOrderSn() {
		return this.orderSn;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 订单编号
	 */
	public void setOrderSn(java.lang.String orderSn) {
		this.orderSn = orderSn;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 下单客户
	 */
	public java.lang.Integer getMemberId() {
		return this.memberId;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 下单客户
	 */
	public void setMemberId(java.lang.Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal 总金额
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal 总金额
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal 折扣
	 */
	public BigDecimal getDiscount() {
		return this.discount;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal 折扣
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal 实际价格
	 */
	public BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal 实际价格
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 订单类型 1保养 2洗车
	 */
	public java.lang.Integer getOrderType() {
		return this.orderType;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 订单类型 1保养 2洗车
	 */
	public void setOrderType(java.lang.Integer orderType) {
		this.orderType = orderType;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中
	 *          13退款完成
	 */
	public java.lang.Integer getOrderState() {
		return this.orderState;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中
	 *         13退款完成
	 */
	public void setOrderState(java.lang.Integer orderState) {
		this.orderState = orderState;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 支付状态 1未支付 2已支付 3已退款
	 */
	public java.lang.Integer getPaymentState() {
		return this.paymentState;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 支付状态 1未支付 2已支付 3已退款
	 */
	public void setPaymentState(java.lang.Integer paymentState) {
		this.paymentState = paymentState;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 支付类型 1在线支付 2线下支付
	 */
	public java.lang.Integer getPaymentType() {
		return this.paymentType;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 支付类型 1在线支付 2线下支付
	 */
	public void setPaymentType(java.lang.Integer paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 联系人
	 */
	public java.lang.String getContact() {
		return this.contact;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 联系人
	 */
	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 联系电话
	 */
	public java.lang.String getPhone() {
		return this.phone;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 联系电话
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * @Description 获取 服务code
	 * @return java.lang.String
	 */
	public java.lang.String getServiceCode() {
		return serviceCode;
	}

	/**
	 * @Description 设置 服务code
	 * @param serviceCode
	 */
	public void setServiceCode(java.lang.String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 服务名称
	 */
	public java.lang.String getServiceName() {
		return this.serviceName;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 服务名称
	 */
	public void setServiceName(java.lang.String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 车牌号
	 */
	public java.lang.String getLicense() {
		return this.license;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 车牌号
	 */
	public void setLicense(java.lang.String license) {
		this.license = license;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 商品集合JSON(id\数量\名称\价格)
	 */
	public java.lang.String getProductsJson() {
		return this.productsJson;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 商品集合JSON(id\数量\名称\价格)
	 */
	public void setProductsJson(java.lang.String productsJson) {
		this.productsJson = productsJson;
	}

	/**
	 * 方法: 取得BigDecimal
	 * 
	 * @return: BigDecimal 商品总价格(冗余)
	 */
	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	/**
	 * 方法: 设置BigDecimal
	 * 
	 * @param: BigDecimal 商品总价格(冗余)
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 工时费集合
	 */
	public java.lang.String getLaborcostJson() {
		return this.laborcostJson;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 工时费集合
	 */
	public void setLaborcostJson(java.lang.String laborcostJson) {
		this.laborcostJson = laborcostJson;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 服务时间
	 */
	public java.util.Date getServiceTime() {
		return this.serviceTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 服务时间
	 */
	public void setServiceTime(java.util.Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 修理厂ID
	 */
	public java.lang.Integer getCompanyId() {
		return this.companyId;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 修理厂ID
	 */
	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 备注
	 */
	public java.lang.String getRemark() {
		return this.remark;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 备注
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 失效时间
	 */
	public java.util.Date getInvalidDate() {
		return this.invalidDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 失效时间
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 来源 0网站 1App 2微信 3wap
	 */
	public java.lang.Integer getSource() {
		return this.source;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 来源 0网站 1App 2微信 3wap
	 */
	public void setSource(java.lang.Integer source) {
		this.source = source;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 配件单号
	 */
	public java.lang.String getPartsSn() {
		return this.partsSn;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 配件单号
	 */
	public void setPartsSn(java.lang.String partsSn) {
		this.partsSn = partsSn;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 配件单状态 1等待配送 2配送中 3配送完成 4已退货
	 */
	public java.lang.Integer getPartsState() {
		return this.partsState;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 配件单状态 1等待配送 2配送中 3配送完成 4已退货
	 */
	public void setPartsState(java.lang.Integer partsState) {
		this.partsState = partsState;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 直营店编号
	 */
	public java.lang.String getDirectShopId() {
		return this.directShopId;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 直营店编号
	 */
	public void setDirectShopId(java.lang.String directShopId) {
		this.directShopId = directShopId;
	}

	/**
	 * @Description 获取 里程数
	 * @return BigDecimal
	 */
	public BigDecimal getMileage() {
		return mileage;
	}

	/**
	 * @Description 设置 里程数
	 * @param mileage
	 */
	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}

	/**
	 * @Description 获取 车型ID
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getModelId() {
		return modelId;
	}

	/**
	 * @Description 设置 车型ID
	 * @param modelId
	 */
	public void setModelId(java.lang.Integer modelId) {
		this.modelId = modelId;
	}

	/**
	 * @Description 获取 车型组合名称(品牌车系排量年份)
	 * @return java.lang.String
	 */
	public java.lang.String getModelGroupName() {
		return modelGroupName;
	}

	/**
	 * @Description 设置 车型组合名称(品牌车系排量年份)
	 * @param modelGroupName
	 */
	public void setModelGroupName(java.lang.String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	/**
	 * @Description 获取 修理厂名称
	 * @return java.lang.String
	 */
	public java.lang.String getCompanyName() {
		return companyName;
	}

	/**
	 * @Description 设置 修理厂名称
	 * @param companyName
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @Description 获取 修理厂地址
	 * @return java.lang.String
	 */
	public java.lang.String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @Description 设置 修理厂地址
	 * @param companyAddress
	 */
	public void setCompanyAddress(java.lang.String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @Description 获取 支付时间
	 * @return java.util.Date
	 */
	public java.util.Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @Description 设置 支付时间
	 * @param paymentDate
	 */
	public void setPaymentDate(java.util.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @Description 获取 支付方式
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @Description 设置 支付方式
	 * @param paymentMethod
	 */
	public void setPaymentMethod(java.lang.Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public java.lang.Integer getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(java.lang.Integer serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	public java.lang.String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(java.lang.String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public java.util.Date getSerivceFinishDate() {
		return serivceFinishDate;
	}

	public void setSerivceFinishDate(java.util.Date serivceFinishDate) {
		this.serivceFinishDate = serivceFinishDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 获取VIN
	 * 
	 * @return vin
	 */
	public java.lang.String getVin() {
		return vin;
	}

	/**
	 * 设置VIN
	 * 
	 * @param vin
	 */
	public void setVin(java.lang.String vin) {
		this.vin = vin;
	}

	/**
	 * 获取购车日期
	 * 
	 * @return buyDate
	 */
	public java.util.Date getBuyDate() {
		return buyDate;
	}

	/**
	 * 设置购车日期
	 * 
	 * @param buyDate
	 */
	public void setBuyDate(java.util.Date buyDate) {
		this.buyDate = buyDate;
	}

	/**
	 * 修理厂电话
	 * 
	 * @return the companyPhone
	 */
	public java.lang.String getCompanyPhone() {
		return companyPhone;
	}

	/**
	 * 修理厂电话
	 * 
	 * @param companyPhone
	 */
	public void setCompanyPhone(java.lang.String companyPhone) {
		this.companyPhone = companyPhone;
	}
}
