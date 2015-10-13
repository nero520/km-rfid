package com.msds.km.mapper;


import java.util.List;
import java.util.Map;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.IdMapperEntity;
/**
 * 
 * <br>
 * <b>功能：</b>IdMapperMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-12-02 17:25:53 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface IdMapperMapper extends BaseMapper<IdMapperEntity> {
	
	/**
	 * 返回实体
	 * 
	 * @param 主键
	 * @return
	 */
	public IdMapperEntity  findByIdMapperEntity(IdMapperEntity param);
	
	/**
	 * 返回实体List
	 * 
	 * @param 实体条件
	 * @return
	 */
	public List<IdMapperEntity> findListBySeriesIds(Map<String,Object> param );
}
