package com.msds.open.api;

/**
 * 用于处理OpenApi返回的失败信息
 * 
 * @ClassName ErpException
 * @Description TODO
 * @author LiLong
 * @date 2014年12月11日 下午3:14:31
 * 
 */
public class OpenApiException extends Exception {

	private static final long serialVersionUID = -3948473572766679716L;

	private String errorCode;

	/**
	 * @param msg
	 */
	public OpenApiException(String msg) {
		super(msg);
	}

	/**
	 * @param errorCode
	 * @param msg
	 */
	public OpenApiException(String errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

}
