package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.RfidLogMapper;
import com.msds.km.entity.RfidLogEntity;
import com.msds.km.service.RfidLogService;

/**
 * 
 * <br>
 * <b>功能：</b>RfidLogService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-10 13:29:15 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("rfidLogService")
public class RfidLogServiceImpl extends BaseServiceImpl<RfidLogEntity> implements RfidLogService{

	@Autowired
    private RfidLogMapper rfidLogMapper;
		
	public RfidLogMapper baseMapper() {
		return rfidLogMapper;
	}

}
