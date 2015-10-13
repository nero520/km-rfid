package com.msds.km.enums;

import com.msds.enums.DescriptionEnum;

/**
 * 页面配置
 * 
 * @ClassName PublishTypeEnum
 * @Description TODO
 * @author LiLong
 * @date 2015年07月09日 下午3:53:40
 * 
 */
public enum PublishTypeEnum implements DescriptionEnum {
	/** 轮播图 */
	ADS(1, "轮播图"),
	/** 问题 */
	ISSUES(2, "问题"),
	/** 服务 */
	SERVICE(3, "服务");

	private int id;
	private String name;

	private PublishTypeEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
