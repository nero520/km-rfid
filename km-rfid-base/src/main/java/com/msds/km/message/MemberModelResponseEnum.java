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
public enum MemberModelResponseEnum implements DescriptionEnum{
	code_1100(1100,"车型信息错误"),
	code_1101(1101,"当前车牌号码已经添加过"),
	code_1102(1102,"车牌号码信息错误"),
	code_1103(1103,"车架号码错误"),
	code_1104(1104,"参数错误"),
	code_1105(1105,"里程数必填"),
	code_1106(1106,"区域必填"),
	code_1107(1107,"里程数大于0小于等于99999999");
	private int id;
	private String name;
	
	private MemberModelResponseEnum(int id,String name){
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
	public static MemberModelResponseEnum getEnumById(int id){
		MemberModelResponseEnum [] values = MemberModelResponseEnum.values();
		for(MemberModelResponseEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		MemberModelResponseEnum [] values = MemberModelResponseEnum.values();
		for(MemberModelResponseEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
