package com.msds.baseinfo.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msds.baseinfo.common.ObjectToMap;
import com.msds.baseinfo.common.Page;
import com.msds.baseinfo.entity.AuthGroup;
import com.msds.baseinfo.entity.AuthUser;
import com.msds.baseinfo.service.UserService;
import com.msds.shiro.service.PasswordHelper;

/**
 * 用户管理
 * 
 */
@Controller
public class UserController extends CommonActionSupport {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7366857728335556204L;
	@Resource(name = "userServiceImpl")
	private UserService userService;
	@Autowired
	private PasswordHelper passwordHelper;

	/**
	 * 查询用户
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequiresPermissions("system.user:view")
	@RequestMapping(value = "/authUser/search", method = RequestMethod.GET)
	public String searchUserList() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		return "/user/user_list";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/authUser/getUserList", method = RequestMethod.POST)
	public @ResponseBody
	Map getUserList(AuthUser user, Page page) throws IOException,
			SecurityException, IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		page.initPage();// 计算查询数
		Map map = ObjectToMap.toPageMap(user, page);
		int count = userService.getCountSql(map);
		// 获得所有组
		List<AuthUser> list = userService.getUserList(map);
		Map resultMap = new HashMap<String, List>();
		resultMap.put("total", count);
		resultMap.put("data", list);
		return resultMap;
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */

	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.user:create")
	@RequestMapping(value = "/authUser/saveAuthUser", method = RequestMethod.POST)
	public @ResponseBody
	Map insertUser(AuthUser user, String params) throws IOException {
		String salt = passwordHelper.getSalt();
		String hexPwdString = passwordHelper.getHexPassword(user.getUserName(),
				salt, user.getPassword());
		user.setSalt(salt);
		user.setPassword(hexPwdString);
		// passwordHelper.encryptPassword(user);
		int success = 0;
		String message = "";
		try {
			user.setLastLogin(new Date());
			user.setDateJoined(new Date());
			userService.insertUser(user, params);
			success = 0;
		} catch (RuntimeException e) {
			e.printStackTrace();
			success = 1;
			message = "操作失败 !";
			e.printStackTrace();
		}
		return returnMessage(success, message);
	}

	/**
	 * 加载用户
	 */
	@RequestMapping(value = "/authUser/loadAuthUser")
	public @ResponseBody
	AuthUser loadUser(int id) {
		AuthUser user = userService.getUserById(id);
		return user;

	}

	/**
	 * 修改用户
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.user:update")
	@RequestMapping(value = "/authUser/updateAuthUser")
	public @ResponseBody
	Map updateUser(AuthUser user, String params) throws IOException {
		int success = 0;
		String message = "";
		try {
			user.setLastLogin(new Date());
			user.setLastName("");
			user.setDateJoined(new Date());
			userService.updateUser(user, params);
			success = 0;
			message = "操作成功";

		} catch (RuntimeException e) {
			success = 1;
			message = "操作失败!";
		}
		return returnMessage(success, message);
	}

	@RequiresPermissions("system.user:changePassword")
	@RequestMapping(value = "/authUser/changePassword", method = RequestMethod.POST)
	public @ResponseBody
	Map changePassword(Integer id, String password) {
		AuthUser user = userService.getAuthUser(id);
		// user.setPassword(password);
		// passwordHelper.encryptPassword(user);
		String salt = passwordHelper.getSalt();
		String hexPwdString = passwordHelper.getHexPassword(user.getUserName(),
				salt, password);
		user.setSalt(salt);
		user.setPassword(hexPwdString);
		int success = 0;
		String message = "";
		try {
			Date now = new Date();
			user.setLastLogin(now);
			user.setDateJoined(now);
			userService.changePassword(user);
			success = 0;
		} catch (RuntimeException e) {
			success = 1;
			message = "操作失败 !";
			e.printStackTrace();
		}
		return returnMessage(success, message);
	}

	/**
	 * 删除用户
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("system.user:delete")
	@RequestMapping(value = "/authUser/deleteUser")
	public @ResponseBody
	Map deleteUser(int id) throws IOException {
		int success = 0;
		String message = "";
		try {
			userService.deleteUser(id);
			// 清除缓存

			success = 0;
		} catch (RuntimeException e) {
			success = 1;
			message = "操作失败!";
			e.printStackTrace();
		}
		return returnMessage(success, message);
	}

	/**
	 * 获得json 序列化字符串
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/authUser/getGroupJson", method = RequestMethod.POST)
	public @ResponseBody
	List<AuthGroup> getGroupJson() throws IOException {
		// 获得所有组
		List<AuthGroup> list = userService.getGroupJson();
		return list;
	}

	@RequestMapping(value = "/authUser/changeOwnPassword", method = RequestMethod.POST)
	public @ResponseBody
	Map changeOwnPassword(String passwordOld, String passwordNew,
			String passwordConfig) {
		AuthUser user = getUser();
		if (!passwordNew.endsWith(passwordConfig)) {
			return returnMessage(1, "新密码与确认密码不同！");
		}
		String ps = passwordHelper.getHexPassword(user.getUserName(),
				user.getSalt(), passwordOld);
		if (!user.getPassword().equals(ps)) {
			return returnMessage(1, "原始密码错误，请重新输入！");
		}
		// user.setPassword(passwordNew);
		String salt = passwordHelper.getSalt();
		String hexPwdString = passwordHelper.getHexPassword(user.getUserName(),
				salt, passwordNew);
		user.setSalt(salt);
		user.setPassword(hexPwdString);
		// passwordHelper.encryptPassword(user);
		int success = 0;
		String message = "";
		try {
			user.setLastLogin(new Date());
			userService.changePassword(user);
			success = 0;
		} catch (RuntimeException e) {
			success = 1;
			message = "操作失败 !";
			e.printStackTrace();
		}
		return returnMessage(success, message);
	}
}
