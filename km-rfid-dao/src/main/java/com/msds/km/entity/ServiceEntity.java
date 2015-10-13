package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>ServiceEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-05-08 17:06:34 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ServiceEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**服务编码*/
	private java.lang.String serviceCode;
	/**服务名称*/
	private java.lang.String serviceName;
	/**服务分类ID*/
	private java.lang.Integer categoryId;
	/**服务分类名称*/
	private java.lang.String categoryName;
	/**服务状态 0下架 1上架*/
	private java.lang.Integer state;
	/**描述*/
	private java.lang.String describe;
	/**操作人*/
	private java.lang.Integer operator;
	
	/**
	 * 市id
	 */
	private Integer cityId;
	/**
	 * 操作人
	 */
	
	private String username;
	
	
   
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
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
	 *@return: java.lang.String  服务编码
	 */
	public java.lang.String getServiceCode(){
		return this.serviceCode;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务编码
	 */
	public void setServiceCode(java.lang.String serviceCode){
		this.serviceCode = serviceCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务名称
	 */
	public java.lang.String getServiceName(){
		return this.serviceName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务名称
	 */
	public void setServiceName(java.lang.String serviceName){
		this.serviceName = serviceName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  服务分类ID
	 */
	public java.lang.Integer getCategoryId(){
		return this.categoryId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  服务分类ID
	 */
	public void setCategoryId(java.lang.Integer categoryId){
		this.categoryId = categoryId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务分类名称
	 */
	public java.lang.String getCategoryName(){
		return this.categoryName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务分类名称
	 */
	public void setCategoryName(java.lang.String categoryName){
		this.categoryName = categoryName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  服务状态 0下架 1上架
	 */
	public java.lang.Integer getState(){
		return this.state;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  服务状态 0下架 1上架
	 */
	public void setState(java.lang.Integer state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	public java.lang.String getDescribe(){
		return this.describe;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setDescribe(java.lang.String describe){
		this.describe = describe;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  操作人
	 */
	public java.lang.Integer getOperator(){
		return this.operator;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  操作人
	 */
	public void setOperator(java.lang.Integer operator){
		this.operator = operator;
	}
}

