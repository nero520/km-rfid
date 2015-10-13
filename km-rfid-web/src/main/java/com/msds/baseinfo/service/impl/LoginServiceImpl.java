package com.msds.baseinfo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;
import com.msds.baseinfo.mapper.LoginMapper;
import com.msds.baseinfo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
    @Transactional(readOnly=true)
	public AuthUser getUserInfo(String userName) {
		// TODO Auto-generated method stub
		return loginMapper.getUserInfo(userName);
	}
    @Transactional(readOnly=true)
	public AuthGroup getGroupIdByUserId(Integer id) {
		// TODO Auto-generated method stub
		return loginMapper.getGroupIdByUserId(id);
	}

}
