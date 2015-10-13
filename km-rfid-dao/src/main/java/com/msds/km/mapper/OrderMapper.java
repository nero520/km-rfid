package com.msds.km.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.common.BasePage;
import com.msds.km.entity.OrderEntity;
import com.msds.km.vo.OrderlistEntity;

/**
 * 
 * <br>
 * <b>功能：</b>OrderMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface OrderMapper extends BaseMapper<OrderEntity> {

	OrderEntity findBySn(String orderSn);
	
	OrderEntity findBySnMemberId(@Param("orderSn") String orderSn,
			@Param("memberId") Integer memberId);
	
	OrderEntity findByOrderSnOrCompanyId(@Param("orderSn") String orderSn,
			@Param("companyId") Integer companyId);

	List<OrderlistEntity> findOrderList(BasePage page);
	/**
	 * 查询总数
	 * @param page
	 * @return
	 */
	Integer findOrderCount(BasePage page);
	
	/**
	 * 查询并锁定
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @return
	 * @return OrderEntity
	 */
	OrderEntity lockBySn(String orderSn);

	/**
	 * 订单支付完成状态调整，订单状态、支付状态、支付时间、失效时间
	 * 
	 * @Description TODO
	 * @param orderEntity
	 * @return void
	 */
	void paymentConfirm(OrderEntity orderEntity);

	/**
	 * 修改 订单状态、配送单号
	 * 
	 * @Description TODO
	 * @param orderEntity
	 * @return void
	 */
	void updateStateAndPartsSn(OrderEntity orderEntity);

	/**
	 * 订单状态修改
	 * 
	 * @Description 订单状态、支付状态
	 * @param orderEntity
	 * @return void
	 */
	void updateStateBySn(OrderEntity orderEntity);

	/**
	 * 返回服务和条件的订单列表
	 * 
	 * @Description 小于某个时间，并满足指定状态的
	 * @param orderStateId
	 *            订单状态
	 * @param date
	 *            时间
	 * @return
	 * @return List<OrderEntity>
	 */
	List<OrderEntity> findListByStateLtDate(
			@Param("orderStateId") int orderStateId, @Param("date") Date date);

	
}
