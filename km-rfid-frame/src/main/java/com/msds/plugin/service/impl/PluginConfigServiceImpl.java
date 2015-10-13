package com.msds.plugin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.plugin.entity.PluginConfigEntity;
import com.msds.plugin.mapper.PluginConfigMapper;
import com.msds.plugin.service.PluginConfigService;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-25 14:09:21 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("pluginConfigService")
public class PluginConfigServiceImpl extends
		BaseServiceImpl<PluginConfigEntity> implements PluginConfigService {

	@Autowired
	private PluginConfigMapper pluginConfigMapper;

	public PluginConfigMapper baseMapper() {
		return pluginConfigMapper;
	}

	@Override
	public boolean pluginIdExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PluginConfigEntity findByPluginId(String pluginId) {
		return pluginConfigMapper.findByPluginId(pluginId);
	}

}
