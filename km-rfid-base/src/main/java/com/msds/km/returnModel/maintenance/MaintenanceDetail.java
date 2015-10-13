package com.msds.km.returnModel.maintenance;

import java.util.List;


public class MaintenanceDetail {
	/** 项目列表 */
	private List<MaintenanceProduct> projects;

	/**
	 * 获取  项目列表
	 * @return  projects  项目列表
	 */
	public List<MaintenanceProduct> getProjects() {
		return projects;
	}

	/**
	 * 设置  项目列表
	 * @param  projects  项目列表
	 */
	public void setProjects(List<MaintenanceProduct> projects) {
		this.projects = projects;
	}

}
