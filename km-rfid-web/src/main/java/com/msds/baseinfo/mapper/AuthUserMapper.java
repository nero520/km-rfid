package com.msds.baseinfo.mapper;

import java.util.List;
import java.util.Map;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;


public interface AuthUserMapper {	
	public List<AuthUser> getUserList(Map map);
	public List<AuthGroup> getGroupJson();
	public int getCountSql(Map map);
	public void insertUser(AuthUser user);
	public void insertUserGroup(Map map);
	public AuthUser getUserById(Integer id);
	public void updateUser(AuthUser user);
	public void updateUserGroup(Map map);
	public void deleteUser(Integer id);
	public void deleteAuthUserGroup(Integer id);
	public List<String> findRoles(String userName);
	public List<String> findPermissions(String userName) ;
	public AuthUser findByUsername(String userName) ;
	public List<Integer> getGroupIdByUserId(Integer userId) ;
	
	public void updateUserPassword(AuthUser user);
}
