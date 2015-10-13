package com.msds.km.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 
 * <br>
 * <b>功能：</b>DirectShopEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class DirectShopEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**省*/
	private java.lang.String province;
	/**市*/
	private java.lang.String city;
	/**区*/
	private java.lang.String area;
	/**直营店名称*/
	private java.lang.String name;
	/**排序*/
	private java.lang.Integer sort;
	/**关联direct_shop_id*/
	private java.lang.String parentId;
	/**康众提供的字符串Id*/
	private java.lang.String directShopId;
	/**1总公司、4：分公司、7：门店、10：普通部门、20：仓库*/
	private java.lang.Integer type;
	/**负责人*/
	private java.lang.Integer employeeId;
	/**成立时间*/
	private java.util.Date buildDate;
	/**部门地点*/
	private java.lang.String address;
	/**联系电话*/
	private java.lang.String phone;
	/**传真号码*/
	private java.lang.String fax;
	/**内部调拨系数*/
	private BigDecimal innerCoefficient;
	/**内部调拨加急系数*/
	private BigDecimal allocateCoefficient;
	/**内部调拨核算系数*/
	private BigDecimal realCoefficient;
	/**数据字典 store_level   1:1级  2:2级  3:3级*/
	private java.lang.Integer storeLevel;
	/**仅门店有，值为数字*/
	private java.lang.String storeSn;
	/**上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL*/
	private java.lang.String parentStorageId;
	/**银行名称只有 总公司、分公司、门店有*/
	private java.lang.String bank;
	/**银行账号只有 总公司、分公司、门店有*/
	private java.lang.String bankAccount;
	/**remark*/
	private java.lang.String remark;
	/**出库单打印抬头*/
	private java.lang.String departmentPrintname;
	/**门店类型 1直营 2加盟 3合作*/
	private java.lang.Integer storeType;
	/**0 不显示 1显示*/
	private java.lang.Integer isShow;
	/**店长名称*/
	private java.lang.String managerName;
	/**店长手机*/
	private java.lang.String managerPhone;

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
	 *@return: java.lang.String  省
	 */
	public java.lang.String getProvince(){
		return this.province;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  市
	 */
	public java.lang.String getCity(){
		return this.city;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  市
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区
	 */
	public java.lang.String getArea(){
		return this.area;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区
	 */
	public void setArea(java.lang.String area){
		this.area = area;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  直营店名称
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  直营店名称
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	public java.lang.Integer getSort(){
		return this.sort;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSort(java.lang.Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联direct_shop_id
	 */
	public java.lang.String getParentId(){
		return this.parentId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联direct_shop_id
	 */
	public void setParentId(java.lang.String parentId){
		this.parentId = parentId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  康众提供的字符串Id
	 */
	public java.lang.String getDirectShopId(){
		return this.directShopId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  康众提供的字符串Id
	 */
	public void setDirectShopId(java.lang.String directShopId){
		this.directShopId = directShopId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  1总公司、4：分公司、7：门店、10：普通部门、20：仓库
	 */
	public java.lang.Integer getType(){
		return this.type;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  1总公司、4：分公司、7：门店、10：普通部门、20：仓库
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  负责人
	 */
	public java.lang.Integer getEmployeeId(){
		return this.employeeId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  负责人
	 */
	public void setEmployeeId(java.lang.Integer employeeId){
		this.employeeId = employeeId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  成立时间
	 */
	public java.util.Date getBuildDate(){
		return this.buildDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  成立时间
	 */
	public void setBuildDate(java.util.Date buildDate){
		this.buildDate = buildDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门地点
	 */
	public java.lang.String getAddress(){
		return this.address;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门地点
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	public java.lang.String getPhone(){
		return this.phone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传真号码
	 */
	public java.lang.String getFax(){
		return this.fax;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传真号码
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  内部调拨系数
	 */
	public BigDecimal getInnerCoefficient(){
		return this.innerCoefficient;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  内部调拨系数
	 */
	public void setInnerCoefficient(BigDecimal innerCoefficient){
		this.innerCoefficient = innerCoefficient;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  内部调拨加急系数
	 */
	public BigDecimal getAllocateCoefficient(){
		return this.allocateCoefficient;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  内部调拨加急系数
	 */
	public void setAllocateCoefficient(BigDecimal allocateCoefficient){
		this.allocateCoefficient = allocateCoefficient;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  内部调拨核算系数
	 */
	public BigDecimal getRealCoefficient(){
		return this.realCoefficient;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  内部调拨核算系数
	 */
	public void setRealCoefficient(BigDecimal realCoefficient){
		this.realCoefficient = realCoefficient;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数据字典 store_level   1:1级  2:2级  3:3级
	 */
	public java.lang.Integer getStoreLevel(){
		return this.storeLevel;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数据字典 store_level   1:1级  2:2级  3:3级
	 */
	public void setStoreLevel(java.lang.Integer storeLevel){
		this.storeLevel = storeLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仅门店有，值为数字
	 */
	public java.lang.String getStoreSn(){
		return this.storeSn;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仅门店有，值为数字
	 */
	public void setStoreSn(java.lang.String storeSn){
		this.storeSn = storeSn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL
	 */
	public java.lang.String getParentStorageId(){
		return this.parentStorageId;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上级仓库，仅部门类型为4(分公司)和7(门店)有，无上级仓库为NULL
	 */
	public void setParentStorageId(java.lang.String parentStorageId){
		this.parentStorageId = parentStorageId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行名称只有 总公司、分公司、门店有
	 */
	public java.lang.String getBank(){
		return this.bank;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行名称只有 总公司、分公司、门店有
	 */
	public void setBank(java.lang.String bank){
		this.bank = bank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行账号只有 总公司、分公司、门店有
	 */
	public java.lang.String getBankAccount(){
		return this.bankAccount;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行账号只有 总公司、分公司、门店有
	 */
	public void setBankAccount(java.lang.String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remark
	 */
	public java.lang.String getRemark(){
		return this.remark;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remark
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库单打印抬头
	 */
	public java.lang.String getDepartmentPrintname(){
		return this.departmentPrintname;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出库单打印抬头
	 */
	public void setDepartmentPrintname(java.lang.String departmentPrintname){
		this.departmentPrintname = departmentPrintname;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  门店类型 1直营 2加盟 3合作
	 */
	public java.lang.Integer getStoreType(){
		return this.storeType;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  门店类型 1直营 2加盟 3合作
	 */
	public void setStoreType(java.lang.Integer storeType){
		this.storeType = storeType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  0 不显示 1显示
	 */
	public java.lang.Integer getIsShow(){
		return this.isShow;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  0 不显示 1显示
	 */
	public void setIsShow(java.lang.Integer isShow){
		this.isShow = isShow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店长名称
	 */
	public java.lang.String getManagerName(){
		return this.managerName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店长名称
	 */
	public void setManagerName(java.lang.String managerName){
		this.managerName = managerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  店长手机
	 */
	public java.lang.String getManagerPhone(){
		return this.managerPhone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  店长手机
	 */
	public void setManagerPhone(java.lang.String managerPhone){
		this.managerPhone = managerPhone;
	}
}

