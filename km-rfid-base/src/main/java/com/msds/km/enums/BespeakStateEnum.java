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
public enum BespeakStateEnum implements DescriptionEnum {

	ok(1, "已确认");

	private int id;
	private String name;

	private BespeakStateEnum(int id, String name) {
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

	public static BespeakStateEnum getEnumById(int id) {
		BespeakStateEnum[] values = BespeakStateEnum.values();
		for (BespeakStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		BespeakStateEnum[] values = BespeakStateEnum.values();
		for (BespeakStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
