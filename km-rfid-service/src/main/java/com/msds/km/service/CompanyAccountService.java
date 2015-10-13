package com.msds.km.service;

import com.msds.base.service.BaseService;
import com.msds.km.entity.CompanyAccountEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyAccountService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-02 14:27:33 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface CompanyAccountService extends BaseService<CompanyAccountEntity> {

	/**
	 * 通过修理厂ID查询收款信息
	 * @param companyId
	 * @return 
	 * CompanyAccountEntity
	 */
	public CompanyAccountEntity findByCompanyId(Integer companyId) throws Exception;
}
