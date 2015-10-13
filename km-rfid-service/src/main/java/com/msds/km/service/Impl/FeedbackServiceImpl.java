package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.FeedbackEntity;
import com.msds.km.mapper.FeedbackMapper;
import com.msds.km.service.FeedbackService;

/**
 * 
 * <br>
 * <b>功能：</b>FeedbackService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-03-16 10:57:08 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("feedbackService")
public class FeedbackServiceImpl extends BaseServiceImpl<FeedbackEntity>
		implements FeedbackService {

	@Autowired
	private FeedbackMapper feedbackMapper;

	public FeedbackMapper baseMapper() {
		return feedbackMapper;
	}

}
