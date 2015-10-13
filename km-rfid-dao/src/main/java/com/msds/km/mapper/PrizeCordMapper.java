package com.msds.km.mapper;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.PrizeCordEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PrizeCordMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PrizeCordMapper extends BaseMapper<PrizeCordEntity> {

	PrizeCordEntity findByActivitySnLicense(
			@Param("activitySn") String activitySn,
			@Param("license") String license);

}
