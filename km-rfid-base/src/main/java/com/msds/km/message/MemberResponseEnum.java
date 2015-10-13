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
public enum MemberResponseEnum implements DescriptionEnum {
	/** 您的订单暂无法处理，请联系客服。 */
	code_1400(1400, "请输入正确的中文名。");

	private int id;
	private String name;

	private MemberResponseEnum(int id, String name) {
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
