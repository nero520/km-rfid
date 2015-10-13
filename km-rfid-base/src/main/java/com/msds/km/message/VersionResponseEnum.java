package com.msds.km.message;   

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 来源
 * 创建时间：2014-9-25 上午11:06:17 
 * 项目名称：kmo2o
 * @author xiaoxiong  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public enum VersionResponseEnum implements DescriptionEnum{
	code_1800(1800,"操作失败"),
	code_1801(1801,"未找到当前版本信息");
	
	private int id;
	private String name;
	
	private VersionResponseEnum(int id,String name){
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
	public static VersionResponseEnum getEnumById(int id){
		VersionResponseEnum [] values = VersionResponseEnum.values();
		for(VersionResponseEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		VersionResponseEnum [] values = VersionResponseEnum.values();
		for(VersionResponseEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
