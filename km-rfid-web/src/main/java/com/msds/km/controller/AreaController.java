package com.msds.km.controller;

import java.util.ArrayList;
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

import com.msds.common.ComboBox;
import com.msds.km.base.BaseController;
import com.msds.km.entity.AreaEntity;
import com.msds.km.service.AreaService;

/**
 * 
 * <br>
 * <b>功能：</b>AreaController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 16:54:32 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {

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
	public ModelAndView list(HttpServletRequest request) throws Exception {
		return forword("/km/area/area_list", null);
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
	public Object datalist(AreaEntity entity, HttpServletRequest request)
			throws Exception {
		List<AreaEntity> dataList = areaService.queryByList(entity);
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
	public Object save(@RequestBody AreaEntity entity,
			HttpServletRequest request) throws Exception {
		Date date = new Date();
		if (entity.getId() == null
				|| StringUtils.isBlank(entity.getId().toString())) {
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			areaService.add(entity);
		} else {
			entity.setModifyDate(date);
			areaService.update(entity);
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
	public Object getId(String id, HttpServletRequest request) throws Exception {
		AreaEntity entity = areaService.findById(id);
		if (entity == null) {
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
	public Object delete(String[] id, HttpServletRequest request)
			throws Exception {
		areaService.delete(id);
		return sendSuccessMessage();
	}
	
	/**
	 * combobox数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getProvinceComboboxList")
	@ResponseBody
	public Object getProvinceComboboxList(HttpServletRequest request) throws Exception{
		List<AreaEntity> dataList = areaService.getProvinceList();
		List<ComboBox> comboBoxs = new ArrayList<ComboBox>();
		for (AreaEntity data : dataList) {
			ComboBox box = new ComboBox(data.getId(), data.getName());
			comboBoxs.add(box);
		}
		return comboBoxs;
	}
	
	@RequestMapping("/getCityComboboxList")
	@ResponseBody
	public Object getCityComboboxList(Integer provinceId,HttpServletRequest request) throws Exception{
		if(provinceId == null || provinceId == 0)
			provinceId = -1;
		List<AreaEntity> dataList = areaService.getCityList(provinceId);
		List<ComboBox> comboBoxs = new ArrayList<ComboBox>();
		for (AreaEntity data : dataList) {
			ComboBox box = new ComboBox(data.getId(), data.getName());
			comboBoxs.add(box);
		}
		return comboBoxs;
	}
	
	@RequestMapping("/getAreaComboboxList")
	@ResponseBody
	public Object getAreaComboboxList(Integer cityId,HttpServletRequest request) throws Exception{
		if(cityId == null || cityId == 0)
			cityId = -1;
		List<AreaEntity> dataList = areaService.getAreaList(cityId);
		List<ComboBox> comboBoxs = new ArrayList<ComboBox>();
		for (AreaEntity data : dataList) {
			ComboBox box = new ComboBox(data.getId(), data.getName());
			comboBoxs.add(box);
		}
		return comboBoxs;
	}
	
	@RequestMapping("/getCityCom")
	@ResponseBody
	public Object getCityCom(Integer provinceId,HttpServletRequest request) throws Exception{
		if(provinceId == null || provinceId == 0)
			provinceId = -1;
		List<AreaEntity> dataList = areaService.getCityList(provinceId);
		List<ComboBox> comboBoxs = new ArrayList<ComboBox>();
		for (AreaEntity data : dataList) {
			ComboBox box = new ComboBox(data.getId(), data.getName());
			comboBoxs.add(box);
		}
		return comboBoxs;
	}

}
