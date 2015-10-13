package com.msds.km.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.OrderLogEntity;
import com.msds.km.mapper.OrderLogMapper;
import com.msds.km.service.OrderLogService;
import com.msds.util.BeanUtil;

/**
 * 
 * <br>
 * <b>功能：</b>OrderLogService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("orderLogService")
public class OrderLogServiceImpl extends BaseServiceImpl<OrderLogEntity>
		implements OrderLogService {

	@Autowired
	private OrderLogMapper orderLogMapper;

	public OrderLogMapper baseMapper() {
		return orderLogMapper;
	}

	@Override
	public void addLog(OrderEntity orderEntity, String operationPerson,
			Date operationDate, String operationRemark) {
		if (orderEntity != null) {
			try {
				OrderLogEntity orderLogEntity = new OrderLogEntity();
				BeanUtil.copyProperties(orderEntity, orderLogEntity);
				orderLogEntity.setOperationPerson(operationPerson);
				orderLogEntity.setOperationDate(operationDate);
				orderLogEntity.setOperationRemark(operationRemark);
				orderLogEntity.setId(null);
				orderLogMapper.add(orderLogEntity);
			} catch (Exception e) {
				logger.error("订单日志记录失败SN:", orderEntity.getOrderSn());
				e.printStackTrace();
			}
		}
	}

}
