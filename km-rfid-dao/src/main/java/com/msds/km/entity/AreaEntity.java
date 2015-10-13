package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>AreaEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class AreaEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**区域排序*/
	private java.lang.Integer orders;
	/**区域全称*/
	private java.lang.Object fullName;
	/**名称*/
	private java.lang.String name;
	/**树*/
	private java.lang.String treePath;
	/**父ID*/
	private java.lang.Integer parent;
	/**父区域代码*/
	private java.lang.Integer parentAreaCode;
	/**区域代码*/
	private java.lang.Integer areaCode;
	/**等级*/
	private java.lang.Integer level;
	/**1（省直辖市）2（地级市）3（区县）4（乡镇）*/
	private java.lang.Integer regionType;

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
	 *@return: java.lang.Integer  区域排序
	 */
	public java.lang.Integer getOrders(){
		return this.orders;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  区域排序
	 */
	public void setOrders(java.lang.Integer orders){
		this.orders = orders;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  区域全称
	 */
	public java.lang.Object getFullName(){
		return this.fullName;
	}
	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  区域全称
	 */
	public void setFullName(java.lang.Object fullName){
		this.fullName = fullName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  树
	 */
	public java.lang.String getTreePath(){
		return this.treePath;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  树
	 */
	public void setTreePath(java.lang.String treePath){
		this.treePath = treePath;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  父ID
	 */
	public java.lang.Integer getParent(){
		return this.parent;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  父ID
	 */
	public void setParent(java.lang.Integer parent){
		this.parent = parent;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  父区域代码
	 */
	public java.lang.Integer getParentAreaCode(){
		return this.parentAreaCode;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  父区域代码
	 */
	public void setParentAreaCode(java.lang.Integer parentAreaCode){
		this.parentAreaCode = parentAreaCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  区域代码
	 */
	public java.lang.Integer getAreaCode(){
		return this.areaCode;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  区域代码
	 */
	public void setAreaCode(java.lang.Integer areaCode){
		this.areaCode = areaCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  等级
	 */
	public java.lang.Integer getLevel(){
		return this.level;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  等级
	 */
	public void setLevel(java.lang.Integer level){
		this.level = level;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  1（省直辖市）2（地级市）3（区县）4（乡镇）
	 */
	public java.lang.Integer getRegionType(){
		return this.regionType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  1（省直辖市）2（地级市）3（区县）4（乡镇）
	 */
	public void setRegionType(java.lang.Integer regionType){
		this.regionType = regionType;
	}
}

