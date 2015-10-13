package com.msds.plugin.service;

import com.msds.base.service.BaseService;
import com.msds.plugin.entity.PluginConfigEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-25 14:09:21 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PluginConfigService extends BaseService<PluginConfigEntity> {

	boolean pluginIdExists(String id);

	PluginConfigEntity findByPluginId(String id);

}
