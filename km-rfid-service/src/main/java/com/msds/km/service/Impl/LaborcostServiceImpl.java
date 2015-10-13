package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.LaborcostMapper;
import com.msds.km.entity.LaborcostEntity;
import com.msds.km.service.LaborcostService;

/**
 * 
 * <br>
 * <b>功能：</b>LaborcostService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("laborcostService")
public class LaborcostServiceImpl extends BaseServiceImpl<LaborcostEntity> implements LaborcostService{

	@Autowired
    private LaborcostMapper laborcostMapper;
		
	public LaborcostMapper baseMapper() {
		return laborcostMapper;
	}
	

}
