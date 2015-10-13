package com.msds.plugin.mapper;

import com.msds.base.mapper.BaseMapper;
import com.msds.plugin.entity.PluginConfigEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-26 10:58:07 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PluginConfigMapper extends BaseMapper<PluginConfigEntity> {

	/**
	 * @Description TODO
	 * @param pluginId
	 * @return
	 */
	PluginConfigEntity findByPluginId(String pluginId);

}
