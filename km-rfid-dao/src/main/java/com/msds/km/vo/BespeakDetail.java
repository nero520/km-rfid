package com.msds.km.vo;




/**
 * 预约单详细信息数据包装类
 * @author hebiao
 * @date 2015年8月6日
 * @version 1.0
 */
public class BespeakDetail extends BaseVo {
	private static final long serialVersionUID = 1L;
	
	/**预约单号 */
	private String bespeakSn;
//	/**状态名称 */
//	private String stateName;
	/** 车主问题描述*/
	private String problem;
	/** 顾问建议方案说明 */
	private String answer;
//	/** 工时费 */
//	private String laborcost;
//	/** 总价 */
//	private String totalPrice;
	
	/** 预约时间 */
	private String bespeakDate;
	/** 修理厂名称 */
	private String companyName;
	/** 修理厂地址 */
	private String companyAddress;
	/** 修理厂电话 */
	private String companyTel;
		
	/** 车主联系电话 */
	private String phone;
	/** 车主联系姓名 */
	private String memberName;
	
	/** 车型组合名称(品牌车系排量年份) */
	private String modelGroupName;
	private String vin;
	/** 当前里程数 */
	private String mileage;
//	/** 车牌号 */
	private String license;
	
	public String getBespeakSn() {
		return bespeakSn;
	}
	public void setBespeakSn(String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}
//	public String getStateName() {
//		return stateName;
//	}
//	public void setStateName(String stateName) {
//		this.stateName = stateName;
//	}
	public String getProblem() {
		return problem==null?"":problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer==null?"":answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
//	public String getLaborcost() {
//		return laborcost;
//	}
//	public void setLaborcost(String laborcost) {
//		this.laborcost = laborcost;
//	}
//	public String getTotalPrice() {
//		return totalPrice;
//	}
//	public void setTotalPrice(String totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	public String getBespeakDate() {
		return bespeakDate==null?"":bespeakDate;
	}
	public void setBespeakDate(String bespeakDate) {
		this.bespeakDate = bespeakDate;
	}
	public String getCompanyName() {
		return companyName==null?"":companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress==null?"":companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyTel() {
		return companyTel==null?"":companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getPhone() {
		return phone==null?"":phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemberName() {
		return memberName==null?"":memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getModelGroupName() {
		return modelGroupName==null?"":modelGroupName;
	}
	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	public String getVin() {
		return vin==null?"":vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMileage() {
		return mileage==null?"":mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getLicense() {
		return license==null?"":license;
	}
	public void setLicense(String license) {
		this.license = license;
	}


	
	
}
