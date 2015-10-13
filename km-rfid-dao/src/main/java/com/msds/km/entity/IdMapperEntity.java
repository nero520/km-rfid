package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>IdMapperEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-12-02 17:25:53 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class IdMapperEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**本地Id*/
	private java.lang.Integer localId;
	/**导入康众库Id*/
	private java.lang.String carzoneId;
	/**类型 1商品 2订单 3配件品牌 4汽车品牌厂商车系 5车型明细 6分类*/
	private java.lang.Integer idType;

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
	 *@return: java.lang.Integer  本地Id
	 */
	public java.lang.Integer getLocalId(){
		return this.localId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  本地Id
	 */
	public void setLocalId(java.lang.Integer localId){
		this.localId = localId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导入康众库Id
	 */
	public java.lang.String getCarzoneId(){
		return this.carzoneId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入康众库Id
	 */
	public void setCarzoneId(java.lang.String carzoneId){
		this.carzoneId = carzoneId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  类型 1商品 2订单 3配件品牌 4汽车品牌厂商车系 5车型明细 6分类
	 */
	public java.lang.Integer getIdType(){
		return this.idType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  类型 1商品 2订单 3配件品牌 4汽车品牌厂商车系 5车型明细 6分类
	 */
	public void setIdType(java.lang.Integer idType){
		this.idType = idType;
	}
}

