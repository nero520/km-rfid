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

import com.msds.km.CodeGenerator;
import com.msds.km.CodeType;
import com.msds.km.base.BaseController;
import com.msds.km.entity.RfidEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.service.RfidService;
 
/**
 * 
 * <br>
 * <b>功能：</b>RfidController<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-10 13:29:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
@Controller
@RequestMapping("/rfid") 
public class RfidController extends BaseController{
	
	@Autowired
	private RfidService rfidService; 
	
	@Autowired
	private CodeGenerator codeGenerator;
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/rfid/rfid_list",null); 
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
	public Object datalist(RfidEntity entity,HttpServletRequest request) throws Exception{
		List<RfidEntity> dataList = rfidService.queryByList(entity);
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
	public Object save(@RequestBody RfidEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);			
			entity.setEpcNo(getEpcNo());
			rfidService.add(entity);
		}else{
			entity.setModifyDate(date);
			rfidService.update(entity);
		}
		return sendSuccessMessage();
	}
	
	public String getEpcNo(){
		String sn = codeGenerator.getCode(CodeType.RFID_PREFIX, "",
				CodeTypeEnum.rfid_code.getId());	
		StringBuffer sb = new StringBuffer();
		if(sn != null){
			for(int i=0,length=sn.length();i<length;i++){
				sb.append("0"+sn.charAt(i));
			}
		}
	    return sb.toString();
	}
	
	@RequestMapping(value = "/mkrfid", method = RequestMethod.POST)
	@ResponseBody
	public Object mkrfid(@RequestBody RfidEntity entity, HttpServletRequest request) throws Exception{
		
		if(!(entity.getId()==null||StringUtils.isBlank(entity.getId().toString()))){	
			Boolean isOk = rfidService.mkrfid(entity);
			if(isOk){
				return sendSuccessMessage();				
			}
		}	
		return sendFailureMessage("制卡失败");
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
		RfidEntity entity  = rfidService.findById(id);
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
		rfidService.delete(id);
		return sendSuccessMessage();
	}

}
