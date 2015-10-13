package com.msds.baseinfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.baseinfo.common.UserInfo;
import com.msds.baseinfo.entity.Permission;
import com.msds.baseinfo.service.SysMenuService;

@Controller
public class SysMenuController extends CommonActionSupport {
	@Resource(name = "sysMenuServiceImpl")
	private SysMenuService sysMenuService;

	/**
	 * 获得菜单列表
	 * 
	 * @throws IOException
	 */

	@RequestMapping(value = "/permission/MenuList")
	public @ResponseBody
	List<Permission> MenuList() throws IOException {
		UserInfo info = new UserInfo();
		int userId = 0;
		String userName = "";
		if (info.getUser() != null) {
			userId = info.getUser().getId();
			userName = info.getUser().getUserName();
		}
		List<Permission> list = new ArrayList<Permission>();
		if ("admin".equals(userName)) {
			list = sysMenuService.getAdminList();
		} else {
			list = sysMenuService.getMenuListByUserId(userId);
		}
		return list;
	}
}
