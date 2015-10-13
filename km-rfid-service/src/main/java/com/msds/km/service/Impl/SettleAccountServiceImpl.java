package com.msds.km.service.Impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.CodeGenerator;
import com.msds.km.entity.BillEntity;
import com.msds.km.entity.CompanyAccountEntity;
import com.msds.km.entity.CompaySettingEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.SettleAccountEntity;
import com.msds.km.entity.SettleAccountItemEntity;
import com.msds.km.entity.SettleLogEntity;
import com.msds.km.enums.BillStateEnum;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.enums.SettleStateEnum;
import com.msds.km.mapper.SettleAccountMapper;
import com.msds.km.model.ListModel;
import com.msds.km.model.SettleAccountModel;
import com.msds.km.service.BillService;
import com.msds.km.service.CompanyAccountService;
import com.msds.km.service.CompanyService;
import com.msds.km.service.CompaySettingService;
import com.msds.km.service.SettleAccountItemService;
import com.msds.km.service.SettleAccountService;
import com.msds.km.service.SettleLogService;
import com.msds.util.DateUtils;
import com.msds.util.DateUtils.DateStyle;

/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("settleAccountService")
public class SettleAccountServiceImpl extends BaseServiceImpl<SettleAccountEntity> implements SettleAccountService{

	@Autowired
    private SettleAccountMapper settleAccountMapper;
	@Resource
	private CompanyAccountService companyAccountService;
	@Resource
	private SettleAccountItemService settleAccountItemService;
	@Resource
	private SettleLogService settleLogService;
	@Resource
	private CodeGenerator codeGenerator;
	@Resource
	private CompaySettingService compaySettingService;
	@Resource
	private CompanyService companyService;
	@Resource
	private BillService billService;
		
	public SettleAccountMapper baseMapper() {
		return settleAccountMapper;
	}

