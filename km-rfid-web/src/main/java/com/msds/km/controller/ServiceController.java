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
import com.msds.km.entity.ServiceEntity;
import com.msds.km.service.ServiceService;
 
/**
 * 
 * <br>
 * <b>功能：</b>ServiceController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:15 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/service") 
public class ServiceController extends BaseController{
	
	@Autowired
	private ServiceService serviceService; 
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/service/service_list",null); 
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
	public Object datalist(ServiceEntity entity,HttpServletRequest request) throws Exception{
		List<ServiceEntity> dataList = serviceService.queryByList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findLikedatalist")
	@ResponseBody
	public Object findLikedatalist(ServiceEntity entity,HttpServletRequest request) throws Exception{
		List<ServiceEntity> dataList = serviceService.findServiceList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	
	@RequestMapping("/dataSCodeList")
	@ResponseBody
	public Object dataSCodeList(ServiceEntity entity,HttpServletRequest request) throws Exception{
		List<ServiceEntity> dataList = serviceService.queryByList(entity);
		return returnDataGrid(0, dataList);
	}	
	
	
	/**
	 * 添加服务或修改数据
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody ServiceEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCategoryId(0);
			entity.setOperator(new UserInfo().getUser().getId());
			entity.setState(1);
			entity.setCategoryName("保养");
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			serviceService.add(entity);
		}else{
			entity.setModifyDate(date);
			serviceService.update(entity);
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
		ServiceEntity entity  = serviceService.findById(id);
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
		serviceService.delete(id);
		return sendSuccessMessage();
	}
	
	
}
