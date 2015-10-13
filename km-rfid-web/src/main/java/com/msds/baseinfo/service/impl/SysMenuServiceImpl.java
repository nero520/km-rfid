package com.msds.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.baseinfo.entity.Permission;
import com.msds.baseinfo.mapper.MenuMapper;
import com.msds.baseinfo.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private MenuMapper mapper;
    @Transactional(readOnly = true)
	public List<Permission> getMenuListByUserId(int userId) {
		// TODO Auto-generated method stub
		return mapper.getMenuListByUserId(userId);
	}
    @Transactional(readOnly = true)
	public List<Permission> getAdminList() {
		// TODO Auto-generated method stub
		return mapper.getAdminList();
	}

    @Transactional(readOnly = true)
   	public List<Permission> getMenuListByParentNode(List<Integer> list) {
   		// TODO Auto-generated method stub
   		return mapper.getMenuListByParentNode(list);
   	}
}
