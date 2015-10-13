package com.msds.km.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msds.baseinfo.entity.AuthUser;
import com.msds.km.CodeGenerator;
import com.msds.km.CodeType;
import com.msds.km.base.BaseController;
import com.msds.km.entity.AreaEntity;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.ModelEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.service.AreaService;
import com.msds.km.service.BespeakService;
import com.msds.km.service.CompanyService;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.MemberService;
import com.msds.km.service.ModelService;
import com.msds.km.service.OrderService;
import com.msds.km.util.ConstantsUtil;
import com.msds.km.vo.Product;
import com.msds.shiro.filter.Constants;
import com.msds.util.AppConstants;
import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;
import com.msds.util.JPushManager;
import com.msds.util.JsonUtils;
import com.msds.util.SmsUtil;
import com.fasterxml.jackson.core.type.TypeReference;
 
/**
 * 
 * <br>
 * <b>功能：</b>BespeakController<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-08-03 16:54:32 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 */ 
@Controller
@RequestMapping("/bespeak") 
public class BespeakController extends BaseController{
	
	@Autowired
	private BespeakService bespeakService; 
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private MemberModelService memberModelService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CodeGenerator codeGenerator;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AppConstants appConstants;

  
	
	/**
	 * 跳转列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(HttpServletRequest request) throws Exception{
		return forword("/km/bespeak/bespeak_list",null); 
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
	public Object datalist(BespeakEntity entity,HttpServletRequest request) throws Exception{
		String after = entity.getAfterDate();
		//处理结束日期为当日结束时间
		if(!StringUtils.isEmpty(after)){
			Date afterDate = DateUtils.StringToDate(after);
			afterDate = DateUtils.getDayEnd(afterDate);
			after = DateUtils.DateToString(afterDate, DateStyle.YYYY_MM_DD_HH_MM_SS);
			entity.setAfterDate(after);
		}
		List<BespeakEntity> dataList = bespeakService.findBespeakList(entity);
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	/**
	 * 查询预约单
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/getDetail")
	@ResponseBody
	public ModelAndView getDetail(BespeakEntity entity, HttpServletRequest request){
		
		BespeakEntity bespeak = new BespeakEntity();;
		try {
			bespeak = bespeakService.findDetailByBespeak(entity);
			request.setAttribute("bespeak", bespeak);
		} catch (Exception e) {
			logger.info("查询预约单详情异常id为{}",entity.getId());
			e.printStackTrace();
		}
		return forword("/km/bespeak/bespeak_view", null);
	}
	/**
	 * 获取汽车品牌及相应的字母-车型选择1、2级
	 * @return
	 */
	@RequestMapping(value="/getModelList", method = RequestMethod.GET)
	@ResponseBody
	public Object getModelList(ModelEntity model){
		
		model.setIs_show(1);
		List<ModelEntity> list = modelService.getModelList(model);
		return returnDataGrid(0, list);
		
	}
	
	
	@RequestMapping("/toBespeak")
	public ModelAndView toBespeak(BespeakEntity entity,HttpServletRequest request) throws Exception {
		
		
		String sn = codeGenerator.getCode(CodeType.BESPEAK_ID_PREFIX, "", CodeTypeEnum.bespeak_code.getId());
		entity.setBespeakSn(sn);
		//预约时间，不能少于当前时间
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
		entity.setStartDate(format1.parse(format1.format(new Date())));
		request.setAttribute("bespeak", entity);
		
		return forword("/km/bespeak/bespeak_edit", null);
	}
	
