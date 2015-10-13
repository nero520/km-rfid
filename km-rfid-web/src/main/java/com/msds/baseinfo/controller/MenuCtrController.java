package com.msds.baseinfo.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.baseinfo.entity.Permission;
import com.msds.baseinfo.service.MenuCtrService;

@Controller
public class MenuCtrController extends CommonActionSupport {
	/**
	 * 
	 */
	@Resource(name = "menuCtrServiceImpl")
	private MenuCtrService menuCtrService;

	/**
	 * 跳转到菜单页面
	 * 
	 * @return
	 */
	@RequiresPermissions("system.permission:view")
	@RequestMapping(value = "/authPermission/searchAuthPermission", method = RequestMethod.GET)
	public String toMenu() {
		return "/menu/menu_list";
	}

	/**
	 * 保存权限
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.permission:create")
	@RequestMapping(value = "/authPermission/saveAuthPermission")
	public @ResponseBody
	Map saveAuthPermission(Permission permission) throws IOException {

		try {

			permission
					.setParentNode(Integer.valueOf(permission.getParentIds()));
			menuCtrService.savePermission(permission);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return returnMessage(1, "操作失败");
		}
		return returnMessage(0, "操作成功");
	}

	/**
	 * 加载一条权限信息
	 */
	@RequestMapping(value = "/authPermission/loadAuthPermission")
	public @ResponseBody
	Permission loadAuthPermission(String id) {
		String node_id = id;
		Permission permission = menuCtrService.getAuthPermission(Integer
				.parseInt(node_id));
		return permission;
	}

	/**
	 * 修改一条权限信息
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.permission:update")
	@RequestMapping(value = "/authPermission/updateAuthPermission")
	public @ResponseBody
	Map updateAuthPermission(Permission permission) throws IOException {
		try {
			menuCtrService.updateAuthPermission(permission);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return returnMessage(1, "操作失败");
		}
		return returnMessage(0, "操作成功");
	}

	/**
	 * 删除一条权限
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.permission:delete")
	@RequestMapping(value = "/authPermission/deleteAuthPermission", method = RequestMethod.POST)
	public @ResponseBody
	Map deleteAuthPermission(String id) throws IOException {
		int count = menuCtrService.getCountByPermissionId(id);
		if (count == 0) {
			try {
				menuCtrService.deleteAuthPermission(Integer.parseInt(id));
				menuCtrService.deleteAuthPermissionAssociate(Integer
						.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return returnMessage(1, "删除失败!");
			}
		} else {
			return returnMessage(1, "您当前的节点下面有子节点不能删除!");
		}
		return returnMessage(0, "操作成功");
	}

}
