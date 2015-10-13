package com.msds.util;



import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * 处理数据对象与实体之间的转换
 * 
 * @author LiLong 2014-8-29
 */
public class BeanUtil {

	/**
	 * 对象之间拷贝
	 * 
	 * @param source原始
	 * @param target目标
	 * @param ignoreProperties
	 */
	public static void copyProperties(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

	/**
	 * 对象之间拷贝
	 * 
	 * @param source原始
	 * @param target目标
	 * @param ignoreProperties
	 *            忽略字段
	 */
	public static void copyProperties(Object source, Object target,
			String... ignoreProperties) {
		BeanUtils.copyProperties(source, target, ignoreProperties);
	}

	/**
	 * 对象List之间拷贝
	 * 
	 * @param source原始
	 * @param target目标
	 * @param targetClass
	 *            目标类
	 * 
	 */
	public static void copyListProperties(Object sourcelist, Object targetList,
			Class targetClass) {
		for (Object source : (List) sourcelist) {
			Object target = null;
			try {
				target = targetClass.newInstance();
				BeanUtils.copyProperties(source, target);
				((List) targetList).add(target);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 对象List之间拷贝
	 * 
	 * @param source
	 * @param target
	 * @param targetClass
	 *            目标类
	 * @param ignoreProperties
	 *            忽略字段
	 */
	public static void copyListProperties(Object sourcelist, Object targetList,
			Class targetClass, String... ignoreProperties) {
		for (Object source : (List) sourcelist) {
			Object target = null;
			try {
				target = targetClass.newInstance();
				BeanUtils.copyProperties(source, target, ignoreProperties);
				((List) targetList).add(target);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
