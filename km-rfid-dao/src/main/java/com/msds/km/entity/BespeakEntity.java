package com.msds.km.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakEntity<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-05-06 15:57:33 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class BespeakEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String bespeakSn;
	private String problem;
	private String answer;
	private BigDecimal laborcost;
	private BigDecimal totalPrice;
	private Date bespeakDate;
	private Integer companyId;
	private Integer memberId;
	private Integer memberModelId;
	private Integer userId;
	private Integer state;
	private String date;
	
	//修理厂预约单使用
	/** 车牌号 */
	private String license;
	
	private String region;
	
	/** 联系电话 */
	private String phone;
	/** 车型组合名称(品牌车系排量年份) */
	private String modelGroupName;
	/** 购买日期 */
	private Date buyDate;
	/** 上交保养日期 */
	private Date lastServiceDate;
	
	private BigDecimal mileage;  
	private String name;
	private Date startDate;
	private Date endDate;
	
	private Date nowDate;
	
	/** 修理厂名称 */
	private String companyName;
	/** 修理厂地址 */
	private String companyAddress;
	/** 修理厂电话 */
	private String companyTel;
		
	/** 车主联系姓名 */
	private String memberName;	
	private String vin;

	private Boolean isEdit;
	private String processJson;
	
	/** 大于开始日期 */
	private String afterDate;
	/** 小于结束日期 */
	private String beforeDate;
	
	
	public String getProcessJson() {
		return processJson;
	}
	public void setProcessJson(String processJson) {
		this.processJson = processJson;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public BigDecimal getMileage() {
		return mileage;
	}
	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBespeakSn() {
		return bespeakSn;
	}
	public void setBespeakSn(String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public BigDecimal getLaborcost() {
		return laborcost;
	}
	public void setLaborcost(BigDecimal laborcost) {
		this.laborcost = laborcost;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getBespeakDate() {
		return bespeakDate;
	}
	public void setBespeakDate(Date bespeakDate) {
		this.bespeakDate = bespeakDate;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getMemberModelId() {
		return memberModelId;
	}
	public void setMemberModelId(Integer memberModelId) {
		this.memberModelId = memberModelId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	/**
	 * @return the 购买日期
	 */
	public Date getBuyDate() {
		return buyDate;
	}
	/**
	 * @param 购买日期 the buyDate to set
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	/**
	 * @return the 上交保养日期
	 */
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	/**
	 * @param 上交保养日期 the lastServiceDate to set
	 */
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	/**
	 * @return the 大于开始日期
	 */
	public String getAfterDate() {
		return afterDate;
	}
	/**
	 * @param 大于开始日期 the afterDate to set
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
