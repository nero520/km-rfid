package com.msds.util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * XML转换工具类
 * 
 * @ClassName XMLUtils
 * @Description TODO
 * @author LiLong
 * @date 2015年06月25日 下午13:17:27
 * 
 */
public final class XMLUtils {

	/** XmlMapper */
	private static XmlMapper mapper = new XmlMapper();

	/**
	 * 不可实例化
	 */
	private XMLUtils() {
	}

	/**
	 * 将对象转换为xml字符串
	 * 
	 * @param value
	 *            对象
	 * @return xml字符串
	 */
	public static String toXml(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将xml字符串转换为对象
	 * 
	 * @param xml
	 *            xml字符串
	 * @param valueType
	 *            对象类型
	 * @return 对象
	 */
	public static <T> T toObject(String xml, Class<T> valueType) {
		Assert.hasText(xml);
		Assert.notNull(valueType);
		try {
			return mapper.readValue(xml, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将xml字符串转换为对象
	 * 
	 * @param xml
	 *            xml字符串
	 * @param typeReference
	 *            对象类型
	 * @return 对象
	 */
	public static <T> T toObject(String xml, TypeReference<?> typeReference) {
		Assert.hasText(xml);
		Assert.notNull(typeReference);
		try {
			return mapper.readValue(xml, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将xml字符串转换为List对象
	 * 
	 * @param xml
	 *            xml字符串
	 * @param clazz
	 *            对象类型
	 * @return 对象List
	 */
	public static <T> List<T> toObjectList(String xml, Class<T> clazz) {
		Assert.hasText(xml);
		Assert.notNull(clazz);
		try {
			return mapper.readValue(xml, new TypeReference<List<T>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将xml字符串转换为对象
	 * 
	 * @param xml
	 *            xml字符串
	 * @param javaType
	 *            对象类型
	 * @return 对象
	 */
	public static <T> T toObject(String xml, JavaType javaType) {
		Assert.hasText(xml);
		Assert.notNull(javaType);
		try {
			return mapper.readValue(xml, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将对象转换为xml流
	 * 
	 * @param writer
	 *            writer
	 * @param value
	 *            对象
	 */
	public static void writeValue(Writer writer, Object value) {
		try {
			mapper.writeValue(writer, value);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}