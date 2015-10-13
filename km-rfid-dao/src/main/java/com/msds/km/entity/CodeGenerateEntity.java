package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>CodeGenerateEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class CodeGenerateEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**1订单编号 2退款单编号*/
	private java.lang.Integer codeType;
	/**前缀*/
	private java.lang.String prefix;
	/**后缀*/
	private java.lang.String suffix;
	/**日期*/
	private java.lang.String dateStr;
	/**编号*/
	private java.lang.String code;

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
	 *@return: java.lang.Integer  1订单编号 2退款单编号
	 */
	public java.lang.Integer getCodeType(){
		return this.codeType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  1订单编号 2退款单编号
	 */
	public void setCodeType(java.lang.Integer codeType){
		this.codeType = codeType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  前缀
	 */
	public java.lang.String getPrefix(){
		return this.prefix;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  前缀
	 */
	public void setPrefix(java.lang.String prefix){
		this.prefix = prefix;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  后缀
	 */
	public java.lang.String getSuffix(){
		return this.suffix;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  后缀
	 */
	public void setSuffix(java.lang.String suffix){
		this.suffix = suffix;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  日期
	 */
	public java.lang.String getDateStr(){
		return this.dateStr;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  日期
	 */
	public void setDateStr(java.lang.String dateStr){
		this.dateStr = dateStr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编号
	 */
	public java.lang.String getCode(){
		return this.code;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编号
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
}

