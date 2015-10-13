package com.msds.km.mapper;


import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.SettleAccountEntity;
/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface SettleAccountMapper extends BaseMapper<SettleAccountEntity> {
	public SettleAccountEntity findBySnAndCompanyId(@Param("settleSn")String settleSn,@Param("companyId")Integer companyId);
	
	public SettleAccountEntity findBySn(@Param("settleSn")String settleSn);
	
}
