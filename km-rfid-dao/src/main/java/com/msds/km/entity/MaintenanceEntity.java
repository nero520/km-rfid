package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>MaintenanceEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-10 15:51:20 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MaintenanceEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**保养套餐ID*/
	private java.lang.String projectId;
	/**保养的套餐名称*/
	private java.lang.String projectName;
	/**service_id*/
	private java.lang.Integer serviceId;
	/**model_id*/
	private java.lang.Integer modelId;
	/**行驶里程数*/
	private BigDecimal mileague;
	/**type*/
	private java.lang.Integer type;
	/**更换周期（月）*/
	private java.lang.Integer month;
	/**mofq*/
	private BigDecimal mofq;
	/**基础油类型*/
	private java.lang.String baseOilType;
	/**级别*/
	private java.lang.String grade;
	/**standard*/
	private java.lang.String standard;

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
	 *@return: java.lang.String  保养套餐ID
	 */
	public java.lang.String getProjectId(){
		return this.projectId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保养套餐ID
	 */
	public void setProjectId(java.lang.String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保养的套餐名称
	 */
	public java.lang.String getProjectName(){
		return this.projectName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保养的套餐名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  service_id
	 */
	public java.lang.Integer getServiceId(){
		return this.serviceId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  service_id
	 */
	public void setServiceId(java.lang.Integer serviceId){
		this.serviceId = serviceId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  model_id
	 */
	public java.lang.Integer getModelId(){
		return this.modelId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  model_id
	 */
	public void setModelId(java.lang.Integer modelId){
		this.modelId = modelId;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  行驶里程数
	 */
	public BigDecimal getMileague(){
		return this.mileague;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  行驶里程数
	 */
	public void setMileague(BigDecimal mileague){
		this.mileague = mileague;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  type
	 */
	public java.lang.Integer getType(){
		return this.type;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  type
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  更换周期（月）
	 */
	public java.lang.Integer getMonth(){
		return this.month;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  更换周期（月）
	 */
	public void setMonth(java.lang.Integer month){
		this.month = month;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  mofq
	 */
	public BigDecimal getMofq(){
		return this.mofq;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  mofq
	 */
	public void setMofq(BigDecimal mofq){
		this.mofq = mofq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基础油类型
	 */
	public java.lang.String getBaseOilType(){
		return this.baseOilType;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基础油类型
	 */
	public void setBaseOilType(java.lang.String baseOilType){
		this.baseOilType = baseOilType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  级别
	 */
	public java.lang.String getGrade(){
		return this.grade;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  级别
	 */
	public void setGrade(java.lang.String grade){
		this.grade = grade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  standard
	 */
	public java.lang.String getStandard(){
		return this.standard;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  standard
	 */
	public void setStandard(java.lang.String standard){
		this.standard = standard;
	}
}

