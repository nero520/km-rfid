package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.PublishEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PublishService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-09 11:28:24 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PublishService extends BaseService<PublishEntity> {

	/**
	 * 查询页面配置(包括平台通用)
	 * 
	 * @param type
	 *            类型
	 * @param os
	 *            平台
	 * @return
	 */
	List<PublishEntity> findListByTypeOs(Integer type, Integer os);

}
