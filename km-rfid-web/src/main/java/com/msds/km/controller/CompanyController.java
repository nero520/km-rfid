package com.msds.km.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.km.base.BaseController;
import com.msds.km.entity.AreaEntity;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.ServiceCompanyEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.service.AreaService;
import com.msds.km.service.CompanyService;
import com.msds.km.service.ServiceCompanyService;
import com.msds.km.service.ServiceService;
 
/**
 * 
 * <br>
 * <b>功能：</b>CompanyController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 16:54:31 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/company") 
public class CompanyController extends BaseController{
	
	@Autowired
	private CompanyService companyService; 
	
	@Autowired
	private ServiceCompanyService serviceCompanyService; 
	
	@Autowired
	private ServiceService serviceService; 
	
	
	@Autowired
	private AreaService areaService;

	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/company/company_list",null); 
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
	public Object datalist(CompanyEntity entity,HttpServletRequest request) throws Exception{
		List<CompanyEntity> dataList = companyService.queryByList(entity);
		
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
//	模糊查询修理厂列表
	@RequestMapping("/likeDatalist")
	@ResponseBody
	public Object likeDatalist(CompanyEntity entity,HttpServletRequest request) throws Exception{
		
		if(entity.getNowDate()!=null){
			Calendar   calendar   =   new   GregorianCalendar(); 
		      calendar.setTime(entity.getNowDate()); 
		      calendar.add(calendar.DATE,1);
			entity.setNowDate(calendar.getTime());
		}
		List<CompanyEntity> dataList = companyService.findCompanyList(entity);
		
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
	public Object save(@RequestBody CompanyEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			if(entity.getUsername()==null){
				return null;
			}
			CompanyEntity entity2 = new CompanyEntity();
			entity2.setUsername(entity.getUsername());
			List<CompanyEntity> list = companyService.findListByCondition(entity2);
			if(list!=null && list.size()>0){
				return "defeated";
			}
			AreaEntity areaEntityP = areaService.findById(entity.getProvince());
			AreaEntity areaEntityC = areaService.findById(entity.getCity());
			AreaEntity areaEntityA = areaService.findById(entity.getArea());
			
			entity.setFullAddress(areaEntityP.getName()+areaEntityC.getName()+areaEntityA.getName()+entity.getAddress());
			entity.setPassword(DigestUtils.md5Hex(entity.getPassword()));
			entity.setOfficeHours(entity.getStartDate()+"-"+entity.getOverDate());
			entity.setLockState(2);
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			companyService.add(entity);
			return "success";
		}else{
			entity.setModifyDate(date);
			entity.setOfficeHours(entity.getStartDate()+"-"+entity.getOverDate());
			companyService.update(entity);
			return "success";
		}
	
	}
	
	/**
	 *锁定修理厂服务
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/lockCompanyService", method = RequestMethod.POST)
	@ResponseBody
	public Object lockCompanyService(@RequestBody CompanyEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			return null;
		}else{
			entity.setModifyDate(date);
			companyService.update(entity);
			return "success";
		}
	
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
		CompanyEntity entity  = companyService.findById(id);
		if(entity  == null){
			return sendFailureMessage("没有找到对应的记录!");
		}
		entity.setPassword("");
		String str=entity.getOfficeHours();
		String[] sre=str.split("-");
		entity.setStartDate(sre[0]);
		entity.setOverDate(sre[1]);
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
		companyService.delete(id);
		return sendSuccessMessage();
	}
	
	
	@RequestMapping("/updatePassword")
	@ResponseBody
	public Object updatePassword(@RequestBody CompanyEntity entity,HttpServletRequest request) throws Exception{
		
		if(entity!=null && entity.getPassword()!=null){
			CompanyEntity t = new CompanyEntity();
			t.setId(entity.getId());
			t.setPassword(DigestUtils.md5Hex(entity.getPassword()));
			companyService.update(t);
			return "success";
		}
		return "defeated";
	}
	
	@RequestMapping("/findCompService")
	@ResponseBody
	public Object findCompService(Integer id,HttpServletRequest request) throws Exception{
		
		ServiceCompanyEntity t = new ServiceCompanyEntity();
		t.setCompanyId(id);
		
		List<ServiceCompanyEntity> companyEntities = serviceCompanyService.findListByCondition(t);
		
		return companyEntities;
	}
	
	@RequestMapping("/findService")
	@ResponseBody
	public Object findService(Integer id , HttpServletRequest request) throws Exception{
		
		List<ServiceEntity> companyEntities = serviceService.findByCompany_id(id);
		
		return companyEntities;
	}
}
