package com.msds.baseinfo.mapper;

import java.util.List;

import com.msds.baseinfo.entity.Permission;




public interface MenuCtrMapper {
	
	public Integer getMaxValueByParentId(Integer parentNode);

	public void savePermission(Permission permission);

	public Permission getAuthPermission(Integer node_id);

	public void updateAuthPermission(Permission permission);

	public void deleteAuthPermission(Integer id);

	public void deleteAuthPermissionAssociate(int id);

	public int getCountByPermissionId(Integer id);	
	
	public Integer getMaxNumOfChar(Integer parentNode);
	
	public Integer getParentNodeByNode(Integer node);
	
	public Integer getMaxId();
	
	public List<Permission> getAllPermission();
	
}
