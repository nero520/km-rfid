package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 时间区间
 * 
 * @ClassName SettleStateEnum
 * @Description 结算单状态
 * @author lizhe
 * @date 2014年12月3日 下午2:21:46
 * 
 */
public enum BillStateEnum implements DescriptionEnum {
	finish_bill(1,"已结算")
	;

	private int id;
	private String name;

	private BillStateEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static BillStateEnum getEnumById(int id) {
		BillStateEnum[] values = BillStateEnum.values();
		for (BillStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		BillStateEnum[] values = BillStateEnum.values();
		for (BillStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
