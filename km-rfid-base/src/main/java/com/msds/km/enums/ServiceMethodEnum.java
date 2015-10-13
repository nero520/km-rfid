package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 服务方式
 * 
 * @ClassName ServiceMethodEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年6月9日 下午3:10:31
 * 
 */
public enum ServiceMethodEnum implements DescriptionEnum {
	/** 到店 */
	store(1, "到店"),
	/** 上门 */
	door(2, "上门");

	private int id;
	private String name;

	private ServiceMethodEnum(int id, String name) {
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

	public static ServiceMethodEnum getEnumById(int id) {
		ServiceMethodEnum[] values = ServiceMethodEnum.values();
		for (ServiceMethodEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ServiceMethodEnum[] values = ServiceMethodEnum.values();
		for (ServiceMethodEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
