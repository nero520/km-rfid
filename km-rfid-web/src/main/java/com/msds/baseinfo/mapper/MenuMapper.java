package com.msds.baseinfo.mapper;

import java.util.List;

import com.msds.baseinfo.entity.Permission;




public interface MenuMapper {
	
	public List<Permission> getMenuListByUserId(int userId);

	public List<Permission> getAdminList();
	
	public List<Permission> getMenuListByParentNode(List<Integer> list);
	

}
