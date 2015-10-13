package com.msds.km.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>ModelEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class ModelEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**车型名称*/
	private java.lang.String name;
	/**上级ID*/
	private java.lang.Integer pid;
	/**等级*/
	private java.lang.Integer level;
	/**首字母*/
	private java.lang.String firstLetter;
	/**品牌logo*/
	private java.lang.String logo;
	/**英文名*/
	private java.lang.String ename;
	//品牌名称
	private String brandName;
	//汽车厂商
	private String shopName;
		
	
	/**
	 * 是否显示：1显示；0不显示
	 */
	private Integer is_show;
	
	
    /**
     * 子列表
     */
	private List<ModelEntity> childrenList;
	
	//查询使用
	@JsonIgnore
	private List<Integer> levelList;
		
	private Boolean isLeaf = true;
		
	private Boolean expanded = true;
		
		
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<Integer> getLevelList() {
		return levelList;
	}
	public void setLevelList(List<Integer> levelList) {
		this.levelList = levelList;
	}
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public Boolean getExpanded() {
		return expanded;
	}
	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	public List<ModelEntity> getChildrenList() {
		return childrenList;
	}
	public void setChildrenList(List<ModelEntity> childrenList) {
		this.childrenList = childrenList;
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
	 *@return: java.lang.String  车型名称
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  上级ID
	 */
	public java.lang.Integer getPid(){
		return this.pid;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  上级ID
	 */
	public void setPid(java.lang.Integer pid){
		this.pid = pid;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  首字母
	 */
	public java.lang.String getFirstLetter(){
		return this.firstLetter;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  首字母
	 */
	public void setFirstLetter(java.lang.String firstLetter){
		this.firstLetter = firstLetter;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品牌logo
	 */
	public java.lang.String getLogo(){
		return this.logo;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品牌logo
	 */
	public void setLogo(java.lang.String logo){
		this.logo = logo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  英文名
	 */
	public java.lang.String getEname(){
		return this.ename;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英文名
	 */
	public void setEname(java.lang.String ename){
		this.ename = ename;
	}
	public Integer getIs_show() {
		return is_show;
	}
	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}
	
	
}

