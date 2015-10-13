package com.msds.km.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.RefundEntity;
import com.msds.km.entity.RefundLogEntity;
import com.msds.km.mapper.RefundLogMapper;
import com.msds.km.service.RefundLogService;
import com.msds.util.BeanUtil;

/**
 * 
 * <br>
 * <b>功能：</b>RefundLogService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("refundLogService")
public class RefundLogServiceImpl extends BaseServiceImpl<RefundLogEntity> implements RefundLogService{

	@Autowired
    private RefundLogMapper refundLogMapper;
		
	public RefundLogMapper baseMapper() {
		return refundLogMapper;
	}

	@Override
	public void addLog(RefundEntity refundEntity, String operationPerson,
			Date operationDate) {
		if (refundEntity != null) {
			try {
				RefundLogEntity refundLogEntity = new RefundLogEntity();
				BeanUtil.copyProperties(refundEntity, refundLogEntity);
				refundLogEntity.setOperator(operationPerson);
				refundLogEntity.setCreateDate(operationDate);
				refundLogEntity.setId(null);
				refundLogMapper.add(refundLogEntity);
			} catch (Exception e) {
				logger.error("订单日志记录失败SN:", refundEntity.getOrderSn());
				e.printStackTrace();
			}
		}
		
	}

}
