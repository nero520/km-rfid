package com.msds.km.vo;

public class VolumeYear extends BaseVo {

	private static final long serialVersionUID = -6279902076229557790L;

	// 排量
	private String id;
	// 排量+年的组合
	private String name;
	
	//年份
	private String year;

	
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
