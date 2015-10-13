package com.msds.km.mapper;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.ActivityEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ActivityMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ActivityMapper extends BaseMapper<ActivityEntity> {

	ActivityEntity findBySn(String sn);

	ActivityEntity lockBySn(String sn);

	int quantityIncr(String sn);

}
