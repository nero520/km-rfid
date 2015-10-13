package com.msds.km.message;

import com.msds.enums.DescriptionEnum;

/**
 * 订单接口返回信息定义
 * 
 * @ClassName OrderResponseEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年4月30日 上午9:42:03
 * 
 */
public enum OrderResponseEnum implements DescriptionEnum {
	/** 您的订单暂无法处理，请联系客服。 */
	code_1300(1300, "您的订单暂无法处理，请联系客服。"),
	/** 您的订单数据不完整，请完善。 */
	code_1301(1301, "您的订单数据不完整，请完善。"),
	/** 您预约服务时间不正确，请确认。 */
	code_1302(1302, "您预约服务时间不正确，请确认。"),
	/** 您的订单状态不符，请确认。 */
	code_1303(1303, "您的订单状态不符，请确认。"),
	code_1304(1304, "该订单号不存在，请确认。"),
	;

	private int id;
	private String name;

	private OrderResponseEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return name;
	}
}
