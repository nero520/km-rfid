package com.msds.km.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msds.base.entity.BaseEntity;
/**
 * 
 * <br>
 * <b>功能：</b>MemberModelEntity<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-30 14:31:12 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public class MemberModelEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**ID*/
	private java.lang.Integer id;
	/**会员id*/
	private java.lang.Integer memberId;
	/**车型ID*/
	private java.lang.Integer modelId;
	/**车型组合名称(品牌车系排量年份)*/
	private java.lang.String modelGroupName;
	/**是否默认*/
	private java.lang.Integer defaultFlag;
	/**所属区域*/
	private java.lang.String region;
	/**车牌号*/
	private java.lang.String license;
	/**里程数*/
	private BigDecimal mileage;
	/**创建日期*/
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date buyDate;
	/**车架号*/
	private java.lang.String vin;
	
	/**
	 * 车品牌LOGO
	 */
	private String logo;
	
	
	/**
	 * 行驶证所有者姓名。
	 */
	private String name;
	/**
	 * 行驶证的住址
	 */
	private String address;
	/**
	 * 注册日期
	 */
	private String registerDate;
	/**
	 * 发证日期
	 */
	private String issueDate;
	/**
	 * 车辆类型
	 */
	private String vehicleType;
	/**
	 * 使用性质
	 */
	private String useCharacte;
	/**
	 * 品牌型号
	 */
	private String model;
	/**
	 * 发动机号码
	 */
	private String engineNO;
	
	//发动机类型
	private String engineType;
	//变速箱类型
	private String gearBoxType;
	//变速箱号
	private String gearBoxNO;
	//上次保养时间
	private Date lastServiceDate;
	//上次保养顾问
	private String lastServiceMan;
	//上次年检时间
	private Date checkDate;
	//保险到期时间
	private Date safeDate;
	//底盘号
	private String chassis;

	

	
	public String getGearBoxType() {
		return gearBoxType;
	}
	public void setGearBoxType(String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}
	public String getGearBoxNO() {
		return gearBoxNO;
	}
	public void setGearBoxNO(String gearBoxNO) {
		this.gearBoxNO = gearBoxNO;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public String getLastServiceMan() {
		return lastServiceMan;
	}
	public void setLastServiceMan(String lastServiceMan) {
		this.lastServiceMan = lastServiceMan;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public Date getSafeDate() {
		return safeDate;
	}
	public void setSafeDate(Date safeDate) {
		this.safeDate = safeDate;
	}
	public String getChassis() {
		return chassis;
	}
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  会员id
	 */
	public java.lang.Integer getMemberId(){
		return this.memberId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  会员id
	 */
	public void setMemberId(java.lang.Integer memberId){
		this.memberId = memberId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车型ID
	 */
	public java.lang.Integer getModelId(){
		return this.modelId;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车型ID
	 */
	public void setModelId(java.lang.Integer modelId){
		this.modelId = modelId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型组合名称(品牌车系排量年份)
	 */
	public java.lang.String getModelGroupName(){
		return this.modelGroupName;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型组合名称(品牌车系排量年份)
	 */
	public void setModelGroupName(java.lang.String modelGroupName){
		this.modelGroupName = modelGroupName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否默认
	 */
	public java.lang.Integer getDefaultFlag(){
		return this.defaultFlag;
	}
	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否默认
	 */
	public void setDefaultFlag(java.lang.Integer defaultFlag){
		this.defaultFlag = defaultFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属区域
	 */
	public java.lang.String getRegion(){
		return this.region;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属区域
	 */
	public void setRegion(java.lang.String region){
		this.region = region;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */
	public java.lang.String getLicense(){
		return this.license;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setLicense(java.lang.String license){
		this.license = license;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  里程数
	 */
	public BigDecimal getMileage(){
		return this.mileage;
	}
	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  里程数
	 */
	public void setMileage(BigDecimal mileage){
		this.mileage = mileage;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getBuyDate(){
		return this.buyDate;
	}
	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setBuyDate(java.util.Date buyDate){
		this.buyDate = buyDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车架号
	 */
	public java.lang.String getVin(){
		return this.vin;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车架号
	 */
	public void setVin(java.lang.String vin){
		this.vin = vin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getUseCharacte() {
		return useCharacte;
	}
	public void setUseCharacte(String useCharacte) {
		this.useCharacte = useCharacte;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getEngineNO() {
		return engineNO;
	}
	public void setEngineNO(String engineNO) {
		this.engineNO = engineNO;
	}
}

