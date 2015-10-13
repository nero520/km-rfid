package com.msds.km.enums;   

import com.msds.enums.DescriptionEnum;

/**
 * 创建时间：2014-10-8 下午2:25:05 
 * 项目名称：car_zone_base 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public enum IdMapperEnum implements DescriptionEnum {
	product(1,"商品"),order(2,"订单"),brand(3,"配件品牌"),
	model1(4,"汽车品牌"),model2(9,"厂商"),model3(10,"车系"),
	model_detail(5,"车型明细"),
	category1(6,"一级分类"),category2(7,"二级分类"),category3(8,"三级分类"),
	shopIdAccId(11,"电商id与ERP商品Id对应");
	private int id;
	private String name;
	
	private IdMapperEnum(int id,String name){
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
  
