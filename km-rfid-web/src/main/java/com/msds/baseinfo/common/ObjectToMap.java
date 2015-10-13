package com.msds.baseinfo.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 提供序列化 对象为map 主要用反射 取出值 和其 类型 做自动类型转换
 * 
 */
public class ObjectToMap {

	@SuppressWarnings("unchecked")
	public static Map toMap(Object o) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Map map = new HashMap();
		if (o != null) {
			// 获得当前对象的属性
			Field[] fields = o.getClass().getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				String fieldName = f.getName();
				// ## 获得类型
				String type = f.getType().getSimpleName();
				// ## 通过get方法 获取值
				String str = "get" + fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1, fieldName.length());
				Method method = o.getClass().getMethod(str, new Class[] {});
				Object value = method.invoke(o, new Object[] {});
				// 如果值 不为空 将类型 转换成其对应的类型 放入map 中 目前 支持 integer data timestamp
				// boolean long float ....
				if (value != null) {
					Object c = getTypeClass(type, value);
					map.put(fieldName, c);
				}
			}
		}
		return map;
	}

	private static Object getTypeClass(String fileType, Object preValue) {
		Object value = null;
		if ("Timestamp".equals(fileType)) {
			if (preValue instanceof String) {
				value = Timestamp.valueOf(preValue.toString());
			}
		} else if ("Date".equals(fileType)) {
			value = preValue;
			if (preValue instanceof String) {
				// Date.valueOf(preValue.toString());
			}
		} else if ("Double".equals(fileType)) {
			if (preValue instanceof Double) {
				value = (Double) preValue;
			}
		} else if ("Float".equals(fileType)) {
			if (preValue instanceof Float) {
				value = (Float) preValue;
			}
		} else if ("Integer".equals(fileType)) {
			if (preValue instanceof Integer) {
				value = (Integer) preValue;
			}
		} else if ("Long".equals(fileType)) {
			if (preValue instanceof Long) {
				value = (Long) preValue;
			}
		} else if ("Short".equals(fileType)) {
			if (preValue instanceof Short) {
				value = (Short) preValue;
			}
		} else if ("Byte".equals(fileType)) {
			if (preValue instanceof Byte) {
				value = (Byte) preValue;
			}
		} else if ("Character".equals(fileType)) {
			if (preValue instanceof Character) {
				value = (Character) preValue;
			}
		} else if ("Boolean".equals(fileType)) {
			if (preValue instanceof Boolean) {
				value = (Boolean) preValue;
			}
		} else {
			value = preValue;
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public static Map toPageMap(Object o, Page page) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Map map = new HashMap();
		map.put("startRow", page.getStartRow());
		map.put("endRow", page.getEndRow());
		if (o != null) {
			// 获得当前对象的属性
			Field[] fields = o.getClass().getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				String fieldName = f.getName();
				String type = f.getType().getSimpleName();
				String str = "get" + fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1, fieldName.length());
				Method method = o.getClass().getMethod(str, new Class[] {});
				Object value = method.invoke(o, new Object[] {});
				if (value != null) {
					Object c = getTypeClass(type, value);
					map.put(fieldName, c);
				}
			}
		}
		return map;

	}
}
