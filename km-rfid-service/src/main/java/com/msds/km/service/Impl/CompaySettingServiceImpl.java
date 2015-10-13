package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.CompaySettingEntity;
import com.msds.km.mapper.CompaySettingMapper;
import com.msds.km.service.CompaySettingService;

/**
 * 
 * <br>
 * <b>功能：</b>CompaySettingService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:07 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("compaySettingService")
public class CompaySettingServiceImpl extends
		BaseServiceImpl<CompaySettingEntity> implements CompaySettingService {

	@Autowired
	private CompaySettingMapper compaySettingMapper;

	public CompaySettingMapper baseMapper() {
		return compaySettingMapper;
	}

}
