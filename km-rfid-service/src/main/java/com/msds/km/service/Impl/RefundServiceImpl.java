package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.mapper.RefundMapper;
import com.msds.km.entity.RefundEntity;
import com.msds.km.service.RefundService;
import com.msds.km.vo.RefundList;

/**
 * 
 * <br>
 * <b>功能：</b>RefundService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("refundService")
public class RefundServiceImpl extends BaseServiceImpl<RefundEntity> implements RefundService{

	@Autowired
    private RefundMapper refundMapper;
		
	public RefundMapper baseMapper() {
		return refundMapper;
	}

	@Override
	public List<RefundList> refundList(BasePage page) {
		Assert.notNull(page);
		Integer rowCount = refundMapper.findRefundCount(page);
		page.getPager().setRowCount(rowCount);
		return refundMapper.refundList(page);
	}

}
