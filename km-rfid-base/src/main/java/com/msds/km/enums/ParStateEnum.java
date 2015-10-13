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
public enum ParStateEnum implements DescriptionEnum {
	
	
	/** 等待配送 */
	ORDER_ERROR(1, "等待配送"),
	/** 配送中 */
	ORDER_QUANBU(2, "配送中"),
	/** 配送完成 */
	ORDER_WAIT_PAY(3, "配送完成"),
	/** 待确认 */
	ORDER_WAIT_CONFIRM(4, "已退货");


	private int id;
	private String name;

	private ParStateEnum(int id, String name) {
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

	public static ParStateEnum getEnumById(int id) {
		ParStateEnum[] values = ParStateEnum.values();
		for (ParStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ParStateEnum[] values = ParStateEnum.values();
		for (ParStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
