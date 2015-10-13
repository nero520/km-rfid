package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 活动状态
 * 
 * @author lilong
 * @date 2015年08月15日
 */
public enum ActivityStateEnum implements DescriptionEnum {
	/**
	 * 未开始
	 */
	wait(1, "未开始"),
	/**
	 * 开始
	 */
	start(2, "开始"),
	/**
	 * 结束
	 */
	end(3, "结束"),
	/**
	 * 关闭
	 */
	closed(4, "关闭");

	private int id;
	private String name;

	private ActivityStateEnum(int id, String name) {
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

	public static ActivityStateEnum getEnumById(int id) {
		ActivityStateEnum[] values = ActivityStateEnum.values();
		for (ActivityStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ActivityStateEnum[] values = ActivityStateEnum.values();
		for (ActivityStateEnum val : values) {
			result.add(val);
		}
		return result;
	}
}
