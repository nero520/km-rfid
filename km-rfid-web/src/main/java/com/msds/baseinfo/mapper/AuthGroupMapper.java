package com.msds.baseinfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthObject;
import com.msds.baseinfo.entity.Permission;


@Repository
public interface AuthGroupMapper {

	public int getCountNum(Map paramMap);

	public List<AuthGroup> getGroupList(Map paramMap);

	public void saveAuthGroup(AuthGroup group);

	public AuthGroup loadAuthGroup(Integer id);

	public void updateAuthGroup(AuthGroup group);

	public List<Permission> getPerssionList(@Param("userId")Integer userId);

	public List<Permission> getChildPerssionList(Integer id);

	public int  isChecked(Map map);

	public void insertPermission(Map map);

	public void deletePermissionByGroupId(int group_id);

	public void deleteGroup(Integer id);
	
	public List<AuthGroup> getAllGroup();
	
	public List<Permission> getCategoryList(Permission group);

}
