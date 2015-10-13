package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>OrderEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-27 15:31:32 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class OrderlistEntity extends BaseEntity {
	private int id;
	/** 订单编号 */
	private java.lang.String orderSn;
	/** 总金额 */
	private BigDecimal price;
	/** 实际价格 */
	private BigDecimal amount;
	/** 订单状态 99异常订单 1待付款 2待确认 3待服务 4已经完成 11已取消 12退款中 13退款完成 */
	private java.lang.Integer orderState;
	/** 支付状态 1未支付 2已支付 3已退款 */
	private java.lang.Integer paymentState;
	/** 联系电话 */
	private java.lang.String phone;
	/** 服务名称 */
	private java.lang.String serviceName;
	/** 服务时间 */
	private Date serviceTime;
	/** 配件单号 */
	private String partsSn;
	private String modelGroupName;
	private Date modifyDate;
	private String contact;

	/** 品牌名字 */
	private String brandName;
	/** 车系名称 */
	private String seriesName;
	/** 生产年份 */
	/*private String madeYear;*/
	/** 车牌号 */
	private String license;

	/**
	 * 支付类型
	 */
	private Integer paymentType;

	/**
	 * 支付方式
	 */
	private Integer paymentMethod;

	/** 修理厂信息 */
	private String factoryInfo;
	/** 服务时间 */
	private String officeHours;
	/** 车主手机号 */
	private String customerPhone;
	/** 公司名称 */
	private String username;

	/** 公司地址 */
	private String fullAddress;


	private Integer memberId;

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModelGroupName() {
		return modelGroupName;
	}

	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

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

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public java.lang.String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(java.lang.String orderSn) {
		this.orderSn = orderSn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public java.lang.Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(java.lang.Integer orderState) {
		this.orderState = orderState;
	}

	public java.lang.Integer getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(java.lang.Integer paymentState) {
		this.paymentState = paymentState;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getServiceName() {
		return serviceName;
	}

	public void setServiceName(java.lang.String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @Description 获取 创建时间
	 * @return Date
	 */
	public java.util.Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(java.util.Date serviceTime) {
		this.serviceTime = serviceTime;
	}


	public String getPartsSn() {
		return partsSn;
	}

	public void setPartsSn(String partsSn) {
		this.partsSn = partsSn;
	}

	public String getFactoryInfo() {
		if (username == null || customerPhone == null || officeHours == null) {
			return factoryInfo;
		}
		return username + customerPhone  + officeHours;
	}

	public void setFactoryInfo(String factoryInfo) {
		this.factoryInfo = factoryInfo;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getContactsPhone() {
		return customerPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.customerPhone = contactsPhone;
	}


	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

}
