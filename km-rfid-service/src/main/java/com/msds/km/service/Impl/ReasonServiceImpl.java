package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.ReasonMapper;
import com.msds.km.entity.ReasonEntity;
import com.msds.km.service.ReasonService;

/**
 * 
 * <br>
 * <b>功能：</b>ReasonService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:37 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("reasonService")
public class ReasonServiceImpl extends BaseServiceImpl<ReasonEntity> implements ReasonService{

	@Autowired
    private ReasonMapper reasonMapper;
		
	public ReasonMapper baseMapper() {
		return reasonMapper;
	}

}
