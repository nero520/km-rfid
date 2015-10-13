package com.msds.km.mapper;


import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.VersionMaxEntity;
/**
 * 
 * <br>
 * <b>功能：</b>VersionMaxMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-01-13 09:55:50 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface VersionMaxMapper extends BaseMapper<VersionMaxEntity> {
	
	public VersionMaxEntity getMaxByOsType(@Param("osType")int osType);
}
