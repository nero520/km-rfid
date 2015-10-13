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
public enum RefundStateEnum implements DescriptionEnum {

	/** 待处理 */
	ORDER_ERROR(0, "待处理"),
	/** 已退款 */
	ORDER_QUANBU(1, "已退款");
	
	private int id;
	private String name;

	private RefundStateEnum(int id, String name) {
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

	public static RefundStateEnum getEnumById(int id) {
		RefundStateEnum[] values = RefundStateEnum.values();
		for (RefundStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		RefundStateEnum[] values = RefundStateEnum.values();
		for (RefundStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
