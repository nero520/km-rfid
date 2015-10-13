package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>UpkeepProjectEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-10 15:51:18 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class UpkeepProjectEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**保养项目ID*/
	private java.lang.String projectId;
	/**服务项目*/
	private java.lang.String projectName;
	/** 0 表示检查 1 表示更换 2 表示检查和更换*/
	private java.lang.Integer type;

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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保养项目ID
	 */
	public java.lang.String getProjectId(){
		return this.projectId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保养项目ID
	 */
	public void setProjectId(java.lang.String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务项目
	 */
	public java.lang.String getProjectName(){
		return this.projectName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务项目
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer   0 表示检查 1 表示更换 2 表示检查和更换
	 */
	public java.lang.Integer getType(){
		return this.type;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer   0 表示检查 1 表示更换 2 表示检查和更换
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
}

