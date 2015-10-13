package com.msds.km.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.km.base.BaseController;
import com.msds.km.entity.SettleAccountEntity;
import com.msds.km.entity.SettleAccountItemEntity;
import com.msds.km.enums.SettleStateEnum;
import com.msds.km.service.SettleAccountItemService;
import com.msds.km.service.SettleAccountService;
 
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
@RequestMapping("/settleAccount") 
public class SettleAccountController extends BaseController{
	
	@Autowired
	private SettleAccountService settleAccountService;
	@Autowired
	private SettleAccountItemService settleAccountItemService; 
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(String settleSn,HttpServletRequest request) throws Exception{
		return forword("/km/settleAccount/settleAccount_list",null); 
	}
	
	/**
	 * 对账单列表
	 * @param settleAccountEntity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findSettleAccountList")
	@ResponseBody
	public Object findSettleAccountList(SettleAccountEntity settleAccountEntity,HttpServletRequest request) throws Exception{
		List<SettleAccountEntity> dataList =settleAccountService.findSettleAccountList(settleAccountEntity);
		return returnDataGrid(settleAccountEntity.getPager().getRowCount(), dataList);
	}
	
	/**
	 * 对账单列表
	 * @param settleAccountEntity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveBill")
	@ResponseBody
	public Object saveBill(@RequestBody SettleAccountEntity settleAccountEntity,HttpServletRequest request) throws Exception{
		settleAccountService.saveBill(settleAccountEntity);
		return sendSuccessMessage();
	}
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public ModelAndView dataList(SettleAccountEntity settleAccountEntity,HttpServletRequest request) throws Exception{
		Map<String, Object> map = new HashMap<>();
		SettleStateEnum settleStateName = SettleStateEnum.getEnumById(settleAccountEntity.getSettleState());
		settleAccountEntity.setSettleStateName(settleStateName.getName());
		map.put("settleAccount", settleAccountEntity);
		return forword("/km/settleAccount/settleAccountItem_list",map); 
	}
	
	/**
	 * 列表数据
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findSettleAccountItemList")
	@ResponseBody
	public Object findSettleAccountItemList(SettleAccountItemEntity entity,HttpServletRequest request) throws Exception{
		List<SettleAccountItemEntity> dataList = settleAccountItemService.queryByListAndOrder(entity);
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
	public Object save(@RequestBody SettleAccountEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			settleAccountService.add(entity);
		}else{
			entity.setModifyDate(date);
			settleAccountService.update(entity);
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
		SettleAccountEntity entity  = settleAccountService.findById(id);
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
		settleAccountService.delete(id);
		return sendSuccessMessage();
	}

}
