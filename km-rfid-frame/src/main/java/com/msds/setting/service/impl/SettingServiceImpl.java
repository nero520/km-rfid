package com.msds.setting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.setting.entity.SettingEntity;
import com.msds.setting.mapper.SettingMapper;
import com.msds.setting.service.SettingService;

/**
 * 
 * <br>
 * <b>功能：</b>SettingService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("settingService")
public class SettingServiceImpl extends BaseServiceImpl<SettingEntity> implements SettingService{

	@Autowired
    private SettingMapper settingMapper;
		
	public SettingMapper baseMapper() {
		return settingMapper;
	}

}
