package com.msds.baseinfo.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;
import com.msds.baseinfo.mapper.AuthUserMapper;
import com.msds.baseinfo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AuthUserMapper authUserMapper;

	@Transactional(readOnly = true)
	public AuthUser getAuthUser(Integer id) {
		return authUserMapper.getUserById(id);
	}
    @Transactional(readOnly=true)
	public List<AuthUser> getUserList(Map map) {
		return authUserMapper.getUserList(map);
	}
    @Transactional(readOnly=true)
	public List<AuthGroup> getGroupJson() {
		return authUserMapper.getGroupJson();
	}
    @Transactional(readOnly=true)
	public int getCountSql(Map map) {
		return authUserMapper.getCountSql(map);
	}
    
    @Transactional
	public void insertUser(AuthUser user ,String params) {
    	authUserMapper.insertUser(user);
    	Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());
		map.put("groupId", user.getRoleId());
		authUserMapper.insertUserGroup(map);
	
    }
    @Transactional
	public AuthUser getUserById(Integer id) {
		return authUserMapper.getUserById(id);
	}
	public void updateUser(AuthUser user,String params) {
    	authUserMapper.updateUser(user);
    	authUserMapper.deleteAuthUserGroup(user.getId());
    	Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());
		map.put("groupId", user.getRoleId());
		authUserMapper.insertUserGroup(map);
    	
    
	}
	public void deleteUser(Integer id) {
		authUserMapper.deleteUser(id);
		authUserMapper.deleteAuthUserGroup(id);
	}
	@Override
	public Set<String> findRoles(String userName) {
		List<String> res = authUserMapper.findRoles(userName);
		Set<String> back = new HashSet<String>();
		back.addAll(res);
		return back;
	}
	@Override
	public Set<String> findPermissions(String userName) {
		List<String> res = authUserMapper.findPermissions(userName);
		Set<String> back = new HashSet<String>();
		back.addAll(res);
		return back;
	}
	@Override
	public AuthUser findByUsername(String userName) {
		return authUserMapper.findByUsername(userName);
	}
	@Override
	public List<Integer> getGroupIdByUserId(Integer userId) {
		return authUserMapper.getGroupIdByUserId(userId);
	}
	@Override
	public void changePassword(AuthUser user) {
		authUserMapper.updateUserPassword(user);
	}

}
