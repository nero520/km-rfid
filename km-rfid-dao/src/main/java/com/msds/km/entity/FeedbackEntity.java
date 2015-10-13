package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
/**
 * 意见反馈
 * <br>
 * <b>功能：</b>FeedbackEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-03-16 10:57:08 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class FeedbackEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**member_id*/
	private java.lang.Integer memberId;
	/**content*/
	private java.lang.String content;

		/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  ID
	 */
	public java.lang.Integer getId(){
		return this.id;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  ID
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  member_id
	 */
	public java.lang.Integer getMemberId(){
		return this.memberId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  member_id
	 */
	public void setMemberId(java.lang.Integer memberId){
		this.memberId = memberId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  content
	 */
	public java.lang.String getContent(){
		return this.content;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  content
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
}

