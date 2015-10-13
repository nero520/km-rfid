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
public enum CompanyResponseEnum implements DescriptionEnum {
	companyRespnseEnum_1400(1400, "用户名不能为空"),
	companyRespnseEnum_1401(1401, "密码不能为空"),
	companyRespnseEnum_1402(1402, "该用户不存在"),
	companyRespnseEnum_1403(1403, "用户名或密码错误"),
	companyRespnseEnum_1404(1404, "用户被锁定"),
//	companyRespnseEnum_1404(1404, "请输入正确的中文名。"),
	;

	private int id;
	private String name;

	private CompanyResponseEnum(int id, String name) {
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
