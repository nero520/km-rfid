package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.ReturnMapper;
import com.msds.km.entity.ReturnEntity;
import com.msds.km.service.ReturnService;

/**
 * 
 * <br>
 * <b>功能：</b>ReturnService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("returnService")
public class ReturnServiceImpl extends BaseServiceImpl<ReturnEntity> implements ReturnService{

	@Autowired
    private ReturnMapper returnMapper;
		
	public ReturnMapper baseMapper() {
		return returnMapper;
	}

}
