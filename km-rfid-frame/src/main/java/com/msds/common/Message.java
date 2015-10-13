package com.msds.common;

import java.io.Serializable;

/**
 * 消息,用于异步请款消息返回
 * 
 * @ClassName Message
 * @Description TODO
 * @author LiLong
 * @date 2014年11月21日 下午3:18:13
 * 
 */
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7289310002935043203L;

	/**
	 * 成功失败
	 */
	private boolean type;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 初始化一个新创建的 Message 对象，使其表示一个空消息。
	 */
	public Message() {

	}

	/**
	 * 初始化一个新创建的 Message 对象
	 * 
	 * @param type
	 *            类型
	 * @param content
	 *            内容
	 */
	public Message(boolean type, String content) {
		this.type = type;
		this.content = content;
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	public boolean getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(boolean type) {
		this.type = type;
	}

	/**
	 * 获取内容
	 * 
	 * @return 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 * 
	 * @param content
	 *            内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

}