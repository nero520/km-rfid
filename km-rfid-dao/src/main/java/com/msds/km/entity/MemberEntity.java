package com.msds.km.entity;

import com.msds.base.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * <br>
 * <b>功能：</b>MemberEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MemberEntity extends BaseEntity {
	
	/**ID*/
	private java.lang.Integer id;
	/**用户名*/
	private java.lang.String username;
	/**password*/
	private java.lang.String password;
	/**姓名*/
	private java.lang.String name;
	/**手机*/
	private java.lang.String phone;
	/**性别 1男 2女*/
	private java.lang.Integer sex;
	/**头像*/
	private java.lang.String ico;
	
	private Integer province;
	private Integer city;
	private Integer area;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String address;
	private String fullAddress;
	private String modelGroupName;
	private String license;
	private String vin;
	private BigDecimal mileage; 
	private Date buyDate;
	private String chassis;
	private Date lastServiceDate;
	private Integer modelId;
	private Integer memberId;
	private Integer memberModelId;
	
	private Integer shopId;
	private Integer seriesId;
	private Integer year;
	private String exhaustVolume;
	
	/**
	 * 下面字段用在历史服务列表
	 */
	private String engineType;
	private String engineNo;
	private String gearBoxType;
	private String gearBoxNo;
	private String checkDate;
	private String safeDate;
	
	private Boolean isEdit;
	
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getGearBoxType() {
		return gearBoxType;
	}
	public void setGearBoxType(String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}
	public String getGearBoxNo() {
		return gearBoxNo;
	}
	public void setGearBoxNo(String gearBoxNo) {
		this.gearBoxNo = gearBoxNo;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getSafeDate() {
		return safeDate;
	}
	public void setSafeDate(String safeDate) {
		this.safeDate = safeDate;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getExhaustVolume() {
		return exhaustVolume;
	}
	public void setExhaustVolume(String exhaustVolume) {
		this.exhaustVolume = exhaustVolume;
	}
	public Integer getMemberModelId() {
		return memberModelId;
	}
	public void setMemberModelId(Integer memberModelId) {
		this.memberModelId = memberModelId;
	}
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public String getModelGroupName() {
		return modelGroupName;
	}
	public void setModelGroupName(String modelGroupName) {
		this.modelGroupName = modelGroupName;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public BigDecimal getMileage() {
		return mileage;
	}
	public void setMileage(BigDecimal mileage) {
		this.mileage = mileage;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
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
	 *@return: java.lang.String  用户名
	 */
	public java.lang.String getUsername(){
		return this.username;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  password
	 */
	public java.lang.String getPassword(){
		return this.password;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  password
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	public java.lang.String getName(){
		return this.name;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机
	 */
	public java.lang.String getPhone(){
		return this.phone;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  性别 1男 2女
	 */
	public java.lang.Integer getSex(){
		return this.sex;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  性别 1男 2女
	 */
	public void setSex(java.lang.Integer sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	public java.lang.String getIco(){
		return this.ico;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setIco(java.lang.String ico){
		this.ico = ico;
	}

	
}

