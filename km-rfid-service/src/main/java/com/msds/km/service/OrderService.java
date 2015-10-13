package com.msds.km.service;

import java.util.Date;
import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.common.BasePage;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.PaymentEntity;
import com.msds.km.enums.OrderStateEnum;
import com.msds.km.enums.PaymentTypeEnum;
import com.msds.km.enums.SourceEnum;
import com.msds.km.vo.Order;
import com.msds.km.vo.OrderlistEntity;

/**
 * 
 * <br>
 * <b>功能：</b>OrderService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface OrderService extends BaseService<OrderEntity> {

	/**
	 * 根基sn查询基础信息
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @return
	 * @return OrderEntity
	 */
	OrderEntity findBySn(String sn);

	/**
	 * 根基sn、会员ID查询基础信息
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @param memberId
	 * @return
	 * @return OrderEntity
	 */
	OrderEntity findBySn(String orderSn, Integer memberId);

	/**
	 * 查询订单详细信息，包括商品、工时、修理厂
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @param memberId
	 * @return
	 * @return Order
	 */
	Order findDetailedBySn(String orderSn, Integer memberId);

	/**
	 * 构建订单
	 * 
	 * @Description TODO
	 * @param memberEntity
	 *            会员
	 * @param memberModelId
	 *            会员车辆信息ID
	 * @param serviceId
	 *            服务code
	 * @param companyId
	 *            修理厂
	 * @param serviceTime
	 *            服务时间
	 * @param remark
	 *            备注
	 * @param paymentType
	 *            支付类型
	 * @param source
	 *            来源渠道
	 * @return
	 * @return Order
	 */
	Order build(MemberEntity memberEntity, Integer memberModelId,
			String serviceCode, Integer companyId, Date serviceTime,
			String remark, PaymentTypeEnum paymentType, SourceEnum source);

	/**
	 * 创建订单
	 * 
	 * @Description TODO
	 * @param sn
	 *            订单编号
	 * @param memberEntity
	 *            会员
	 * @param memberModelId
	 *            会员车辆信息ID
	 * @param serviceId
	 *            服务code
	 * @param companyId
	 *            修理厂
	 * @param serviceTime
	 *            服务时间
	 * @param remark
	 *            备注
	 * @param paymentType
	 *            支付类型
	 * @param source
	 *            来源渠道
	 * @return
	 * @return Order
	 * @throws Exception
	 */
	Order create(String sn, MemberEntity memberEntity, Integer memberModelId,
			String serviceCode, Integer companyId, Date serviceTime,
			String remark, PaymentTypeEnum paymentType, SourceEnum source)
			throws Exception;

	/**
	 * 订单日志记录
	 * 
	 * @Description TODO
	 * @param orderEntity
	 *            订单数据
	 * @param operationPerson
	 *            操作人
	 * @param operationDate
	 *            操作时间
	 * @param operationRemark
	 *            备注
	 * @return void
	 */
	public void addLog(OrderEntity orderEntity, String operationPerson,
			Date operationDate, String operationRemark);

	/***
	 * 通过条件查询订单
	 * 
	 * @param orderEntity
	 * @return
	 */
	public List<OrderlistEntity> findOrderList(BasePage pager)throws Exception;

	/**
	 * 通过ID查询订单信息
	 * 
	 * @param id
	 * @return
	 */
	public Order findDetailedById(String id);

	/**
	 * 支付ok
	 * 
	 * @Description TODO
	 * @param orderSn
	 * @param payment
	 * @return void
	 */
	void payment(String orderSn, PaymentEntity payment);

	/**
	 * 订单确认(后台使用)
	 * 
	 * @Description 如果生成配件单，推送B2B接口，发送邮件服务单
	 * @param orderSn
	 * @param partsFlag
	 *            是否生成配件单
	 * @param operationPerson
	 *            操作人
	 * @return String
	 * @throws Exception
	 */
	String confirm(String orderSn, boolean partsFlag, String operationPerson)
			throws Exception;

	/**
	 * 修改订单状态
	 * 
	 * @Description TODO
	 * @param orderSn
	 *            订单号
	 * @param orderState
	 *            订单状态
	 * @param operationPerson
	 *            操作人
	 * @return void
	 */
	void updateOrderState(String orderSn, OrderStateEnum orderState,
			String operationPerson);

	/**
	 * 返回服务和条件的订单列表
	 * 
	 * @Description 订单创建时间小于某个时间，并满足指定状态的
	 * @param orderState
	 *            订单状态
	 * @param date
	 *            时间
	 * @return
	 * @return List<OrderEntity>
	 */
	List<OrderEntity> findListByStateLtDate(OrderStateEnum orderState, Date date);

}
