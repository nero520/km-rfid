package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.common.BasePage;
import com.msds.km.entity.SettleAccountItemEntity;
import com.msds.km.model.ListModel;
import com.msds.km.model.SettleAccountItemModel;

/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountItemService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface SettleAccountItemService extends BaseService<SettleAccountItemEntity> {

	/**
	 * 查询结算单明细列表
	 * @param settleAccountItemEntity
	 * @return
	 * @throws Exception
	 */
	ListModel<SettleAccountItemModel> findSettleAccountItemModelList(
			SettleAccountItemEntity settleAccountItemEntity) throws Exception;

	public List<SettleAccountItemEntity> queryByListAndOrder(BasePage page) throws Exception;
}
