package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.common.BasePage;
import com.msds.km.entity.RefundEntity;
import com.msds.km.vo.RefundList;

/**
 * 
 * <br>
 * <b>功能：</b>RefundService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface RefundService extends BaseService<RefundEntity> {
	/**
	 * 订单编号、用户手机号、车牌号、创建时间来查询 退款单列表
	 * @param refund
	 * @return
	 */
	List<RefundList> refundList(BasePage page);
}
