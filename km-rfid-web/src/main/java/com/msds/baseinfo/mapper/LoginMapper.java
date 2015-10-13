package com.msds.baseinfo.mapper;

import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;




public interface LoginMapper {
	
	/**
	 * 查询单一用户
	 */
	public AuthUser getUserInfo(String userName);

	public AuthGroup getGroupIdByUserId(Integer id);

}
