package com.msds.km.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.msds.baseinfo.common.UserInfo;
import com.msds.km.CodeGenerator;
import com.msds.km.CodeType;
import com.msds.km.base.BaseController;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.DirectShopEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.RefundEntity;
import com.msds.km.entity.RefundLogEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.mapper.DirectShopMapper;
import com.msds.km.mapper.ReasonMapper;
import com.msds.km.service.CompanyService;
import com.msds.km.service.OrderLogService;
import com.msds.km.service.OrderService;
import com.msds.km.service.RefundLogService;
import com.msds.km.service.RefundService;
import com.msds.km.service.ReturnService;
import com.msds.km.service.ServiceCompanyService;
import com.msds.km.service.ServiceModelDetailService;
import com.msds.km.vo.Order;
import com.msds.km.vo.OrderlistEntity;
import com.msds.km.vo.Product;
import com.msds.open.api.OpenApiException;
import com.msds.util.DateUtils;
import com.msds.util.JsonUtils;
 
/**
 * 
 * <br>
 * <b>功能：</b>OrderController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 16:54:32 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/order") 
public class OrderController extends BaseController{
	
	@Autowired
	private OrderService orderService; 
	@Autowired
	private CompanyService companyService; 
	@Autowired
	private ServiceModelDetailService smdService; 
	@Autowired
	private OrderLogService orderLogService;
	@Autowired
    private DirectShopMapper directShopMapper;
	@Autowired
	private ServiceCompanyService serviceCompanyService; 
	@Autowired
    private ReasonMapper reasonMapper;
	@Autowired
	private ReturnService returnService;
	@Autowired
	private CodeGenerator codeGenerator;
	@Autowired
	private RefundService refundService;
	@Autowired
	private RefundLogService refundLogService;
	
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/order/order_list",null); 
	}
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	@ResponseBody
	public Object datalist(OrderEntity entity,HttpServletRequest request) throws Exception{
		List<OrderEntity> dataList = orderService.queryByList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	/**
	 * 修改订单信息
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody OrderEntity entity,HttpServletRequest request){
		Date date = new Date();
		try {
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			
				orderService.add(entity);
			
		}else{
			
			if(entity.getCompanyId()!=null){
				CompanyEntity companyEntity = companyService.findById(entity.getCompanyId());
				entity.setCompanyId(entity.getCompanyId());
				entity.setCompanyName(companyEntity.getName());
				entity.setCompanyAddress(companyEntity.getAddress());
			}
			entity.setModifyDate(date);
			orderService.update(entity);
			if(entity.getRemark()==null){
				entity.setRemark("");
			}
//			下单日志
			OrderEntity order = orderService.findById(entity.getId());
			if(entity.getServiceTime()!=null || entity.getCompanyId()!=null){
				entity.setRemark("订单修改");
			}
			if(entity.getPartsSn()!=null){
				entity.setRemark("修改配件单编号");
			}
			
			orderLogService.addLog(order, new UserInfo().getUser().getUserName(), new Date(), entity.getRemark());
		}
		} catch (Exception e) {
			logger.error("修改订单信息：updateOrder()方法报错", "订单ID："+entity.getId()+"用户"+new UserInfo().getUser().getId());
			e.printStackTrace();
		}
		return sendSuccessMessage();
	}
	
	/**
	 * 确认订单服务
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/affirmService", method = RequestMethod.POST)
	@ResponseBody
	public Object affirmService(@RequestBody OrderEntity entity,HttpServletRequest request){
		Date date = new Date();
		try {
			OrderEntity entity2 = orderService.findById(entity.getId());
			if(entity2.getOrderState()==3 || entity2.getOrderState()==5){
				entity.setSerivceFinishDate(new Date());
				entity.setModifyDate(date);
				orderService.update(entity);
				OrderEntity order = orderService.findById(entity.getId());
				orderLogService.addLog(order, new UserInfo().getUser().getUserName(), new Date(), "确认服务操作");
			}
		} catch (Exception e) {
			logger.error("save()方法报错", "订单ID："+entity.getId()+"用户"+new UserInfo().getUser().getId());
			e.printStackTrace();
		}
		return sendSuccessMessage();
	}
	
	/**
	 * 取消待付款的订单
	 */
	@RequestMapping(value = "/cancelOrderOfNoPay", method = RequestMethod.POST)
	@ResponseBody
	public Object cancelOrder(@RequestBody OrderEntity entity,HttpServletRequest request){
		Date date = new Date();
		try{
			
			entity.setModifyDate(date);
			orderService.update(entity);
//			下单日志
			OrderEntity order = orderService.findById(entity.getId());
			orderLogService.addLog(order, new UserInfo().getUser().getUserName(), new Date(), entity.getRemarkLog());
		} catch (Exception e) {
			logger.error("取消代付款对的订单方法报错cancelOrder()", "订单ID："+entity.getId()+"用户"+new UserInfo().getUser().getId());
			e.printStackTrace();
		}
		return sendSuccessMessage();
	}
	
	
	/**
	 * 修改服务时间和修理厂地址
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 *//*
	@RequestMapping(value = "/saveServiceTimeAndAddress", method = RequestMethod.POST)
	@ResponseBody
	public Object saveServiceTimeAndAddress(@RequestBody OrderEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
			entity.setCompanyId(entity.getId());
			entity.setModifyDate(date);
			orderService.update(entity);
		return sendSuccessMessage();
	}*/
	
	/**
	 * 获取数据
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	@ResponseBody
	public Object getId(String id,HttpServletRequest request) throws Exception{
		OrderEntity entity  = orderService.findById(id);
		if(entity  == null){
			return sendFailureMessage("没有找到对应的记录!");
		}
		return entity;
	}

	/**
	 * 删除数据
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(String[] id,String remark,Integer orderState,HttpServletRequest request) throws Exception{
		
		orderService.delete(id);
		
		return sendSuccessMessage();
	}
	/**
	 * 取消付过款的订单
	 * @param id
	 * @param remark
	 * @param orderState
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cancelOrder")
	@ResponseBody
	public Object cancelOrder(String id,String remark,Integer orderState,HttpServletRequest request){
		OrderEntity orderEntity;
		try {
			orderEntity = orderService.findById(id);
//		生成退款单
		RefundEntity entity = new RefundEntity();
		String sn = codeGenerator.getCode(CodeType.REFUND_SN_PREFIX, "",
				CodeTypeEnum.refund_code.getId());
		entity.setRefundSn(sn);
		entity.setCreateDate(new Date());
		entity.setMemberId(orderEntity.getMemberId());
		entity.setModifyDate(new Date());
		entity.setOperator(new UserInfo().getUser().getId());
		entity.setOrderSn(orderEntity.getOrderSn());
		entity.setPrice(orderEntity.getAmount());
		entity.setState(0);
		refundService.add(entity);
		
//		修改订单状态
		orderEntity.setOrderState(12);
		orderService.update(orderEntity);
		
//		取消订单日志
		orderLogService.addLog(orderEntity, new UserInfo().getUser().getUserName(), new Date(), remark);
//		退款单日志
		refundLogService.addLog(entity, new UserInfo().getUser().getUserName(), new Date());
		} catch (Exception e) {
			logger.error("cancelOrder()方法报错", "订单ID："+id+"用户"+new UserInfo().getUser().getId());
			e.printStackTrace();
		}
		return sendSuccessMessage();
	}
	/**
	 * 取消订单服务
	 * @param id
	 * @param remark
	 * @param flag
	 * @param request
	 * @return
	 */
	@RequestMapping("/cancelOrderService")
	@ResponseBody
	public Object cancelOrderService(String id,String remark,Integer flag,HttpServletRequest request){
		OrderEntity orderEntity;
		try {
			
			orderEntity = orderService.findById(id);
			
//			修改订单状态
			orderEntity.setOrderState(12);
			orderService.update(orderEntity);
//			生成退款单	
			RefundEntity entity = new RefundEntity();
			String sn = codeGenerator.getCode(CodeType.REFUND_SN_PREFIX, "",
				CodeTypeEnum.refund_code.getId());
			entity.setRefundSn(sn);
			entity.setCreateDate(new Date());
			entity.setMemberId(orderEntity.getMemberId());
			entity.setModifyDate(new Date());
			entity.setOperator(new UserInfo().getUser().getId());
			entity.setOrderSn(orderEntity.getOrderSn());
			entity.setPrice(orderEntity.getAmount());
			entity.setState(0);
			refundService.add(entity);
/*//			生成退货单
			if(flag!=null && flag==1){
				ReturnEntity returnEntity = new ReturnEntity();
				String sn1 = codeGenerator.getCode(CodeType.REFUND_SN_PREFIX, "",
				CodeTypeEnum.return_product.getId());
				returnEntity.setReturnSn(sn1);
				returnEntity.setCompanyId(orderEntity.getCompanyId());
				returnEntity.setCreateDate(new Date());
				returnEntity.setDirectShopId(orderEntity.getDirectShopId());
				returnEntity.setModifyDate(new Date());
				returnEntity.setOperator(new UserInfo().getUser().getId());
				returnEntity.setOrderSn(orderEntity.getOrderSn());
				returnEntity.setPartsReturnSn("");
				returnEntity.setStatus(0);
				returnEntity.setProductJson(orderEntity.getProductsJson());
				returnEntity.setProductJson(orderEntity.getProductsJson());
				
				returnEntity.setRemark(remark);
				returnService.add(returnEntity);
			}*/
		
//			退款日志
			RefundLogEntity refundEntity = new RefundLogEntity();
			refundEntity.setRefundSn(entity.getRefundSn());
			refundEntity.setCreateDate(new Date());
			refundEntity.setMemberId(entity.getMemberId());
			refundEntity.setModifyDate(new Date());
			refundEntity.setOperator(new UserInfo().getUser().getUserName());
			refundEntity.setOrderSn(orderEntity.getOrderSn());
			refundEntity.setPrice(orderEntity.getAmount());
			refundEntity.setState(0);
			refundLogService.add(refundEntity);
			
	//		取消订单日志
			orderLogService.addLog(orderEntity, new UserInfo().getUser().getUserName(), new Date(), remark);
			} catch (Exception e) {
				logger.error("cancelOrderService()方法报错", "报错订单ID"+id+"用户"+new UserInfo().getUser().getId());
				e.printStackTrace();
			}
			return sendSuccessMessage();
	}
	
	
	@RequestMapping("/findOrderList")
	@ResponseBody
	public Object findOrderList(OrderEntity orderEntity,HttpServletRequest request) throws Exception{
		if(orderEntity.getNowDate()!=null){
			orderEntity.setNowDate(DateUtils.getDayEnd(orderEntity.getNowDate()));
		}
		List<OrderlistEntity> dataList =orderService.findOrderList(orderEntity);
		return returnDataGrid(orderEntity.getPager().getRowCount(), dataList);
	}
	
	@RequestMapping("/findOrderInfo")
	public ModelAndView findOrderInfo(String id,String type,HttpServletRequest request) throws Exception{
		ModelAndView mav = orderInfo(id, "/km/order/order_info");
		return mav; 
	}
	
	@RequestMapping("/getOrderInfo")
	public ModelAndView getOrderInfo(String orderSn,String type,HttpServletRequest request) throws Exception{
		OrderEntity order = orderService.findBySn(orderSn);
		ModelAndView mav = orderInfo(String.valueOf(order.getId()), "/km/order/order_info");
		return mav; 
	}
	
	@RequestMapping("/editOrderInfo")
	public ModelAndView editOrderInfo(String id,String type,HttpServletRequest request) throws Exception{
		ModelAndView mav = orderInfo(id, "/km/order/order_edit");
		return mav; 
	}
	
	@RequestMapping("/findOrderProductList")
	@ResponseBody
	public Object findOrderProductList(OrderEntity orderEntity,HttpServletRequest request) throws Exception{
		
		Order order =orderService.findDetailedById(orderEntity.getId().toString());
		
		List<Product> productEntities= JsonUtils.toObject(order.getOrderEntity().getProductsJson(),
				new TypeReference<List<Product>>() {});
		
		return productEntities;
	}
	
	
	/**
	 * 通过服务类型查询厂商
	 * @throws Exception 
	 */
	@RequestMapping("/findCompanyByServiceCode")
	@ResponseBody
	private Object findCompanyByServiceCode(String serviceCode ,HttpServletRequest request) throws Exception{
		
		List<CompanyEntity> serviceCompanyEntities = companyService.findListByserviceCode(serviceCode);
		
		return returnDataGrid(20, serviceCompanyEntities);
	}
	
	public static BigDecimal mul(BigDecimal v1,Integer num, BigDecimal v2){ 
		if(v2==null){
			v2=new BigDecimal("1");
		}
		if(num==null){
			num=1;
		}
		BigDecimal b1 = new BigDecimal(v1.toString());   
		BigDecimal b3 = new BigDecimal(v2.toString());   
		BigDecimal bnum = new BigDecimal(num.toString());   
		
		return b1.multiply(b3).multiply(bnum);   
		} 
	
	public  ModelAndView orderInfo(String id , String urlStr) throws Exception{
		
		Order order =orderService.findDetailedById(id);
		ModelAndView mav = new ModelAndView(urlStr);
		
		
		mav.addObject("orderData", order);
		
		mav.addObject("showDate",DateUtils.getDate(DateUtils.addDay(order.getOrderEntity().getCreateDate(), 2)));
		
		return mav;
	}
	/**
	 * 确认订单
	 * @param orderSn
	 * @param flag
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/confirmOrder")
	@ResponseBody
	public Object confirmOrder( String orderSn, String flag,HttpServletRequest request){
		boolean partsFlag=false;
		if("1".equals(flag)){
			partsFlag=true;
		}
		try {
			orderService.confirm(orderSn, partsFlag,new UserInfo().getUser().getUserName());
		} catch (OpenApiException e) {
			logger.error("confirmOrder()方法报错", "订单号："+orderSn+"用户"+new UserInfo().getUser().getId());
			return sendFailureMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sendSuccessMessage();
	} 
	
	
}