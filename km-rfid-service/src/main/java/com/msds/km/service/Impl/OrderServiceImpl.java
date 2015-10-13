package com.msds.km.service.Impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.common.CommonAttributes;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.PaymentEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.enums.OrderStateEnum;
import com.msds.km.enums.PaymentMethodEnum;
import com.msds.km.enums.PaymentStateEnum;
import com.msds.km.enums.PaymentTypeEnum;
import com.msds.km.enums.ServiceMethodEnum;
import com.msds.km.enums.SourceEnum;
import com.msds.km.mapper.CompanyMapper;
import com.msds.km.mapper.LaborcostMapper;
import com.msds.km.mapper.MemberModelMapper;
import com.msds.km.mapper.OrderMapper;
import com.msds.km.mapper.ServiceMapper;
import com.msds.km.service.ModelService;
import com.msds.km.service.OrderLogService;
import com.msds.km.service.OrderService;
import com.msds.km.service.ServiceModelService;
import com.msds.km.vo.Laborcost;
import com.msds.km.vo.Order;
import com.msds.km.vo.OrderlistEntity;
import com.msds.km.vo.Product;
import com.msds.km.vo.ServiceMode;
import com.msds.mail.MailService;
import com.msds.open.api.OpenApiService;
import com.msds.util.DateUtils;
import com.msds.util.ExcelTemplateUtils;
import com.msds.util.JsonUtils;

