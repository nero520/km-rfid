package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.PublishMapper;
import com.msds.km.entity.PublishEntity;
import com.msds.km.service.PublishService;

/**
 * 
 * <br>
 * <b>功能：</b>PublishService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-09 11:28:24 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("publishService")
public class PublishServiceImpl extends BaseServiceImpl<PublishEntity>
		implements PublishService {

	@Autowired
	private PublishMapper publishMapper;

	public PublishMapper baseMapper() {
		return publishMapper;
	}

	@Override
	public List<PublishEntity> findListByTypeOs(Integer type, Integer os) {
		return publishMapper.findListByTypeOs(type, os);
	}
}
