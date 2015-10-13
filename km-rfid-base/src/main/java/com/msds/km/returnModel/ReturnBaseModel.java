package com.msds.km.returnModel;

/**
 * 通用响应头
 * 
 * @ClassName ReturnBaseModel
 * @Description TODO
 * @author LiLong
 * @date 2014年12月10日 下午3:09:49
 * 
 */
public class ReturnBaseModel {

	/** 业务ID */
	private String businessCode;
	/** 响应结果码 */
	private String result;
	/** 响应备注 */
	private String note;
	/**
	 * 获取  业务ID
	 * @return  businessCode  业务ID
	 */
	public String getBusinessCode() {
		return businessCode;
	}
	/**
	 * 设置  业务ID
	 * @param  businessCode  业务ID
	 */
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	/**
	 * 获取  响应结果码
	 * @return  result  响应结果码
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置  响应结果码
	 * @param  result  响应结果码
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取  响应备注
	 * @return  note  响应备注
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置  响应备注
	 * @param  note  响应备注
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
