package com.msds.baseinfo.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.baseinfo.common.ObjectToMap;
import com.msds.baseinfo.common.Page;
import com.msds.baseinfo.common.UserInfo;
import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthObject;
import com.msds.baseinfo.entity.Permission;
import com.msds.baseinfo.service.AuthGroupService;

@Controller
public class AuthGroupController extends CommonActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource(name = "authGroupServiceImpl")
	private AuthGroupService authGroupService;

	@RequiresPermissions("system.group:view")
	@RequestMapping(value = "/authGroup/searchAuthGroup", method = RequestMethod.GET)
	public String searchAuthGroup() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		return "/usergroup/usergroup_list";
	}

	@RequestMapping(value = "/authGroup/groupList")
	public @ResponseBody
	List<AuthGroup> getGroupList(AuthGroup group, Page page)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		page.initPage();// 计算查询数
		Map map = ObjectToMap.toPageMap(group, page);

		UserInfo info = new UserInfo();
		int userId = 0;
		String userName = "";
		if (info.getUser() != null) {
			userId = info.getUser().getId();
			userName = info.getUser().getUserName();
		}
		List<AuthGroup> list = new ArrayList<AuthGroup>();
		if (!"admin".equals(userName)) {
			map.put("userId", userId);
		}
		// 获得所有组
		list = authGroupService.getGroupList(map);

		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/authGroup/getAllGroup", method = RequestMethod.POST)
	public @ResponseBody
	Map getAllGroup() throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		// 获得所有组
		List<AuthGroup> list = authGroupService.getAllGroup();
		Map resultMap = new HashMap<String, List>();
		resultMap.put("total", 0);
		resultMap.put("rows", list);
		return resultMap;
	}

	@RequiresPermissions("system.group:save")
	@RequestMapping(value = "/authGroup/saveAuthGroup", method = RequestMethod.POST)
	public @ResponseBody
	Map saveAuthGroup(AuthGroup group) throws IOException {
		try {
			authGroupService.saveAuthGroup(group);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return returnMessage(1, "操作失败");
		}
		return returnMessage(0, "操作成功");
	}

	@RequiresPermissions("system.group:update")
	@RequestMapping(value = "/authGroup/updateAuthGroup", method = RequestMethod.POST)
	public @ResponseBody
	Map updateAuthGroup(AuthGroup group) throws IOException {
		try {
			authGroupService.updateAuthGroup(group);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return returnMessage(1, "操作失败");
		}
		return returnMessage(0, "操作成功");

	}

	/**
	 * 根据权限 动态拼接html 片段
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/authGroup/getPersssionList")
	public @ResponseBody
	List<AuthObject> getPersssionList(AuthGroup group) throws IOException {
		UserInfo info = new UserInfo();
		Integer userId = null;
		String userName = "";
		if (info.getUser() != null) {
			userName = info.getUser().getUserName();
		}
		if (!userName.equals("admin")) {
			userId = info.getUser().getId();
		}
		List<AuthObject> authObjectList = authGroupService.getAuthObjectList(
				group, userId);
		return authObjectList;
	}

	/**
	 * 根据子节点 动态html 片段
	 * 
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void toLeafJson(Map p, AuthGroup group) {
		if (group.getId() != null) {
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("groupId", group.getId());
			map.put("permissionId", p.get("id"));
			int checked = authGroupService.isChecked(map);
			if (checked > 0) {
				p.put("checked", true);
			}
		}

		List<Permission> list = authGroupService
				.getChildPerssionList((Integer) p.get("id"));

		@SuppressWarnings("rawtypes")
		List<Map> listMap = new ArrayList<Map>();
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				Map otherMap = new HashMap<String, Object>();
				otherMap.put("id", list.get(i).getId());
				otherMap.put("text", list.get(i).getName());
				toLeafJson(otherMap, group);
				listMap.add(otherMap);
			}
			p.put("children", listMap);
		}
	}

	/**
	 * 保存权限
	 * 
	 * @throws IOException
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.group:changePermission")
	@RequestMapping(value = "/authGroup/savePermission", method = RequestMethod.POST)
	public @ResponseBody
	Map savePermission(String groupId, String ids) throws IOException {
		String group_id = groupId;
		String id = ids;
		try {
			authGroupService.deletePermissionByGroupId(group_id);
			if (StringUtils.isNotBlank(id)) {
				String[] strArray = id.split(",");
				for (int i = 0; i < strArray.length; i++) {
					authGroupService.insertGroupPermission(group_id,
							strArray[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return returnMessage(2, "操作失败！");
		}
		return returnMessage(0, "操作成功");
	}

	/**
	 * 删除组信息 连同权限一起删除
	 * 
	 * @throws IOException
	 */
	@RequiresPermissions("system.group:delete")
	@RequestMapping(value = "/authGroup/deleteAuthGroup")
	public @ResponseBody
	Map deleteAuthGroup(AuthGroup group) throws IOException {
		// 删除用户组所对应的权限
		try {
			authGroupService
					.deletePermissionByGroupId(group.getId().toString());
			authGroupService.deleteGroup(group.getId());
		} catch (RuntimeException e) {
			e.printStackTrace();
			return returnMessage(2, "操作失败！");
		}
		return returnMessage(0, "操作成功");
	}

	/**
	 * 加载角色
	 */
	@RequestMapping(value = "/authGroup/loadAuthGroup")
	public @ResponseBody
	AuthGroup loadUser(int id) {
		AuthGroup authGroup = authGroupService.loadAuthGroup(id);
		return authGroup;
	}

}
