package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 订单状态
 * 
 * @ClassName OrderStateEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年4月28日 下午4:42:32
 * 
 */
public enum OrderStateEnum implements DescriptionEnum {

	/** 异常订单 */
	ORDER_ERROR(99, "异常订单"),
	/** 待付款 */
	/*ORDER_QUANBU(0, "全部"),*/
	/** 待付款 */
	ORDER_WAIT_PAY(1, "待付款"),
	/** 待确认 */
	ORDER_WAIT_CONFIRM(2, "待确认"),
	/** 待服务 */
	ORDER_WAIT_SERVE(3, "待服务 "),
	/** 已经完成 */
	ORDER_OVER(4, "已完成"),
	/** 服务确认 */
	ORDER_CONFIRM(5, "服务确认"),

    /** 已取消 */
	ORDER_CANCEL(11, "已取消"),
	/** 退款中 */
	ORDER_REFUND_ING(12, "退款中"),
	/** 退款完成 */
	ORDER_REFUND_OVER(13, "已退款");

	private int id;
	private String name;

	private OrderStateEnum(int id, String name) {
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

	public static OrderStateEnum getEnumById(int id) {
		OrderStateEnum[] values = OrderStateEnum.values();
		for (OrderStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		OrderStateEnum[] values = OrderStateEnum.values();
		for (OrderStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
