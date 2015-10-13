package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 时间区间
 * 
 * @ClassName BillTypeEnum
 * @Description 
 * @author lizhe
 * @date 2014年12月3日 下午2:21:46
 * 
 */
public enum BillTypeEnum implements DescriptionEnum {
	band_card(1,"银行卡"),aipay(2,"支付宝"),weixin(3,"微信"),
	;

	private int id;
	private String name;

	private BillTypeEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static BillTypeEnum getEnumById(int id) {
		BillTypeEnum[] values = BillTypeEnum.values();
		for (BillTypeEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		BillTypeEnum[] values = BillTypeEnum.values();
		for (BillTypeEnum val : values) {
			result.add(val);
		}
		return result;
	}
}
