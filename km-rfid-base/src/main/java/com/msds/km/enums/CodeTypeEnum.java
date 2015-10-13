package com.msds.km.enums;   

import com.msds.enums.DescriptionEnum;

/**
 * 创建时间：2014-10-8 下午2:25:05 
 * 项目名称：car_zone_base 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public enum CodeTypeEnum implements DescriptionEnum {
	order_code(1,"订单编号"),
	refund_code(2,"退款单编号"),
	stockout_code(3,"出库单编号"),
	stpckin_code(4,"入库单编号"),
	PAYMENT_CODE(5,"付款单"),
	return_product(6,"退货单编号"),
	cutomerId(7,"用户表customerId"),
	settle_code(8,"DZD","对账单号"),
	bill_code(9,"JSD","结算单号"),
	bespeak_code(10,"YYD","结算单号"),
	service_model_code(11,"SM","服务车型单号"),
	rfid_code(12,"FF","RFID号"),
	;
	
	private int id;
	private String name;
	private String prefix;
	
	private CodeTypeEnum(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	private CodeTypeEnum(int id,String prefix,String name){
		this.id = id;
		this.name = name;
		this.prefix = prefix;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * 获取  prefix
	 * @return  prefix  prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	
}
  
