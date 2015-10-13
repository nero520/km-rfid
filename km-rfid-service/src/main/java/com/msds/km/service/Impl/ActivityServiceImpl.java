package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.ActivityEntity;
import com.msds.km.mapper.ActivityMapper;
import com.msds.km.service.ActivityService;

/**
 * 
 * <br>
 * <b>功能：</b>ActivityService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("activityService")
public class ActivityServiceImpl extends BaseServiceImpl<ActivityEntity>
		implements ActivityService {

	@Autowired
	private ActivityMapper activityMapper;

	public ActivityMapper baseMapper() {
		return activityMapper;
	}

	@Override
	public ActivityEntity findBySn(String sn) {
		return activityMapper.findBySn(sn);
	}

}
