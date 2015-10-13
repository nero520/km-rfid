package com.msds.km.mapper;


import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.CompanyAccountEntity;
/**
 * 
 * <br>
 * <b>功能：</b>CompanyAccountMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-02 14:27:33 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface CompanyAccountMapper extends BaseMapper<CompanyAccountEntity> {
	
	public CompanyAccountEntity findByCompanyId(Integer companyId);
}
