package com.msds.km.service.Impl;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.entity.SettleAccountItemEntity;
import com.msds.km.mapper.SettleAccountItemMapper;
import com.msds.km.model.ListModel;
import com.msds.km.model.SettleAccountItemModel;
import com.msds.km.service.SettleAccountItemService;

/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountItemService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 13:58:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("settleAccountItemService")
public class SettleAccountItemServiceImpl extends BaseServiceImpl<SettleAccountItemEntity> implements SettleAccountItemService{

	@Autowired
    private SettleAccountItemMapper settleAccountItemMapper;
		
	public SettleAccountItemMapper baseMapper() {
		return settleAccountItemMapper;
	}

	@Override
	public ListModel<SettleAccountItemModel> findSettleAccountItemModelList(
			SettleAccountItemEntity settleAccountItemEntity) throws Exception {
		
		List<SettleAccountItemModel> settleAccountItemModelList = new ArrayList<SettleAccountItemModel>();
		int totalCount = this.settleAccountItemMapper.queryByCount(settleAccountItemEntity);
		List<SettleAccountItemEntity> settleAccountItemEntityList = this.settleAccountItemMapper.queryByList(settleAccountItemEntity);
		SettleAccountItemModel settleAccountItemModel = null;
		for(SettleAccountItemEntity settleAccountItem : settleAccountItemEntityList){
			settleAccountItemModel = new SettleAccountItemModel();
			settleAccountItemModel.setOrderSn(settleAccountItem.getOrderSn());
			settleAccountItemModel.setServiceName(settleAccountItem.getServiceName());
			settleAccountItemModel.setServiceTime(settleAccountItem.getServiceTime());
			settleAccountItemModel.setPrice(settleAccountItem.getSettleAmount() == null?"0.00":settleAccountItem.getSettleAmount().setScale(2, RoundingMode.HALF_UP).toString());	
			settleAccountItemModelList.add(settleAccountItemModel);
		}
		
		ListModel<SettleAccountItemModel> models = new ListModel<SettleAccountItemModel>();
		models.setModels(settleAccountItemModelList);
		models.setTotalCount(totalCount);
		return models;
	}

	@Override
	public List<SettleAccountItemEntity> queryByListAndOrder(BasePage page)
			throws Exception {
		Integer rowCount = settleAccountItemMapper.queryByCount(page);
		page.getPager().setRowCount(rowCount);
		Assert.notNull(page);
		return settleAccountItemMapper.queryByListAndOrder(page);
	}

}
