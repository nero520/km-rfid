package com.msds.km.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.km.base.BaseController;
import com.msds.km.entity.ModelEntity;
import com.msds.km.service.ModelService;
 
/**
 * 
 * <br>
 * <b>功能：</b>ModelController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-08-06 11:43:09 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/model") 
public class ModelController extends BaseController{
	
	private final static Logger log= Logger.getLogger(ModelController.class);
	
	@Autowired
	private ModelService modelService; 
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/model/model_list",null); 
	}
	
	/**
	 * 跳转tanchu列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ref") 
	public ModelAndView ref(HttpServletRequest request) throws Exception{
		return forword("/km/model/model_ref_list",null); 
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
	public Object datalist(ModelEntity entity,HttpServletRequest request) throws Exception{
		List<ModelEntity> dataList = modelService.queryByList(entity);
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
	@RequestMapping("/treeList")
	@ResponseBody
	public Object treeList(ModelEntity entity,HttpServletRequest request) throws Exception{
		entity.setLevelList(Arrays.asList(new Integer[]{1,2,3}));
		List<ModelEntity> dataList = modelService.findListByCondition(entity);
		return dataList;
	}
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/lazyTreeList")
	@ResponseBody
	public Object lazyTreeList(Integer id,HttpServletRequest request) throws Exception{
		if(id == null){
			id = -1;
		}
		ModelEntity entity = new ModelEntity();
		entity.setPid(id);
		entity.setLevelList(Arrays.asList(new Integer[]{1,2,3}));
		List<ModelEntity> dataList = modelService.findListByCondition(entity);
		if(dataList != null && !dataList.isEmpty()){
			if(dataList.get(0).getLevel() < 3){
				for(ModelEntity mapEntity : dataList){
					mapEntity.setExpanded(false);
					mapEntity.setIsLeaf(false);
				}
			}
		}
		return dataList;
	}
	
	@RequestMapping("/getModelInfos")
	@ResponseBody
	public Object getModelInfos(ModelEntity model) throws Exception{
		model.setLevel(1);
		model.setIs_show(1);
		List<ModelEntity> list = modelService.getModelList(model);
		return returnDataGrid(0, list);
	}
	
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refDataList")
	@ResponseBody
	public Object refDatalist(ModelEntity entity,HttpServletRequest request) throws Exception{
//		entity.setLevel(3);
		entity.setLevelList(Arrays.asList(new Integer[]{3}));
		List<ModelEntity> dataList = modelService.queryByList(entity);
		if(dataList != null && !dataList.isEmpty()){
			for(ModelEntity modelEntity : dataList){
				
				ModelEntity parentEntity2 = modelService.findById(modelEntity.getPid());
				if(parentEntity2 != null){
					modelEntity.setShopName(parentEntity2.getName());
					ModelEntity parentEntity1 = modelService.findById(parentEntity2.getPid());
					if(parentEntity1 != null){
						modelEntity.setBrandName(parentEntity1.getName());
					}
				}
				
			}
		}
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
	public Object save(@RequestBody ModelEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			modelService.add(entity);
		}else{
			entity.setModifyDate(date);
			modelService.update(entity);
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
		ModelEntity entity  = modelService.findById(id);
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
		modelService.delete(id);
		return sendSuccessMessage();
	}

}
