package com.msds.km.enums;

import java.util.ArrayList;
import java.util.List;

import com.msds.enums.DescriptionEnum;

/**
 * 
 * ClassName: LockStateEnum 
 * @Description: 修理厂用户锁定状态
 * @author xiaoxiong
 * @date 2015-8-17
 */
public enum LockStateEnum implements DescriptionEnum {
	
	lock(1,"锁定"),
	unlock(2,"解锁")
	;

	private int id;
	private String name;

	private LockStateEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static LockStateEnum getEnumById(int id) {
		LockStateEnum[] values = LockStateEnum.values();
		for (LockStateEnum en : values) {
			if (en.getId() == id) {
				return en;
			}
		}
		return null;
	}

	public static List<DescriptionEnum> getValues() {
		List<DescriptionEnum> result = new ArrayList<DescriptionEnum>();
		LockStateEnum[] values = LockStateEnum.values();
		for (LockStateEnum val : values) {
			result.add(val);
		}
		return result;
	}

}
