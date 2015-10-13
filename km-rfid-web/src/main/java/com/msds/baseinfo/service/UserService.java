package com.msds.baseinfo.service;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;

public interface UserService {	
	public AuthUser getAuthUser(Integer id);
	public List<AuthUser> getUserList(Map map);
	public List<AuthGroup> getGroupJson();
	public int getCountSql(Map map);
	public void insertUser(AuthUser user ,String params);
	public AuthUser getUserById(Integer id);
	public void updateUser(AuthUser user,String params);
	public void deleteUser(Integer id);
	public Set<String> findRoles(String userName);
	public Set<String>	findPermissions(String userName);
	public AuthUser findByUsername(String userName);
	public List<Integer> getGroupIdByUserId(Integer userId);
	public void changePassword(AuthUser user);
}
