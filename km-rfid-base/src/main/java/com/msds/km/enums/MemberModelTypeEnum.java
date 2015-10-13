package com.msds.km.enums;   

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
public enum MemberModelTypeEnum implements DescriptionEnum{
	type(1,"默认爱车"),
	notype(0,"非默认爱车");
	private int id;
	private String name;
	
	private MemberModelTypeEnum(int id,String name){
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
	public static MemberModelTypeEnum getEnumById(int id){
		MemberModelTypeEnum [] values = MemberModelTypeEnum.values();
		for(MemberModelTypeEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		MemberModelTypeEnum [] values = MemberModelTypeEnum.values();
		for(MemberModelTypeEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
