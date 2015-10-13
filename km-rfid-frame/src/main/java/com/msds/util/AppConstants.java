package com.msds.util;



public class AppConstants {
	

	
	private String smsUrl;
	
	private String smsContent;
	

	public AppConstants(){
		
	}

	
	
	public String getSmsUrl() {
		return smsUrl;
	}



	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}



	public String getSmsContent() {
		return smsContent;
	}



	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}



	/**
	 * 调用时消耗的时间预警阈值
	 */
	public static final Integer SPEND_TIME_THRESHOLD = 30000;

	
}
