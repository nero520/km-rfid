package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.mapper.ProcessMapper;
import com.msds.km.service.ProcessService;

/**
 * 
 * <br>
 * <b>功能：</b>ProcessService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-06 18:33:25 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("processService")
public class ProcessServiceImpl extends BaseServiceImpl<ProcessEntity>
		implements ProcessService {

	@Autowired
	private ProcessMapper processMapper;

	public ProcessMapper baseMapper() {
		return processMapper;
	}

}