	/**
	 * 查询预约单
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/getBespeak")
	@ResponseBody
	public ModelAndView getBespeak(BespeakEntity entity, HttpServletRequest requestd){
		
		BespeakEntity bespeak = new BespeakEntity();;
		try {
			bespeak = bespeakService.findByBespeakId(entity);
			bespeak.setIsEdit(entity.getIsEdit());
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
			bespeak.setStartDate(format1.parse(format1.format(new Date())));
			requestd.setAttribute("bespeak", bespeak);
		} catch (Exception e) {
			logger.info("查询预约单详情异常id为{}",entity.getId());
		}
		return forword("/km/bespeak/bespeak_edit", null);
	}

	@RequestMapping("/addMember")
	public ModelAndView addMember(MemberEntity entity,HttpServletRequest request) throws Exception {
		entity.setIsEdit(false);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DAY_OF_YEAR,-1);
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        request.setAttribute("now", reStr);
		request.setAttribute("member", entity);
		return forword("/km/member/member_edit", null);
	}
	
	@RequestMapping("/editMember")
	public ModelAndView editMember(MemberEntity entity, HttpServletRequest request) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DAY_OF_YEAR,-1);
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
		List<MemberEntity>  list = bespeakService.getMemberList(entity);
		if(null != list && list.size() > 0){
			MemberEntity member = list.get(0);
			member.setIsEdit(true);
			request.setAttribute("member", member);
			request.setAttribute("now", reStr);
		}
		return forword("/km/member/member_edit", null);
	}
	
	@RequestMapping("/getMemberByPhone")
	@ResponseBody
	public MemberEntity getMemberByPhone(MemberEntity entity, HttpServletRequest request) throws Exception {
		
		List<MemberEntity>  list = bespeakService.getMemberList(entity);
		if(null != list && list.size() > 0){
			MemberEntity member = list.get(0);
			member.setIsEdit(true);
			return member;
		}else{
			entity.setIsEdit(true);
			entity.setSex(1);
			return entity;
		}
	}
	
	
	/**
	 * 添加或修改数据
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/saveOrUpdateBespeak")
	@ResponseBody
	public Object saveOrUpdate(BespeakEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		
		
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			entity.setState(1);
			bespeakService.addBespeak(entity);
			
			if(null != entity.getCompanyId()){
				//[康民养车] 2015-08-02 19:00:00 您有一张新的订单，浙A12345，雪铁龙C5 1.5 2004，预约2015-08-04 上午的小保养套餐
				CompanyEntity company = companyService.findById(entity.getCompanyId());
				
				//手机号不为空时，发送订单信息
				if(null != company.getContactsPhone() && !"".equals(company.getContactsPhone()) 
						&& null != entity.getBespeakDate() && !"".equals(entity.getBespeakDate())){
					MemberModelEntity mm = memberModelService.findById(entity.getMemberModelId());
					StringBuffer sb = new StringBuffer();
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
					DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
					String data = format1.format(date);
					int hour = date.getHours();
					String hourString = "上午";
					if(hour >= 12){
						hourString = "下午";
					}
					sb.append(data).append(" 您有一张新的订单，").append(mm.getRegion()).append(mm.getLicense()).append(",").
					append(mm.getModelGroupName()).append(",预约时间为:").append(format.format(entity.getBespeakDate())).append(hourString).append("【车民生】");
					SmsUtil.sendGet(company.getContactsPhone(), appConstants.getSmsUrl(), sb.toString());
				}
				
				//消息推送
				try {
					JPushManager.getInstance().pushToAlias("您收到了一条消息", "c"+String.valueOf(entity.getCompanyId()));
				} catch (Exception e) {
					logger.error("消息推送失败");
				}
				
			}
		}else{
			entity.setModifyDate(date);
			bespeakService.update(entity);
		}
		return sendSuccessMessage();
	}
	
	
	@RequestMapping(value = "/checkPhone")
	@ResponseBody
	public Boolean checkPhone(MemberEntity entity, HttpServletRequest request){
		
		List<MemberEntity>  list = bespeakService.getMemberList(entity);
		if(null == list || list.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value = "/checkLicense")
	@ResponseBody
	public Boolean checkLicense(MemberEntity entity, HttpServletRequest request){
		
		List<MemberEntity>  list = bespeakService.getMemberList(entity);
		if(null == list || list.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 添加或修改数据
	 *
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/saveOrUpdateMember")
	@ResponseBody
	public Object saveOrUpdateMember(MemberEntity entity, HttpServletRequest request) throws Exception{
		Date date = new Date();
		
		AuthUser user = (AuthUser)request.getSession().getAttribute(Constants.CURRENT_USER);
		MemberModelEntity mm = new MemberModelEntity();
		
		if(null != entity.getLicense() && !"".equals(entity.getLicense())){
			String region = entity.getLicense().toUpperCase().substring(0,1);
			String license = entity.getLicense().toUpperCase().substring(1,entity.getLicense().length());
			
			mm.setLicense(license);
			mm.setRegion(region);
		}
		
		//检查手机号是否重复
		MemberEntity member = new MemberEntity();
		member.setPhone(entity.getPhone());
		List<MemberEntity> list = memberService.findListByCondition(member);
		
		String errosMessage = "手机号已经存在";
		if(null != entity.getId()){
			if(null == list || list.size() >= 2){
				return errosMessage;
			}
		}else{
			if(null == list || list.size() >= 1){
				return errosMessage;
			}
		}
		
		//检查车牌号是否重复
		errosMessage = "车牌号已经存在";
		List<MemberModelEntity> mlist = memberModelService.findListByCondition(mm);
		if(null != entity.getMemberModelId()){
			if(null == mlist || mlist.size() >= 2){
				return errosMessage;
			}
		}else{
			if(null == mlist || mlist.size() >= 1){
				return errosMessage;
			}
		}
		
		mm.setId(entity.getMemberModelId());
		mm.setBuyDate(entity.getBuyDate());
		mm.setLastServiceDate(entity.getLastServiceDate());
		mm.setVin(entity.getVin());
		mm.setChassis(entity.getChassis());
		mm.setModelGroupName(entity.getModelGroupName());
		mm.setModelId(entity.getModelId());
		mm.setMileage(entity.getMileage());
		mm.setLastServiceMan(user.getUserName());
		
		
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreateDate(date);
			entity.setModifyDate(date);
			memberService.add(entity);
			mm.setMemberId(entity.getId());
			mm.setDefaultFlag(1);
			memberModelService.add(mm);
			
		}else{
			entity.setModifyDate(date);
			memberService.update(entity);
			//更新用户信息时，如果用户没有添加过车型，就新增
			if(null == mm.getId() || "".equals(mm.getId())){
				mm.setMemberId(entity.getId());
				mm.setDefaultFlag(1);
				memberModelService.add(mm);
			}else{
				memberModelService.update(mm);
			}
			
		}
		return true;
	}
	
	/**
	 * 车主列表
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberList")
	@ResponseBody
	public Object getMemberList(MemberEntity member,HttpServletRequest request) throws Exception{
		List<MemberEntity>  list = bespeakService.getMemberList(member);
		if(null == list || list.size() == 0){
			return sendFailureMessage("没有找到对应的记录!");
		}
		
		int total = bespeakService.queryByCount(member);
		return returnDataGrid(total, list);
	}
	
	/**
	 * 车主预约单列表
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBespeakList")
	@ResponseBody
	public Object getBespeakList(BespeakEntity entity,HttpServletRequest request) throws Exception{
		
		if(null == entity.getMemberId()){
			entity.setMemberId(-1);
		}
		
		List<BespeakEntity>  list = bespeakService.getBespeakList(entity);
		if(null == list || list.size() == 0){
			return sendFailureMessage("没有找到对应的记录!");
		}
		
		int total = bespeakService.getBespeakListCount(entity);
		return returnDataGrid(total, list);
	}
	
	
	/**
	 * 一级服务
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFirstLevel")
	@ResponseBody
	public Object getFirstLevel( HttpServletRequest request)
			throws Exception {
		List<ProcessEntity> dataList = bespeakService.getFirstLevel();
		return returnDataGrid(0, dataList);
	}
	
	/**
	 * 二级服务
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSecondById")
	@ResponseBody
	public Object getSecondById( Integer id, HttpServletRequest request)
			throws Exception {
		List<ProcessEntity> dataList = bespeakService.getSecondById(id);
		return returnDataGrid(0, dataList);
	}
	
	/**
	 * 区域数据
	 * 
	 * @param bespeakSn
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getArea")
	@ResponseBody
	public Object getArea(AreaEntity area, HttpServletRequest request)
			throws Exception {
		List<AreaEntity> dataList = areaService.findList(area);
		return returnDataGrid(0, dataList);
	}

	/**
	 * 修理厂列表
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCompanyList")
	@ResponseBody
	public Object getCompanyList(CompanyEntity entity,HttpServletRequest request) throws Exception{
		entity.setLockState(2);
		List<CompanyEntity> dataList = companyService.queryByList(entity);
		return returnDataGrid(0, dataList);
	}

	/**
	 *查询用户全部历史订单信息
	 * 
	 * @param entity
	 * @param request
	 * @return
	 * @throws Exception
	 * 
}
	 */
	@RequestMapping("/getHistoryInfoList")
	@ResponseBody
	public Object getHistoryInfoList(Integer id,HttpServletRequest request) throws Exception{
		List<OrderEntity> entities = new ArrayList<OrderEntity>();
		
		OrderEntity entity = new OrderEntity();
		entity.setMemberId(id);
		entity.setOrderState(4);
		List<OrderEntity> dataList = orderService.findListByCondition(entity);
		
		String content="";
		OrderEntity order = new OrderEntity();
		for (OrderEntity orderEntity : dataList) {
			order.setSerivceFinishDate(orderEntity.getSerivceFinishDate());
			order.setMileage(orderEntity.getMileage());
		
			 if (orderEntity.getServiceName() != null && orderEntity.getProductsJson() != null) {
					String str = "";
					List<Product> productEntities = JsonUtils.toObject(orderEntity.getProductsJson(),new TypeReference<List<Product>>() {
							});
					for (int i = 0; i < productEntities.size(); i++) {
						str = str + productEntities.get(i).getProductName();
					}
					content = "项目：" + orderEntity.getServiceName() + "<br/>材料：" + str;
			 }
			 order.setContact(content);
		}
		return returnDataGrid(entity.getPager().getRowCount(), dataList);
	}
	
	@RequestMapping("/findMemberInfo")
	public ModelAndView findOrderInfo(String vin,HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView("/km/member/member_info");
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setVin(vin);
		List<MemberEntity> list = bespeakService.getMemberList(memberEntity);
		if(list==null || list.size()>1){
			return null;
		}
		
		mav.addObject("member", list.get(0));
		
		return mav;
	}
	
	@RequestMapping("/viewMember")
	public ModelAndView viewMember(Integer id,HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView("/km/member/member_view");
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setId(id);
		List<MemberEntity> list = bespeakService.getMemberList(memberEntity);
		if(list==null || list.size()>1){
			return null;
		}
		
		mav.addObject("member", list.get(0));
		
		return mav;
	}
	
}
