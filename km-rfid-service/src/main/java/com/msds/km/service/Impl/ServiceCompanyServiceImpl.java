package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.ServiceCompanyEntity;
import com.msds.km.mapper.ServiceCompanyMapper;
import com.msds.km.service.ServiceCompanyService;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceCompanyService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:37 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("serviceCompanyService")
public class ServiceCompanyServiceImpl extends BaseServiceImpl<ServiceCompanyEntity> implements ServiceCompanyService{

	@Autowired
    private ServiceCompanyMapper serviceCompanyMapper;
		
	public ServiceCompanyMapper baseMapper() {
		return serviceCompanyMapper;
	}

}
