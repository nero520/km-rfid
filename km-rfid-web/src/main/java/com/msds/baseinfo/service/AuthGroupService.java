package com.msds.baseinfo.service;

import java.util.List;
import java.util.Map;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthObject;
import com.msds.baseinfo.entity.Permission;


public interface AuthGroupService {

	List<AuthGroup> getGroupList(Map paramMap);

	int getCountSql(Map paramMap);

	void saveAuthGroup(AuthGroup group);

	AuthGroup loadAuthGroup(Integer id);

	void updateAuthGroup(AuthGroup group);

	List<Permission> getPerssionList();

	List<Permission> getChildPerssionList(Integer id);

	int isChecked(Map map);

	void deletePermissionByGroupId(String group_id);

	void insertGroupPermission(String gid,String pid);

	void deleteGroup(Integer id);
	
	public List<AuthGroup> getAllGroup();
	
	public List<AuthObject> getAuthObjectList(AuthGroup group,Integer userId);
	
}
