package com.msds.km.service.Impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.PaymentEntity;
import com.msds.km.enums.PaymentStateEnum;
import com.msds.km.enums.PaymentTypeEnum;
import com.msds.km.mapper.PaymentMapper;
import com.msds.km.service.OrderService;
import com.msds.km.service.PaymentService;

/**
 * 
 * <br>
 * <b>功能：</b>PaymentService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("paymentService")
public class PaymentServiceImpl extends BaseServiceImpl<PaymentEntity>
		implements PaymentService {

	@Autowired
	private PaymentMapper paymentMapper;

	public PaymentMapper baseMapper() {
		return paymentMapper;
	}

	@Resource(name = "orderService")
	private OrderService orderService;

	@Override
	public PaymentEntity findBySn(String sn) {
		PaymentEntity paymentEntity = paymentMapper.findBySn(sn);
		return paymentEntity;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PaymentEntity handle(String sn, String paymentSerialNumber) {
		Assert.hasText(sn);
		PaymentEntity payment = paymentMapper.lockBySn(sn);
		payment.setPaymentSerialNumber(paymentSerialNumber);
		if (payment != null
				&& payment.getStatus() == PaymentStateEnum.UNPAID.getId()) {
			if (payment.getMethod() == PaymentTypeEnum.online.getId()) {
				if (payment.getOrderSn() != null) {
					orderService.payment(payment.getOrderSn(), payment);
				}
			}
			payment.setStatus(PaymentStateEnum.PAID.getId());
			payment.setPaymentDate(new Date());
			paymentMapper.update(payment);
		}
		return payment;
	}
}
