package com.msds.plugin.service;

import java.util.Map;

import com.msds.base.service.BaseService;
import com.msds.plugin.entity.PluginConfigAttributeEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigAttributeService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-25 14:09:21 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PluginConfigAttributeService extends
		BaseService<PluginConfigAttributeEntity> {

	Map<String, String> findMapByPluginConfig(Integer id);

}
