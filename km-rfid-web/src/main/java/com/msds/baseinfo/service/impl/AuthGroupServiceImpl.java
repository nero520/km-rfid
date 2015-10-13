package com.msds.baseinfo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthObject;
import com.msds.baseinfo.entity.Permission;
import com.msds.baseinfo.mapper.AuthGroupMapper;
import com.msds.baseinfo.service.AuthGroupService;


@Service
public class AuthGroupServiceImpl implements AuthGroupService {
	@Autowired
	private AuthGroupMapper groupMapper;

	@Transactional
	public int getCountSql(Map paramMap) {
		return groupMapper.getCountNum(paramMap);
	}

	@Transactional
	public List<AuthGroup> getGroupList(Map paramMap) {
		return groupMapper.getGroupList(paramMap);
	}

	public void saveAuthGroup(AuthGroup group) {
		groupMapper.saveAuthGroup(group);
	}

	@Transactional
	public AuthGroup loadAuthGroup(Integer id) {
		return groupMapper.loadAuthGroup(id);
	}

	@Transactional
	public void updateAuthGroup(AuthGroup group) {
		groupMapper.updateAuthGroup(group);
	}

	@Transactional
	public List<Permission> getPerssionList() {
		return groupMapper.getPerssionList(null);
	}

	@Transactional
	public List<Permission> getChildPerssionList(Integer id) {
		return groupMapper.getChildPerssionList(id);
	}

	@Transactional
	public int isChecked(Map map) {
		return groupMapper.isChecked(map);
	}

	@Transactional
	public void deletePermissionByGroupId(String group_id) {
		groupMapper.deletePermissionByGroupId(Integer.valueOf(group_id));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public void insertGroupPermission(String gid, String pid) {
		Map map = new HashMap<String, Object>();
		map.put("groupId", Integer.parseInt(gid));
		map.put("permissionId", Integer.parseInt(pid));
		try {
			groupMapper.insertPermission(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteGroup(Integer id) {
		groupMapper.deleteGroup(id);
	}

	public List<AuthGroup> getAllGroup() {
		return groupMapper.getAllGroup();
	}
	
	@Transactional
	public List<AuthObject> getAuthObjectList(AuthGroup group,Integer userId) {
		List<Permission> permissionList=groupMapper.getPerssionList(userId);
		List<AuthObject> authObjectList=new ArrayList<AuthObject>();
		for(int i=0;i<permissionList.size();i++)
		{
			AuthObject obj=new AuthObject();
			obj.setId(permissionList.get(i).getId());
			obj.setText(permissionList.get(i).getName());
			obj.setPid(String.valueOf(permissionList.get(i).getParentNode()));
			
			Map map = new HashMap();
			map.put("groupId", group.getId());
			map.put("permissionId", permissionList.get(i).getId());
			
			int checked = groupMapper.isChecked(map);
//			int checked = 0;
			obj.setChecked(checked==1?true:false);
			authObjectList.add(obj);
		}
		return authObjectList;
	}
	
}
