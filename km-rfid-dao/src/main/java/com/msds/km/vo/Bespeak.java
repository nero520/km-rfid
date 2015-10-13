package com.msds.km.vo;


/**
 * 预约单数据包装类
 * 
 * @ClassName Order
 * @Description TODO
 * @author hebiao
 * @date 2015年4月27日 下午4:01:49
 * 
 */
public class Bespeak extends BaseVo {
	private static final long serialVersionUID = -5692739824088574357L;
	//预约单号
	private String bespeakSn;
	//创建时间
	private String createDate;
	//初步方案
	private String answer;
	//预约时间
	private String bespeakDate;
	//修理厂名称
	private String companyName;
	
	public String getBespeakSn() {
		return bespeakSn;
	}
	public void setBespeakSn(String bespeakSn) {
		this.bespeakSn = bespeakSn;
	}
	public String getCreateDate() {
		return createDate==null?"":createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getAnswer() {
		return answer==null?"":answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
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
	


	
}
