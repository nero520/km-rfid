package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.BillEntity;
import com.msds.km.mapper.BillMapper;
import com.msds.km.service.BillService;

/**
 * 
 * <br>
 * <b>功能：</b>BillService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-05 17:33:38 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("billService")
public class BillServiceImpl extends BaseServiceImpl<BillEntity> implements
		BillService {

	@Autowired
	private BillMapper billMapper;

	public BillMapper baseMapper() {
		return billMapper;
	}

}
