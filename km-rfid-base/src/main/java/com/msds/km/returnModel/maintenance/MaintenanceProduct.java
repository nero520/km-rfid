package com.msds.km.returnModel.maintenance;

import java.math.BigDecimal;
import java.util.List;


public class MaintenanceProduct {

	/** 保养套餐ID */
	private String projectId;
	/** 保养的套餐名称 */
	private String projectName;
	/** type 0表示更换，1表示是检查 */
	private Integer type;
	/** 行驶里程数 */
	private BigDecimal mileague;
	/** 更新周期（月） */
	private Integer month;
	
	private BigDecimal mofq;
	/** 基础油类型 */
	private String baseOilType;
	/** 级别 */
	private String grade;
	/** 规格 */
	private String standard;
	
	/** 配件列表 */
	private List<MaintenanceAccInfo> accInfo;

	/**
	 * 获取  保养套餐ID
	 * @return  projectId  保养套餐ID
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * 设置  保养套餐ID
	 * @param  projectId  保养套餐ID
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * 获取  保养的套餐名称
	 * @return  projectName  保养的套餐名称
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * 设置  保养的套餐名称
	 * @param  projectName  保养的套餐名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * 获取  type0表示更换，1表示是检查
	 * @return  type  type0表示更换，1表示是检查
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置  type0表示更换，1表示是检查
	 * @param  type  type0表示更换，1表示是检查
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取  行驶里程数
	 * @return  mileague  行驶里程数
	 */
	public BigDecimal getMileague() {
		return mileague;
	}

	/**
	 * 设置  行驶里程数
	 * @param  mileague  行驶里程数
	 */
	public void setMileague(BigDecimal mileague) {
		this.mileague = mileague;
	}

	/**
	 * 获取  更新周期（月）
	 * @return  month  更新周期（月）
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * 设置  更新周期（月）
	 * @param  month  更新周期（月）
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * 获取  mofq
	 * @return  mofq  mofq
	 */
	public BigDecimal getMofq() {
		return mofq;
	}

	/**
	 * 设置  mofq
	 * @param  mofq  mofq
	 */
	public void setMofq(BigDecimal mofq) {
		this.mofq = mofq;
	}

	/**
	 * 获取  基础油类型
	 * @return  baseOilType  基础油类型
	 */
	public String getBaseOilType() {
		return baseOilType;
	}

	/**
	 * 设置  基础油类型
	 * @param  baseOilType  基础油类型
	 */
	public void setBaseOilType(String baseOilType) {
		this.baseOilType = baseOilType;
	}

	/**
	 * 获取  级别
	 * @return  grade  级别
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 设置  级别
	 * @param  grade  级别
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 获取  规格
	 * @return  standard  规格
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * 设置  规格
	 * @param  standard  规格
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * 获取  配件列表
	 * @return  accInfo  配件列表
	 */
	public List<MaintenanceAccInfo> getAccInfo() {
		return accInfo;
	}

	/**
	 * 设置  配件列表
	 * @param  accInfo  配件列表
	 */
	public void setAccInfo(List<MaintenanceAccInfo> accInfo) {
		this.accInfo = accInfo;
	}


}
