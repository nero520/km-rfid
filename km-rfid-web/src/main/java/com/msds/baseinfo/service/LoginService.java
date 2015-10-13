package com.msds.baseinfo.service;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;


public interface LoginService {	
	public AuthUser getUserInfo(String userName);
	public AuthGroup getGroupIdByUserId(Integer id);
}
