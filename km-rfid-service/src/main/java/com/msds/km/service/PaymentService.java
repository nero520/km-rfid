package com.msds.km.service;

import com.msds.base.service.BaseService;
import com.msds.km.entity.PaymentEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PaymentService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PaymentService extends BaseService<PaymentEntity> {

	PaymentEntity findBySn(String sn);

	/**
	 * 支付处理
	 * 
	 * @Description TODO
	 * @param sn
	 * @param paymentSerialNumber
	 * @return
	 */
	PaymentEntity handle(String sn, String paymentSerialNumber);

}
