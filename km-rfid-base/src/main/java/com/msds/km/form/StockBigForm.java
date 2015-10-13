package com.msds.km.form;

/**
 * ERP接口参数类
 * @author LiJingkun 
 * @date 2015年3月6日
 * @version 1.0
 */
public class StockBigForm{
	
	/** 业务ID */
	private String businessCode;
	/** 请求参数 */
	private Object params;
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
	 * 获取  请求参数
	 * @return  params  请求参数
	 */
	public Object getParams() {
		return params;
	}
	/**
	 * 设置  请求参数
	 * @param  params  请求参数
	 */
	public void setParams(Object params) {
		this.params = params;
	}
	
}
