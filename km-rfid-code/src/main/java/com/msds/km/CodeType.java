package com.msds.km;

/**
 * 单号类型前缀
 * 
 * @ClassName CodeType
 * @Description 用于约定单号类型前缀
 * @author LiLong
 * @date 2014年12月8日 上午11:38:43
 * 
 */
public class CodeType {

	/** 订单编号前缀 */
	public static final String ORDER_SN_PREFIX = "FWDD";
	/** 付款单编号前缀 */
	public static final String PAYMENT_SN_PREFIX = "FK";
	/** 退款单编号前缀 */
	public static final String REFUND_SN_PREFIX = "TKD";
	/** 退货单编号前缀 */
	public static final String RETURN_P_SN_PREFIX = "THD";
	/**入库单编号前缀 */
	public static final String STOCKIN_SN_PREFIX = "RKD";
	/** customerId前缀 */
	public static final String CUSTOMER_ID_PREFIX = "19999";
	
	/** 预约单前缀 */
	public static final String BESPEAK_ID_PREFIX = "YYD";
	
	/**
	 * 服务与车型关系唯一ID
	 */
	public static final String SERVICE_MODEL_CODE_PREFIX = "SM";
	
	/**
	 * RFID前缀
	 */
	public static final String RFID_PREFIX = "FF";

}
