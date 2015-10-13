package com.msds.km.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.PublishEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PublishMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-09 11:28:24 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PublishMapper extends BaseMapper<PublishEntity> {

	/**
	 * 查询页面配置(包括平台通用)
	 * 
	 * @param type
	 * @param os
	 * @return
	 */
	List<PublishEntity> findListByTypeOs(@Param("type") Integer type,
			@Param("os") Integer os);

}
