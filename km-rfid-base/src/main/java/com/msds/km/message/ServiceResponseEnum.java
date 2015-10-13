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
public enum ServiceResponseEnum implements DescriptionEnum{
	code_1200(1200,"未登录"),
	code_1201(1201,"请先添加一辆您的爱车");
	
	private int id;
	private String name;
	
	private ServiceResponseEnum(int id,String name){
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
	public static ServiceResponseEnum getEnumById(int id){
		ServiceResponseEnum [] values = ServiceResponseEnum.values();
		for(ServiceResponseEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		ServiceResponseEnum [] values = ServiceResponseEnum.values();
		for(ServiceResponseEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
