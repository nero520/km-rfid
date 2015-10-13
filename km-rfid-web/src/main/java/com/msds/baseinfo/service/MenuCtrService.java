package com.msds.baseinfo.service;

import java.util.HashSet;
import java.util.List;

import com.msds.baseinfo.entity.Permission;


public interface MenuCtrService {

	public Integer getMaxValueByParentId(Integer parentNode);
	
	public Integer getMaxId();

	public void savePermission(Permission permission);

	public Permission getAuthPermission(Integer node_id);

	public void updateAuthPermission(Permission permission);

	public void deleteAuthPermission(Integer parseInt);

	public void deleteAuthPermissionAssociate(int parseInt);

	public int getCountByPermissionId(String id);
	
	public Integer getMaxNumOfChar(Integer parentNode);
	
	public Integer getParentNodeByNode(Integer node);
	
	@SuppressWarnings("rawtypes")
	public HashSet getAllPermissionStr();
	

}
