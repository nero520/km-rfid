package com.msds.km.returnModel.maintenance;

import java.io.Serializable;

import com.msds.km.returnModel.ReturnBaseModel;

public class MaintenanceModel extends ReturnBaseModel implements Serializable {

	private static final long serialVersionUID = -164674210348359907L;
	
	/** 服务明细 */
	private MaintenanceDetail detail;

	/**
	 * 获取  服务明细
	 * @return  detail  服务明细
	 */
	public MaintenanceDetail getDetail() {
		return detail;
	}

	/**
	 * 设置  服务明细
	 * @param  detail  服务明细
	 */
	public void setDetail(MaintenanceDetail detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "CategoryModel [detail=" + detail + ", getBusinessCode()="
				+ getBusinessCode() + ", getResult()=" + getResult()
				+ ", getNote()=" + getNote() + "]";
	}

}
