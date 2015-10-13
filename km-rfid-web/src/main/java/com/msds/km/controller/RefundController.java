package com.msds.km.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.baseinfo.common.UserInfo;
import com.msds.km.base.BaseController;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.RefundEntity;
import com.msds.km.entity.RefundLogEntity;
import com.msds.km.service.OrderLogService;
import com.msds.km.service.OrderService;
import com.msds.km.service.RefundLogService;
import com.msds.km.service.RefundService;
import com.msds.km.vo.RefundList;
import com.msds.util.DateUtils;
 
/**
 * 
 * <br>
 * <b>功能：</b>RefundController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 16:54:32 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/refund") 
public class RefundController extends BaseController{
	
	@Autowired
	private RefundService refundService; 
	@Autowired
	private RefundLogService refundLogService; 
	@Autowired
	private OrderService orderService; 
	@Autowired
	private OrderLogService orderLogService;
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/refund/refund_list",null); 
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
	public Object datalist(RefundList entity,HttpServletRequest request) throws Exception{
		if(entity.getNowDate()!=null){
			entity.setNowDate(DateUtils.getDayEnd(entity.getNowDate()));
		}
		List<RefundList> dataList = refundService.refundList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	@RequestMapping("/refundInfo")
	public  ModelAndView refundInfo(RefundList entity ,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/km/refund/refund_details");
		List<RefundList> dataList = refundService.refundList(entity);
		RefundList refundList=null;
		if(dataList!=null && dataList.get(0)!=null){
			 refundList = dataList.get(0);
		}
		mav.addObject("refund", refundList);
		return mav;
	}
	
	/**
	 * 添加或修改数据
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody RefundEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			refundService.add(entity);
		}else{
			OrderEntity orderEntity2=orderService.findBySn(entity.getOrderSn());
			
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setId(orderEntity2.getId());
			orderEntity.setOrderState(13);
			orderService.update(orderEntity);
			entity.setModifyDate(date);
			refundService.update(entity);
			
//			退款单日志
			RefundEntity t =refundService.findById(entity.getId());
			
			refundLogService.addLog(t, new UserInfo().getUser().getUserName(), new Date());
		}
		return sendSuccessMessage();
	}
	
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
		RefundEntity entity  = refundService.findById(id);
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
	public Object delete(String[] id,HttpServletRequest request) throws Exception{
		refundService.delete(id);
		return sendSuccessMessage();
	}

}
