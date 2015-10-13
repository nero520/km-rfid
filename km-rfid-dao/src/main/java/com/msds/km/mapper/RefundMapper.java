package com.msds.km.mapper;


import java.util.List;

import com.msds.base.mapper.BaseMapper;
import com.msds.common.BasePage;
import com.msds.km.entity.RefundEntity;
import com.msds.km.vo.RefundList;
/**
 * 
 * <br>
 * <b>功能：</b>RefundMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface RefundMapper extends BaseMapper<RefundEntity> {
	
	List<RefundList> refundList(BasePage page);
	
	Integer findRefundCount(BasePage page);
}
