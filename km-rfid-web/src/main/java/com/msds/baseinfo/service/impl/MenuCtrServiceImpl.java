package com.msds.baseinfo.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.baseinfo.entity.Permission;
import com.msds.baseinfo.mapper.MenuCtrMapper;
import com.msds.baseinfo.service.MenuCtrService;


@Service
public class MenuCtrServiceImpl implements MenuCtrService {
	@Autowired
	private MenuCtrMapper mmMapper;

	@Transactional
	public Integer getMaxValueByParentId(Integer parentNode) {
		// TODO Auto-generated method stub
		return mmMapper.getMaxValueByParentId(parentNode);
	}

	@Transactional
	public Integer getMaxId() {
		// TODO Auto-generated method stub
		return mmMapper.getMaxId();
	}

	@Transactional
	public void savePermission(Permission permission) {
		mmMapper.savePermission(permission);
	}

	@Transactional
	public Permission getAuthPermission(Integer node_id) {
		// TODO Auto-generated method stub
		return mmMapper.getAuthPermission(node_id);
	}

	@Transactional
	public void updateAuthPermission(Permission permission) {
		mmMapper.updateAuthPermission(permission);
	}

	@Transactional
	public void deleteAuthPermission(Integer id) {
		mmMapper.deleteAuthPermission(id);
	}

	@Transactional
	public void deleteAuthPermissionAssociate(int id) {
		mmMapper.deleteAuthPermissionAssociate(id);
	}

	@Transactional
	public int getCountByPermissionId(String id) {
		// TODO Auto-generated method stub
		return mmMapper.getCountByPermissionId(Integer.parseInt(id));
	}

	public Integer getMaxNumOfChar(Integer parentNode) {
		// TODO Auto-generated method stub
		return mmMapper.getMaxNumOfChar(parentNode);
	}

	public Integer getParentNodeByNode(Integer node) {
		// TODO Auto-generated method stub
		return mmMapper.getParentNodeByNode(node);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HashSet getAllPermissionStr() {
		List<Permission> list = mmMapper.getAllPermission();
		HashSet permissionSet = new HashSet();
		/* 具体业务逻辑 如果查到里面带，那么拆分 如果没有 不拆分 之后对每个url 进行 判断 有？ 说明后面附带参数 那么进行截取 */
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCodename().indexOf(",") != -1) {
				String[] array = list.get(i).getCodename().split(",");
				for (String string : array) {
					int start = 0;
					int end = string.indexOf("?");
					if (end == -1) {
						end = string.length();
					}
					permissionSet.add(string.substring(start, end));
				}
			} else {
				int start = 0;
				int end = list.get(i).getCodename().indexOf("?");
				if (end == -1) {
					end = list.get(i).getCodename().length();
				}
				permissionSet.add(list.get(i).getCodename()
						.substring(start, end));
			}
		}
		return permissionSet;
	}
	
}
