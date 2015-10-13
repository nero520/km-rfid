package com.msds.plugin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.plugin.entity.PluginConfigAttributeEntity;
import com.msds.plugin.mapper.PluginConfigAttributeMapper;
import com.msds.plugin.service.PluginConfigAttributeService;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigAttributeService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-25 14:09:21 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("pluginConfigAttributeService")
public class PluginConfigAttributeServiceImpl extends
		BaseServiceImpl<PluginConfigAttributeEntity> implements
		PluginConfigAttributeService {

	@Autowired
	private PluginConfigAttributeMapper pluginConfigAttributeMapper;

	public PluginConfigAttributeMapper baseMapper() {
		return pluginConfigAttributeMapper;
	}

	@Override
	public Map<String, String> findMapByPluginConfig(Integer id) {
		List<PluginConfigAttributeEntity> list = pluginConfigAttributeMapper
				.findMapByPluginConfigId(id);
		if (list == null)
			return null;
		Map<String, String> map = new HashMap<String, String>();
		for (PluginConfigAttributeEntity pluginConfigAttributeEntity : list) {
			map.put(pluginConfigAttributeEntity.getName(),
					pluginConfigAttributeEntity.getAttributes());
		}
		return map;

	}
}
