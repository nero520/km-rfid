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
public enum SettleStateEnum implements DescriptionEnum {
	wait_settle(1,"未确认"),
	settled(2,"已确认"),
	finish_bill(3,"已结算")
	;

	private int id;
	private String name;

	private SettleStateEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static SettleStateEnum getEnumById(int id) {
		SettleStateEnum[] values = SettleStateEnum.values();
		for (SettleStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		SettleStateEnum[] values = SettleStateEnum.values();
		for (SettleStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