	@Override
	public ListModel<SettleAccountModel> findSettleAccountModelList(
			SettleAccountEntity settleAccountEntity) throws Exception {
		
		List<SettleAccountModel> settleAccountModelList = new ArrayList<SettleAccountModel>();
		int totalCount = this.settleAccountMapper.queryByCount(settleAccountEntity);
		List<SettleAccountEntity> settleAccountEntityList = this.settleAccountMapper.queryByList(settleAccountEntity);
		SettleAccountModel settleAccountModel = null;
		for(SettleAccountEntity settleAccount : settleAccountEntityList){
			settleAccountModel = new SettleAccountModel();
			settleAccountModel.setSettleSn(settleAccount.getSettleSn());
			settleAccountModel.setStart(settleAccount.getStartDate());
			settleAccountModel.setEnd(settleAccount.getEndDate());
			settleAccountModel.setPrice(settleAccount.getSettleAllAmount() == null?"0.00":settleAccount.getSettleAllAmount().setScale(2, RoundingMode.HALF_UP).toString());
			if(SettleStateEnum.getEnumById(settleAccount.getSettleState()) != null){
				settleAccountModel.setStateName(SettleStateEnum.getEnumById(settleAccount.getSettleState()).getName());
			}
			settleAccountModelList.add(settleAccountModel);
		}
		
		ListModel<SettleAccountModel> models = new ListModel<SettleAccountModel>();
		models.setModels(settleAccountModelList);
		models.setTotalCount(totalCount);
		return models;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveSettleAccount(String startDate, List<OrderEntity> orderList,
			CompaySettingEntity compaySetting)	throws Exception{
		String settleSn = codeGenerator.getCode(CodeTypeEnum.settle_code.getPrefix(), "",
				CodeTypeEnum.settle_code.getId());
		Date date = new Date();
		BigDecimal allAmount = BigDecimal.ZERO;
		Integer companyId = null;
		if(orderList.size() > 0){
			companyId = orderList.get(0).getCompanyId();
		}
		//保存明细并计算总结算金额
		for (OrderEntity order : orderList) {
			SettleAccountItemEntity settleAccountItem = new SettleAccountItemEntity();
			settleAccountItem.setCompanyId(order.getCompanyId());
			settleAccountItem.setSettleSn(settleSn);
			settleAccountItem.setOrderSn(order.getOrderSn());
			settleAccountItem.setServiceName(order.getServiceName());
			settleAccountItem.setSettleAmount(order.getAmount());
			String serviceTime = DateUtils.DateToString(order.getServiceTime(), DateStyle.YYYY_MM_DD);
			settleAccountItem.setServiceTime(serviceTime);
			settleAccountItem.setCreateDate(date);
			settleAccountItem.setModifyDate(date);
			settleAccountItemService.add(settleAccountItem);
			
			allAmount = allAmount.add(order.getAmount());
		}
		SettleAccountEntity settleAccount = new SettleAccountEntity();
		settleAccount.setCompanyId(companyId);
		settleAccount.setSettleSn(settleSn);
		settleAccount.setStartDate(startDate);
		Date end = DateUtils.addDay(new Date(), -1);
		String endDate = DateUtils.DateToString(end, DateStyle.YYYY_MM_DD);
		settleAccount.setEndDate(endDate);
		settleAccount.setSettleAllAmount(allAmount);
		settleAccount.setSettleState(SettleStateEnum.wait_settle.getId());
		settleAccount.setCreateDate(date);
		settleAccount.setModifyDate(date);
		
		CompanyAccountEntity companyAccount = companyAccountService.findByCompanyId(companyId);
		settleAccount.setBillingType(companyAccount.getBillType());
		settleAccount.setAccountName(companyAccount.getAccountName());
		settleAccount.setAccountBankName(companyAccount.getAccountBankName());
		settleAccount.setAccountNumber(companyAccount.getAccountNumber());
		settleAccount.setRemark("");
		super.add(settleAccount);
		
		//记录结算日志
		String remark = "生成结算单，未结算金额为："+allAmount.toString();
		this.saveSettleLog(settleAccount.getId(),remark);
		
	}
	
	/**
	 * 保存结算日志
	 * @param settleAccountId
	 * @param remark 
	 * void
	 * @throws Exception 
	 */
	private void saveSettleLog(Integer settleAccountId,String remark) throws Exception{
		SettleLogEntity settleLog = new SettleLogEntity();
		settleLog.setSettleAccountId(settleAccountId);
		settleLog.setRemark(remark);
		settleLog.setOperPerson("autoJob");
		settleLog.setCreateTime(new Date());
		settleLogService.add(settleLog);
	}
	
	@Override
	public SettleAccountEntity findBySnAndCompanyId(String settleSn,
			Integer companyId) throws Exception {
		
		return this.settleAccountMapper.findBySnAndCompanyId(settleSn, companyId);
	}

	@Override
	public List<SettleAccountEntity> findSettleAccountList(BasePage page)
			throws Exception {
		Integer rowCount = settleAccountMapper.queryByCount(page);
		page.getPager().setRowCount(rowCount);
		Assert.notNull(page);
		List<SettleAccountEntity> list = settleAccountMapper.queryByList(page);
		return list;
	}

	@Override
	public SettleAccountEntity findBySn(String settleSn) throws Exception {
		return this.settleAccountMapper.findBySn(settleSn);
	}

	@Override
	@Transactional
	public void saveBill(SettleAccountEntity settleAccountEntity)
			throws Exception {
		Date date = new Date();
		//更新对账单
		SettleAccountEntity settleAccount = this.findBySn(settleAccountEntity.getSettleSn());
		settleAccount.setActualAmount(settleAccountEntity.getActualAmount());
		settleAccount.setRemark(settleAccountEntity.getRemark());
		settleAccount.setSettleState(SettleStateEnum.finish_bill.getId());
		settleAccount.setModifyDate(date);
		this.update(settleAccount);
		
		//保存结算单
		BillEntity bill = new BillEntity();
		String billSn = codeGenerator.getCode(CodeTypeEnum.bill_code.getPrefix(), "",
				CodeTypeEnum.bill_code.getId());
		bill.setBillSn(billSn);
		bill.setSettleSn(settleAccount.getSettleSn());
		//由于对账单、结算单中的订单的实际服务时间不一定一致，所以暂时取对账止期
		Date serivceFinishDate = DateUtils.StringToDate(settleAccount.getEndDate());
		bill.setSerivceFinishDate(serivceFinishDate);
		bill.setBillingType(settleAccount.getBillingType());
		bill.setAccountName(settleAccount.getAccountName());
		bill.setAccountBankName(settleAccount.getAccountBankName());
		bill.setAccountNumber(settleAccount.getAccountNumber());
		bill.setSettleAllAmount(settleAccount.getSettleAllAmount());
		bill.setActualAmount(settleAccount.getActualAmount());
		bill.setBillState(BillStateEnum.finish_bill.getId());
		bill.setRemark(settleAccount.getRemark());
		bill.setCreateDate(date);
		billService.add(bill);
	}
	

}
