package com.msds.km.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CompanyEntity extends BaseEntity {

	/** ID */
	private java.lang.Integer id;
	/** 企业用户名 */
	private java.lang.String username;
	/** 密码 */
	private java.lang.String password;
	/** 公司名称 */
	private java.lang.String name;
	/** 公司电话 */
	private java.lang.String telephone;
	/** 省 */
	private java.lang.Integer province;
	/** 市 */
	private java.lang.Integer city;
	/** 区 */
	private java.lang.Integer area;
	/** 地址 */
	private java.lang.String address;
	/** 省市区地址(冗余) */
	private java.lang.String fullAddress;
	/** 联系人 */
	private java.lang.String contacts;
	/** 联系电话 */
	private java.lang.String contactsPhone;
	/** 客服电话 */
	private java.lang.String customerPhone;
	/** 服务时间 */
	private java.lang.String officeHours;
	/** 账户名 */
	private java.lang.String accountName;
	/** 账户号 */
	private java.lang.String accountNumber;
	/** 位置 */
	private java.lang.String location;
	/** 描述 */
	private java.lang.String describe;
	/** 营业执照 */
	private java.lang.String licensePic;
	/** 门头照片 */
	private java.lang.String doorPic;
	/** 直营店ID */
	private java.lang.String directShopId;
	/** 申请/签约日期 */
	private java.util.Date signDate;
	/** 审核状态 0未审核 1已审核 2审核未通过 */
	private java.lang.Integer signState;
	/** 外系统ID */
	private java.lang.String outId;
	/** 注册方式 1自主注册 2代客注册 RegTypeEnum */
	private java.lang.Integer regType;
	/** 来源 0网站 1App 2微信 3wap */
	private java.lang.Integer source;
	
	/**
	 * 距离
	 */
	private Integer distance;
	/**
	 * 营业时间
	 */
	private String startDate;
	/**
	 * 营业的结束时间
	 */
	private String  overDate;

	
	
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
	 * 锁定修理厂1，解锁为2
	 */
	private Integer lockState;
	
	
	
	
	public Integer getLockState() {
		return lockState;
	}

	public void setLockState(Integer lockState) {
		this.lockState = lockState;
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

	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getOverDate() {
		return overDate;
	}

	public void setOverDate(String overDate) {
		this.overDate = overDate;
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
	 * @return: java.lang.String 企业用户名
	 */
	public java.lang.String getUsername() {
		return this.username;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 企业用户名
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 密码
	 */
	public java.lang.String getPassword() {
		return this.password;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 密码
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 公司名称
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 公司名称
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 公司电话
	 */
	public java.lang.String getTelephone() {
		return this.telephone;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 公司电话
	 */
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 省
	 */
	public java.lang.Integer getProvince() {
		return this.province;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 省
	 */
	public void setProvince(java.lang.Integer province) {
		this.province = province;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 市
	 */
	public java.lang.Integer getCity() {
		return this.city;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 市
	 */
	public void setCity(java.lang.Integer city) {
		this.city = city;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 区
	 */
	public java.lang.Integer getArea() {
		return this.area;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 区
	 */
	public void setArea(java.lang.Integer area) {
		this.area = area;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 地址
	 */
	public java.lang.String getAddress() {
		return this.address;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 地址
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 省市区地址(冗余)
	 */
	public java.lang.String getFullAddress() {
		return this.fullAddress;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 省市区地址(冗余)
	 */
	public void setFullAddress(java.lang.String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 联系人
	 */
	public java.lang.String getContacts() {
		return this.contacts;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 联系人
	 */
	public void setContacts(java.lang.String contacts) {
		this.contacts = contacts;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 联系电话
	 */
	public java.lang.String getContactsPhone() {
		return this.contactsPhone;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 联系电话
	 */
	public void setContactsPhone(java.lang.String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 客服电话
	 */
	public java.lang.String getCustomerPhone() {
		return this.customerPhone;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 客服电话
	 */
	public void setCustomerPhone(java.lang.String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 服务时间
	 */
	public java.lang.String getOfficeHours() {
		return this.officeHours;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 服务时间
	 */
	public void setOfficeHours(java.lang.String officeHours) {
		this.officeHours = officeHours;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 账户名
	 */
	public java.lang.String getAccountName() {
		return this.accountName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 账户名
	 */
	public void setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 账户号
	 */
	public java.lang.String getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 账户号
	 */
	public void setAccountNumber(java.lang.String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 位置
	 */
	public java.lang.String getLocation() {
		return this.location;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 位置
	 */
	public void setLocation(java.lang.String location) {
		this.location = location;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 描述
	 */
	public java.lang.String getDescribe() {
		return this.describe;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 描述
	 */
	public void setDescribe(java.lang.String describe) {
		this.describe = describe;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 营业执照
	 */
	public java.lang.String getLicensePic() {
		return this.licensePic;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 营业执照
	 */
	public void setLicensePic(java.lang.String licensePic) {
		this.licensePic = licensePic;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 门头照片
	 */
	public java.lang.String getDoorPic() {
		return this.doorPic;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 门头照片
	 */
	public void setDoorPic(java.lang.String doorPic) {
		this.doorPic = doorPic;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 直营店ID
	 */
	public java.lang.String getDirectShopId() {
		return this.directShopId;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 直营店ID
	 */
	public void setDirectShopId(java.lang.String directShopId) {
		this.directShopId = directShopId;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 申请/签约日期
	 */
	public java.util.Date getSignDate() {
		return this.signDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 申请/签约日期
	 */
	public void setSignDate(java.util.Date signDate) {
		this.signDate = signDate;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 审核状态 0未审核 1已审核 2审核未通过
	 */
	public java.lang.Integer getSignState() {
		return this.signState;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 审核状态 0未审核 1已审核 2审核未通过
	 */
	public void setSignState(java.lang.Integer signState) {
		this.signState = signState;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 外系统ID
	 */
	public java.lang.String getOutId() {
		return this.outId;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 外系统ID
	 */
	public void setOutId(java.lang.String outId) {
		this.outId = outId;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 注册方式 1自主注册 2代客注册 RegTypeEnum
	 */
	public java.lang.Integer getRegType() {
		return this.regType;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 注册方式 1自主注册 2代客注册 RegTypeEnum
	 */
	public void setRegType(java.lang.Integer regType) {
		this.regType = regType;
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
	 * 返回 距离
	 * 
	 * @return 距离
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * 设置 距离
	 * 
	 * @param 距离
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
}
