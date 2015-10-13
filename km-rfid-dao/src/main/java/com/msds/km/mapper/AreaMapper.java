package com.msds.km.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.AreaEntity;

/**
 * 
 * <br>
 * <b>功能：</b>AreaMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface AreaMapper extends BaseMapper<AreaEntity> {

	/**
	 * 根据城市查询code
	 * 
	 * @param province
	 * @param city
	 * @return
	 */
	Integer findIdByName(@Param("province") String province,
			@Param("city") String city);
	
	
	List<AreaEntity> findList(AreaEntity area);

}
