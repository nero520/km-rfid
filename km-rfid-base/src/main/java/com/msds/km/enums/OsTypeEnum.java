package com.msds.km.enums;   

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 来源
 * 创建时间：2014-9-25 上午11:06:17 
 * 项目名称：car_zone_base 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public enum OsTypeEnum implements DescriptionEnum{
	iphone(1,"iphone"),andriod(2,"andriod");
	
	private int id;
	private String name;
	
	private OsTypeEnum(int id,String name){
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
	public static OsTypeEnum getEnumById(int id){
		OsTypeEnum [] values = OsTypeEnum.values();
		for(OsTypeEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		OsTypeEnum [] values = OsTypeEnum.values();
		for(OsTypeEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
