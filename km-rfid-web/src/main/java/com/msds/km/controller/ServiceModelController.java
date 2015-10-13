package com.msds.km.controller;

import java.math.BigDecimal;
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
import com.msds.km.entity.ServiceModelEntity;
import com.msds.km.service.ServiceModelService;
import com.msds.km.vo.ServiceModelVo;
 
/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/serviceModel") 
public class ServiceModelController extends BaseController{
	
	
	
	@Autowired
	private ServiceModelService serviceModelService; 
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/serviceModel/serviceModel_list",null); 
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
	public Object datalist(ServiceModelEntity entity,HttpServletRequest request) throws Exception{
		List<ServiceModelVo> dataList = serviceModelService.queryServiceModelByList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
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
	public Object save(@RequestBody ServiceModelEntity entity, HttpServletRequest request) throws Exception{
		
		if(entity != null){
			if(entity.getServiceCode() == null || "" == entity.getServiceCode()){
				return sendFailureMessage("请选择服务");
			}
			
			if(entity.getMileage() == null || entity.getMileage()<0 || entity.getMileage()>600000){
				return sendFailureMessage("里程范围为0~600000km");
			}
			
			if(entity.getPrice() == null || (entity.getPrice().compareTo(new BigDecimal(0))==-1)||(entity.getPrice().compareTo(new BigDecimal(99999999))==1)){
				return sendFailureMessage("总价范围为0~99999999元");
			}
		}
		if(entity.getModelId() == null || "" == entity.getModelId()){
			entity.setModelId("-1");//解决前端控件的问题
		}
		UserInfo userinfo = new UserInfo();
		Integer operatorId = userinfo.getUser() != null ? userinfo.getUser().getId():null;
		entity.setOperator(operatorId);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			serviceModelService.batchInsertLists(entity);
		}else{
			Date date = new Date();
			entity.setModifyDate(date);
			serviceModelService.batchUpdateLists(entity);
		}
		return sendSuccessMessage();
	}
	
	private Boolean checkServiceModel(ServiceModelEntity entity){
		
		if(entity != null){
			if(entity.getServiceCode() == null){
				
			}
		}
		
		return false;
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
		ServiceModelEntity entity  = serviceModelService.findSmById(id);
		if(entity  == null){
			return sendFailureMessage("没有找到对应的记录!");
		}
		return entity;
	}
	
	@RequestMapping("/getModelInfo")
	@ResponseBody
	public Object getModelInfo(HttpServletRequest request) throws Exception{
		ServiceModelEntity entity  = serviceModelService.findById(null);
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
		serviceModelService.delete(id);
		return sendSuccessMessage();
	}

}
