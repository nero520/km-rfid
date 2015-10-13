package com.msds.km.service;

import java.util.Date;

import com.msds.base.service.BaseService;
import com.msds.km.entity.PrizeCordEntity;

/**
 * 
 * <br>
 * <b>功能：</b>PrizeCordService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface PrizeCordService extends BaseService<PrizeCordEntity> {

	String generate(String sn, String phone, String license, String model,
			Date expiryDate, String openid);

	String validation(String sn, String phone, String license);

	PrizeCordEntity findByActivitySnLicense(String sn, String license);
}
