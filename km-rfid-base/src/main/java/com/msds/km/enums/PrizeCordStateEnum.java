package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 兑换券状态
 * 
 * @author lilong
 * @date 2015年08月15日
 */
public enum PrizeCordStateEnum implements DescriptionEnum {
	/**
	 * 未使用
	 */
	wait(1, "未使用"),
	/**
	 * 使用
	 */
	start(2, "使用"),
	/**
	 * 过期
	 */
	end(3, "过期");

	private int id;
	private String name;

	private PrizeCordStateEnum(int id, String name) {
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

	public static PrizeCordStateEnum getEnumById(int id) {
		PrizeCordStateEnum[] values = PrizeCordStateEnum.values();
		for (PrizeCordStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		PrizeCordStateEnum[] values = PrizeCordStateEnum.values();
		for (PrizeCordStateEnum val : values) {
			result.add(val);
		}
		return result;
	}
}
