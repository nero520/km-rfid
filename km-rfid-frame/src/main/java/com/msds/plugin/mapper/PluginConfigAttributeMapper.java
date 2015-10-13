package com.msds.plugin.mapper;

import java.util.List;

import com.msds.base.mapper.BaseMapper;
import com.msds.plugin.entity.PluginConfigAttributeEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PluginConfigAttributeMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-11-26 10:58:08 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PluginConfigAttributeMapper extends
		BaseMapper<PluginConfigAttributeEntity> {

	/**
	 * @Description TODO
	 * @param id
	 * @return
	 */
	List<PluginConfigAttributeEntity> findMapByPluginConfigId(Integer id);

}
