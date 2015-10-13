package com.msds.common;

/**
 * 下拉菜单 数据传输对象
 * 
 * @author LiLong 2014-8-1
 */
public class ComboBox {

	/**
	 * 构造
	 * 
	 * @param id
	 * @param name
	 */
	public ComboBox(Integer id, String text) {
		setId(id);
		setText(text);
	}

	/**
	 * 标识ID
	 */
	private Integer id;

	/**
	 * value值
	 */
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
