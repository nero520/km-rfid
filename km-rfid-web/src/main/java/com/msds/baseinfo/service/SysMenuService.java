package com.msds.baseinfo.service;

import java.util.List;

import com.msds.baseinfo.entity.Permission;




public interface SysMenuService {
	
	public List<Permission> getMenuListByUserId(int userId);

	public List<Permission> getAdminList();


}
