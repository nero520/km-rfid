package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.SettleLogEntity;
import com.msds.km.mapper.SettleLogMapper;
import com.msds.km.service.SettleLogService;

/**
 * 
 * <br>
 * <b>功能：</b>SettleLogService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:08 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("settleLogService")
public class SettleLogServiceImpl extends BaseServiceImpl<SettleLogEntity> implements SettleLogService{

	@Autowired
    private SettleLogMapper settleLogMapper;
		
	public SettleLogMapper baseMapper() {
		return settleLogMapper;
	}

}
