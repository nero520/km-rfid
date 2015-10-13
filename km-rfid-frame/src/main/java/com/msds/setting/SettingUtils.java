package com.msds.setting;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Component;

import com.msds.common.Setting;
import com.msds.setting.entity.SettingEntity;
import com.msds.setting.service.SettingService;

/**
 * 系统参数工具类
 * 
 * @ClassName SettingUtils
 * @Description Setting对象及其表中加入字段和记录，系统启动自动加载
 * @author LiLong
 * @date 2014年9月1日 上午9:41:56
 * 
 */
@Component
public final class SettingUtils {

	private static Setting setting = new Setting();

	@Resource
	private SettingService settingService;

	/**
	 * 不可实例化
	 */
	private SettingUtils() {
	}

	/**
	 * 初始化到缓存
	 */
	@PostConstruct
	public Setting postConstruct() {
		try {
			List<SettingEntity> list = settingService.findListByCondition(null);
			BeanUtilsBean beanUtils = new BeanUtilsBean();
			for (SettingEntity element : list) {
				String name = element.getName();
				String value = element.getValue();
				try {
					beanUtils.setProperty(setting, name, value);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setting;
	}

	/**
	 * 获取系统设置
	 * 
	 * @return 系统设置
	 */
	public static Setting get() {
		return setting;
	}

}