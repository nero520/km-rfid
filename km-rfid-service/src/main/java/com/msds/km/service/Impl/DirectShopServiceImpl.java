package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.DirectShopMapper;
import com.msds.km.entity.DirectShopEntity;
import com.msds.km.service.DirectShopService;

/**
 * 
 * <br>
 * <b>功能：</b>DirectShopService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("directShopService")
public class DirectShopServiceImpl extends BaseServiceImpl<DirectShopEntity> implements DirectShopService{

	@Autowired
    private DirectShopMapper directShopMapper;
		
	public DirectShopMapper baseMapper() {
		return directShopMapper;
	}

}
