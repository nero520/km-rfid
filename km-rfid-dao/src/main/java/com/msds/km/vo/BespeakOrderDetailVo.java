package com.msds.km.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.msds.base.entity.BaseEntity;


public class BespeakOrderDetailVo extends BaseEntity {
	
	private static final long serialVersionUID = 3733499953732441150L;

	private String bespeakSn;
	
	private Integer state;
	
	private String problem;
	
	private String answer;
	
	private BigDecimal laborcost;
	
	private BigDecimal totalPrice;
	
	private Date bespeakDate;
	
	private String name;
	
	private String fullAddress;
	
	private String telephone;
	
	private String memberPhone;
	
	private String membername;
	
	private String memberfullAddress;
	
	private String modelGroupName;
	
	private Date buyDate;
	
	private BigDecimal mileage;
	
	private Date lastServiceDate;
	
	public String getBespeakSn() {
		return bespeakSn;
	}

	public void setBespeakSn(String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberfullAddress() {
		return memberfullAddress;
	}

	public void setMemberfullAddress(String memberfullAddress) {
		this.memberfullAddress = memberfullAddress;
	}

	public String getModelGroupName() {
		return modelGroupName;
	}

	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getMileage() {
		return mileage;
	}

	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}

	public Date getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	
	
	
	
}
