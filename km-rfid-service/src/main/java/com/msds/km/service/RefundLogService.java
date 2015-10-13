package com.msds.km.service;

import java.util.Date;

import com.msds.base.service.BaseService;
import com.msds.km.entity.RefundEntity;
import com.msds.km.entity.RefundLogEntity;

/**
 * 
 * <br>
 * <b>功能：</b>RefundLogService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface RefundLogService extends BaseService<RefundLogEntity> {
	
	void addLog(RefundEntity refundEntity, String operationPerson,
			Date operationDate);
	
}
