package com.msds.km.mapper;


import java.util.List;

import com.msds.base.mapper.BaseMapper;
import com.msds.common.BasePage;
import com.msds.km.entity.SettleAccountItemEntity;
/**
 * 
 * <br>
 * <b>功能：</b>SettleAccountItemMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-07-03 16:10:24 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface SettleAccountItemMapper extends BaseMapper<SettleAccountItemEntity> {
	
	public List<SettleAccountItemEntity> queryByListAndOrder(BasePage page);
}
