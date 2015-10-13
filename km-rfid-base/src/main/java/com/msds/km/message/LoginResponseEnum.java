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
public enum LoginResponseEnum implements DescriptionEnum{
	code_1000(1000,"手机格式有误"),
	code_1001(1001,"验证码发送过于频繁，请休息一下"),
	code_1002(1002,"手机号不存在，请检查"),
	code_1003(1003,"发送验证码失败，请稍后再试"),
	code_1004(1004,"验证码错误，请重新获取"),
	code_1005(1005,"输入验证码有误"),
	code_1006(1006,"系统繁忙，请稍后再试"),
	code_9999(9999,"用户未登录，请先登录"),
	;
	
	private int id;
	private String name;
	
	private LoginResponseEnum(int id,String name){
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
	public static LoginResponseEnum getEnumById(int id){
		LoginResponseEnum [] values = LoginResponseEnum.values();
		for(LoginResponseEnum en : values){
			if(en.getId() == id){
				return en;
			}
		}
		return null;
	}
	
	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		LoginResponseEnum [] values = LoginResponseEnum.values();
		for(LoginResponseEnum val : values){
			result.add(val);
		}
		return result;
	}
	
}
  
