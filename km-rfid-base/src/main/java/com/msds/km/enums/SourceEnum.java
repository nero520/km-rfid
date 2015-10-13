package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 来源渠道
 * 
 * @ClassName SourceEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年4月28日 下午5:17:48
 * 
 */
public enum SourceEnum implements DescriptionEnum {
	/** 通用 */
	common(1, "通用"),
	/** 微信 */
	weixin(2, "微信"),
	/** web */
	web(3, "web"),
	/** wap */
	wap(4, "wap"),
	/** ios */
	ios(5, "ios"),
	/** android */
	android(6, "android");

	private int id;
	private String name;

	private SourceEnum(int id, String name) {
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

	public static SourceEnum getEnumById(int id) {
		SourceEnum[] values = SourceEnum.values();
		for (SourceEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		SourceEnum[] values = SourceEnum.values();
		for (SourceEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
