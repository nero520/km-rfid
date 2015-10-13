package com.msds.km.message;

import com.msds.enums.DescriptionEnum;

/**
 * 行驶证图片识别接口返回信息定义
 * 
 * @ClassName OrderResponseEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年4月30日 上午9:42:03
 * 
 */
public enum DrivingLicenseResponseEnum implements DescriptionEnum {
	code_1300(1300, "未识别出行驶证信息"),
	code_1301(1301, "行驶证识别失败，系统内容错误"),
	code_1302(1302, "必须上传要识别的行驶证图片文件");

	private int id;
	private String name;

	private DrivingLicenseResponseEnum(int id, String name) {
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
