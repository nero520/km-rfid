package com.msds.plugin;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;

import com.msds.plugin.entity.PluginConfigEntity;

/**
 * 插件配置信息
 * 
 * @ClassName PluginConfig
 * @Description TODO
 * @author LiLong
 * @date 2014年11月27日 下午5:42:54
 * 
 */
public class PluginConfig extends PluginConfigEntity {

	private static final long serialVersionUID = -8395364995077120932L;

	/** 属性 */
	private Map<String, String> attributes = new HashMap<String, String>();

	/**
	 * 获取属性
	 * 
	 * @return 属性
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * 设置属性
	 * 
	 * @param attributes
	 *            属性
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	/**
	 * 获取属性值
	 * 
	 * @param name
	 *            属性名称
	 * @return 属性值
	 */
	@Transient
	public String getAttribute(String name) {
		if (getAttributes() != null && name != null) {
			return getAttributes().get(name);
		} else {
			return null;
		}
	}

	/**
	 * 设置属性值
	 * 
	 * @param name
	 *            属性名称
	 * @param value
	 *            属性值
	 */
	@Transient
	public void setAttribute(String name, String value) {
		if (getAttributes() != null && name != null) {
			getAttributes().put(name, value);
		}
	}

}