/**
 * 
 * <br>
 * <b>功能：</b>OrderService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity> implements
		OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private LaborcostMapper laborcostMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private ServiceMapper serviceMapper;
	@Autowired
	private MemberModelMapper memberModelMapper;
	@Resource(name = "serviceModelService")
	private ServiceModelService serviceModelService;
	@Resource(name = "orderLogService")
	private OrderLogService orderLogService;
	@Resource(name = "mailServiceImpl")
	private MailService mailService;
	@Value("${order.file.dir}")
	private String orderFileDir;
	@Value("${order.toMail}")
	private String orderToMail;
	@Resource(name = "openApiService")
	private OpenApiService openApiService;
	@Resource(name = "modelService")
	private ModelService modelService;

	public OrderMapper baseMapper() {
		return orderMapper;
	}

	@Override
	public OrderEntity findBySn(String orderSn) {
		return orderMapper.findBySn(orderSn);
	}

	@Override
	public OrderEntity findBySn(String orderSn, Integer memberId) {
		return orderMapper.findBySnMemberId(orderSn, memberId);
	}

	@Override
	public Order findDetailedBySn(String orderSn, Integer memberId) {
		OrderEntity orderEntity = orderMapper.findBySnMemberId(orderSn,
				memberId);
		if (orderEntity != null) {
			CompanyEntity companyEntity = companyMapper.findById(orderEntity
					.getCompanyId());
			ServiceEntity serviceEntity = serviceMapper.findByCode(orderEntity
					.getServiceCode());
			// List<Product> productList = JsonUtils.toObject(
			// orderEntity.getProductsJson(),
			// new TypeReference<List<Product>>() {
			// });
			// List<Laborcost> laborcostlist = JsonUtils.toObject(
			// orderEntity.getLaborcostJson(),
			// new TypeReference<List<Laborcost>>() {
			// });
			Order order = new Order();
			order.setCompanyEntity(companyEntity);
			order.setOrderEntity(orderEntity);
			order.setServiceEntity(serviceEntity);
			// order.setProductList(productList);
			// order.setLaborcostlist(laborcostlist);
			return order;
		}
		return null;
	}

	@Override
	public Order build(MemberEntity memberEntity, Integer memberModelId,
			String serviceCode, Integer companyId, Date serviceTime,
			String remark, PaymentTypeEnum paymentType, SourceEnum source) {

		Assert.notNull(memberEntity);
		Assert.notNull(memberModelId);
		Assert.notNull(serviceCode);
		Assert.notNull(companyId);
		// 订单信息
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setRemark(remark);
		orderEntity.setMemberId(memberEntity.getId());
		orderEntity.setContact(memberEntity.getName());
		orderEntity.setPhone(memberEntity.getPhone());
		orderEntity.setCompanyId(companyId);
		orderEntity.setPaymentType(paymentType.getId());
		orderEntity.setOrderState(OrderStateEnum.ORDER_WAIT_PAY.getId());
		orderEntity.setPaymentState(PaymentStateEnum.UNPAID.getId());
		orderEntity.setSource(source.getId());

		orderEntity.setDirectShopId("");// TODO

		MemberModelEntity memberModelEntity = memberModelMapper
				.findById(memberModelId);
		if (memberModelEntity == null) {
			logger.error("会员车型数据错误,memberModelId:{}", memberModelId);
			return null;
		}
		ServiceMode serviceMode = serviceModelService.findDetailed(serviceCode,
				memberModelEntity.getModelId());
		if (serviceMode == null) {
			logger.error("服务车型数据错误,serviceCode:{},modelId:{}", serviceCode,
					memberModelEntity.getModelId());
			return null;
		}
		orderEntity.setModelId(memberModelEntity.getModelId());
		orderEntity.setServiceCode(serviceCode);

		Order order = new Order();
		orderEntity.setServiceName(serviceMode.getServiceEntity()
				.getServiceName());
		orderEntity.setPrice(serviceMode.getServiceModelEntity().getPrice());
		orderEntity.setAmount(serviceMode.getServiceModelEntity().getPrice());
		// orderEntity.setProductsJson(serviceMode.getProductsJson());
		// orderEntity.setLaborcostJson(serviceMode.getLaborcostsJson());
		order.setLaborcostlist(serviceMode.getLaborcostlist());
		order.setProductList(serviceMode.getProductList());

		orderEntity.setServiceTime(serviceTime);
		orderEntity.setLicense(memberModelEntity.getRegion()
				+ memberModelEntity.getLicense());
		orderEntity.setMileage(memberModelEntity.getMileage());
		orderEntity.setVin(memberModelEntity.getVin());
		orderEntity.setBuyDate(memberModelEntity.getBuyDate());
		orderEntity.setModelGroupName(memberModelEntity.getModelGroupName());
		Date date = new Date();
		if (paymentType != null && paymentType == PaymentTypeEnum.online) {
			orderEntity.setInvalidDate((DateUtils.addHour(date,
					CommonAttributes.ORDER_INVALID_DATE)));
		}
		// order.setCompany(companyMapper.findById(companyId));
		CompanyEntity companyEntity = companyMapper.findById(companyId);
		companyEntity.setPassword(null);
		orderEntity.setCompanyName(companyEntity.getName());
		orderEntity.setCompanyAddress(companyEntity.getFullAddress());
		orderEntity.setCompanyPhone(companyEntity.getContactsPhone());
		order.setOrderEntity(orderEntity);

		String logo = modelService.findLogoById(orderEntity.getModelId());
		order.setModelLogo(logo);
		order.setCompanyLogo(companyEntity.getDoorPic());
		order.setCompanyEntity(companyEntity);
		return order;
	}

	/**
	 * 生成订单
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Order create(String sn, MemberEntity memberEntity,
			Integer memberModelId, String serviceCode, Integer companyId,
			Date serviceTime, String remark, PaymentTypeEnum paymentType,
			SourceEnum source) throws Exception {

		Assert.hasText(sn);
		Assert.notNull(serviceTime);

		Order order = this.build(memberEntity, memberModelId, serviceCode,
				companyId, serviceTime, remark, paymentType, source);
		if (order == null) {
			return null;
		}
		OrderEntity orderEntity = order.getOrderEntity();
		orderEntity.setOrderSn(sn);
		orderEntity.setProductsJson(JsonUtils.toJson(order.getProductList()));
		orderEntity
				.setLaborcostJson(JsonUtils.toJson(order.getLaborcostlist()));
		Date date = new Date();
		orderEntity.setCreateDate(date);
		orderEntity.setModifyDate(date);
		orderEntity.setServiceMethod(ServiceMethodEnum.store.getId());
		orderMapper.add(orderEntity);
		// 日志
		this.addLog(order.getOrderEntity(), "客户", date, "客户下单");
		return order;
	}

	/**
	 * 通过条件查询订单
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<OrderlistEntity> findOrderList(BasePage page) throws Exception {
		Integer rowCount = orderMapper.findOrderCount(page);
		page.getPager().setRowCount(rowCount);
		Assert.notNull(page);
		List<OrderlistEntity> list = orderMapper.findOrderList(page);

		return list;
	}

	@Override
	public void payment(String orderSn, PaymentEntity payment) {
		Assert.notNull(orderSn);
		Assert.notNull(payment);

		OrderEntity orderEntity = orderMapper.lockBySn(orderSn);

		orderEntity.setInvalidDate(null);
		orderEntity.setOrderState(OrderStateEnum.ORDER_WAIT_CONFIRM.getId());
		orderEntity.setPaymentState(PaymentStateEnum.PAID.getId());
		orderEntity.setPaymentDate(new Date());
		orderEntity.setPaymentMethod(PaymentMethodEnum.getEnumByName(
				payment.getPaymentPluginId()).getId());
		orderMapper.paymentConfirm(orderEntity);

		this.addLog(orderEntity, "客户", new Date(), "客户支付确认");
	}

	@Override
	public void addLog(OrderEntity orderEntity, String operationPerson,
			Date operationDate, String operationRemark) {
		orderLogService.addLog(orderEntity, operationPerson, operationDate,
				operationRemark);
	}

	@Override
	public Order findDetailedById(String id) {

		OrderEntity orderEntity = orderMapper.findById(id);

		/*
		 * String serviceDate=orderEntity.getServiceTime().toString(); String []
		 * serviceDates=serviceDate.split(" "); for (int i = 0; i <
		 * serviceDates.length; i++) { if(serviceDates[i].equals("09:00:00")){
		 * orderEntity.setHalfDay("1"); } }
		 */
		MemberModelEntity memberModelEntity = memberModelMapper
				.findByMemberIdModelId(orderEntity.getMemberId(),
						orderEntity.getModelId());

		CompanyEntity companyEntity = companyMapper.findById(orderEntity
				.getCompanyId());
		List<Product> productList = JsonUtils.toObject(
				orderEntity.getProductsJson(),
				new TypeReference<List<Product>>() {
				});
		List<Laborcost> laborcostlist = JsonUtils.toObject(
				orderEntity.getLaborcostJson(),
				new TypeReference<List<Laborcost>>() {
				});
		Order order = new Order();
		order.setMemberModelEntity(memberModelEntity);
		order.setOrderEntity(orderEntity);
		order.setCompanyEntity(companyEntity);
		order.setProductList(productList);
		order.setLaborcostlist(laborcostlist);

		return order;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String confirm(String orderSn, boolean partsFlag,
			String operationPerson) throws Exception {
		OrderEntity orderEntity = orderMapper.lockBySn(orderSn);
		// 待确认状态可确认
		if (orderEntity != null
				&& OrderStateEnum.ORDER_WAIT_CONFIRM.getId() == orderEntity
						.getOrderState()) {
			orderEntity.setPartsState(1);
			orderEntity.setOrderState(OrderStateEnum.ORDER_WAIT_SERVE.getId());
			if (partsFlag) {
				List<Product> productList = JsonUtils.toObject(
						orderEntity.getProductsJson(),
						new TypeReference<List<Product>>() {
						});
				if (productList != null && !productList.isEmpty()) {
					// B2B接口
					String customerId = null;
					CompanyEntity companyEntity = companyMapper
							.findById(orderEntity.getCompanyId());
					if (companyEntity != null) {
						customerId = companyEntity.getOutId();
					}
					String partsSn = openApiService.addOrder(customerId,
							productList, null);
					orderEntity.setPartsSn(partsSn);
					orderMapper.updateStateAndPartsSn(orderEntity);
					orderLogService.addLog(orderEntity, operationPerson,
							new Date(), "确认订单");
					// 生成订单文件
					if (StringUtils.isNotBlank(partsSn)) {
						Map<String, Object> map = new HashMap<>();
						map.put("orderSn", orderEntity.getOrderSn());
						map.put("serviceName", orderEntity.getServiceName());
						map.put("serviceTime", orderEntity.getServiceTime());
						map.put("phone", orderEntity.getPhone());
						map.put("contact", orderEntity.getContact());
						map.put("license", orderEntity.getLicense());
						MemberModelEntity memberModelEntity = memberModelMapper
								.findByMemberIdModelId(
										orderEntity.getMemberId(),
										orderEntity.getModelId());
						if (memberModelEntity != null) {
							map.put("byDate", memberModelEntity.getBuyDate());
							map.put("vin", memberModelEntity.getVin());
							map.put("mileage", memberModelEntity.getMileage());
							map.put("modelGroupName",
									memberModelEntity.getModelGroupName());
						}
						map.put("productList", productList);
						String fileName = orderSn + ".xls";
						String fileDir = orderFileDir + fileName;
						try {
							ExcelTemplateUtils.doExcel(
									CommonAttributes.ORDER_EXPORT_TEMPLATE,
									map, new FileOutputStream(fileDir));
						} catch (FileNotFoundException e) {
							logger.error("订单文件生成路径未创建(order.file.dir)");
							e.printStackTrace();
							// throw e;//TODO 对接B2B已经成功,后续失败不予处理,手动后续解决
						} catch (Exception e) {
							logger.error("订单文件生成错误,SN:{}", orderSn);
							e.printStackTrace();
							// throw e;//TODO 对接B2B已经成功,后续失败不予处理,手动后续解决
						}
						// 邮件
						Map<String, String> fileMap = new HashMap<>();
						fileMap.put(fileName, fileDir);
						try {
							mailService.send(orderToMail, "康民O2O服务订单",
									"康民O2O车主服务平台: 订单详细信息详见附件，谢谢", true,
									fileMap, false);
						} catch (Exception e) {
							logger.error("订单服务邮件发送失败,SN:{}", orderSn);
							e.printStackTrace();
							// throw e;//TODO 对接B2B已经成功,后续失败不予处理,手动后续解决
						}
					}
				} else {
					logger.warn("此订单无商品信息,不需要生成配件单,sn:{}", orderSn);
				}
			} else {
				orderMapper.updateStateAndPartsSn(orderEntity);
				orderLogService.addLog(orderEntity, operationPerson,
						new Date(), "确认订单");
			}
		}
		return null;
	}

	@Override
	public void updateOrderState(String orderSn, OrderStateEnum orderState,
			String operationPerson) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderSn(orderSn);
		orderEntity.setOrderState(orderState.getId());
		orderMapper.updateStateBySn(orderEntity);
		orderLogService.addLog(orderEntity, operationPerson, new Date(),
				"修改订单状态");

	}

	@Override
	public List<OrderEntity> findListByStateLtDate(OrderStateEnum orderState,
			Date date) {
		return orderMapper.findListByStateLtDate(orderState.getId(), date);
	}
}
