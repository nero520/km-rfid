package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.CompanyAccountEntity;
import com.msds.km.mapper.CompanyAccountMapper;
import com.msds.km.service.CompanyAccountService;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyAccountService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-02 14:27:33 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("companyAccountService")
public class CompanyAccountServiceImpl extends
		BaseServiceImpl<CompanyAccountEntity> implements CompanyAccountService {

	@Autowired
	private CompanyAccountMapper companyAccountMapper;

	public CompanyAccountMapper baseMapper() {
		return companyAccountMapper;
	}

	@Override
	public CompanyAccountEntity findByCompanyId(Integer companyId)
			throws Exception {
		return companyAccountMapper.findByCompanyId(companyId);
	}

}
