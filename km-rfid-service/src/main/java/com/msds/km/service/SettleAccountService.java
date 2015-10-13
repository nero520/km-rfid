package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.common.BasePage;
import com.msds.km.entity.CompaySettingEntity;
import com.msds.km.entity.OrderEntity;
import com.msds.km.entity.SettleAccountEntity;
import com.msds.km.model.ListModel;
import com.msds.km.model.SettleAccountModel;

/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:05 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface SettleAccountService extends BaseService<SettleAccountEntity> {
	
	public ListModel<SettleAccountModel> findSettleAccountModelList(SettleAccountEntity settleAccountEntity) throws Exception;

	/**
	 * 保存对账主表
	 * @param order
	 * @param settleDaySn
	 * @param settleMonthSn
	 * @return
	 * @throws Exception 
	 * SettleAccountEntity
	 */
	public void saveSettleAccount(String startDate, List<OrderEntity> orderList,CompaySettingEntity compaySetting) throws Exception;
	
	public SettleAccountEntity findBySnAndCompanyId(String settleSn,Integer companyId) throws Exception;

	/***
	 * 通过条件查询对账单
	 * 
	 * @param orderEntity
	 * @return
	 */
	public List<SettleAccountEntity> findSettleAccountList(BasePage page)throws Exception;
	
	/**
	 * 通过结算单号查询对账单
	 * @param settleSn
	 * @return
	 * @throws Exception
	 */
	public SettleAccountEntity findBySn(String settleSn) throws Exception;
	
	/**
	 * 更新对账单表实际结算金额、备注
	 * 创建结算单
	 * @param settleAccountEntity
	 * @return
	 * @throws Exception
	 */
	public void saveBill(SettleAccountEntity settleAccountEntity) throws Exception;
}
