package com.msds.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.msds.common.BasePage;

/**
 * 基础实体类<br>
 * 处理公共属性
 * 
 * @author LiLong 2014-7-28
 * 
 */
@JsonInclude(Include.NON_NULL)
public class BaseEntity extends BasePage implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改时间
	 */
	private Date modifyDate;

	/**
	 * @Description 获取 创建时间
	 * @return Date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @Description 获取 修改时间
	 * @return Date
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @Description 设置 创建时间
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @Description 设置 修改时间
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
