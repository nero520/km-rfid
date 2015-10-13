package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.ServiceModelDetailMapper;
import com.msds.km.entity.ServiceModelDetailEntity;
import com.msds.km.service.ServiceModelDetailService;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelDetailService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("serviceModelDetailService")
public class ServiceModelDetailServiceImpl extends BaseServiceImpl<ServiceModelDetailEntity> implements ServiceModelDetailService{

	@Autowired
    private ServiceModelDetailMapper serviceModelDetailMapper;
		
	public ServiceModelDetailMapper baseMapper() {
		return serviceModelDetailMapper;
	}

}
