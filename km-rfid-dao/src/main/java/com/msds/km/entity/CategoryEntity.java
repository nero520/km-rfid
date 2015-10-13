package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CategoryEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 16:11:46 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CategoryEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**分类名称*/
	private java.lang.String name;
	/**上级分类ID*/
	private java.lang.Integer parentId;
	/**等级*/
	private java.lang.Integer level;
	/**排序*/
	private java.lang.Integer orders;
	/**1（省直辖市）2（地级市）3（区县）4（乡镇）*/
	private java.lang.Integer operator;

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
	 *@return: java.lang.String  分类名称
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  上级分类ID
	 */
	public java.lang.Integer getParentId(){
		return this.parentId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  上级分类ID
	 */
	public void setParentId(java.lang.Integer parentId){
		this.parentId = parentId;
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
	 *@return: java.lang.Integer  排序
	 */
	public java.lang.Integer getOrders(){
		return this.orders;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setOrders(java.lang.Integer orders){
		this.orders = orders;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  1（省直辖市）2（地级市）3（区县）4（乡镇）
	 */
	public java.lang.Integer getOperator(){
		return this.operator;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  1（省直辖市）2（地级市）3（区县）4（乡镇）
	 */
	public void setOperator(java.lang.Integer operator){
		this.operator = operator;
	}
}

