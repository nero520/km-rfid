package com.msds.km.service.Impl;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.ActivityEntity;
import com.msds.km.entity.PrizeCordEntity;
import com.msds.km.mapper.ActivityMapper;
import com.msds.km.mapper.PrizeCordMapper;
import com.msds.km.service.PrizeCordService;

/**
 * 
 * <br>
 * <b>功能：</b>PrizeCordService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-08-14 21:54:06 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("prizeCordService")
public class PrizeCordServiceImpl extends BaseServiceImpl<PrizeCordEntity>
		implements PrizeCordService {

	@Autowired
	private PrizeCordMapper prizeCordMapper;
	@Autowired
	private ActivityMapper activityMapper;

	public PrizeCordMapper baseMapper() {
		return prizeCordMapper;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String generate(String sn, String phone, String license,
			String model, Date expiryDate, String openid) {
		StringBuffer sb = new StringBuffer(sn);
		sb.append(phone);
		sb.append(System.currentTimeMillis());
		String prizeCord = DigestUtils.md5Hex(sb.toString()).substring(8, 24)
				.toUpperCase();
		PrizeCordEntity prizeCordEntity = new PrizeCordEntity();
		prizeCordEntity.setSn(prizeCord);
		prizeCordEntity.setActivitySn(sn);
		prizeCordEntity.setExpiryDate(expiryDate);
		prizeCordEntity.setModel(model);
		prizeCordEntity.setLicense(license);
		prizeCordEntity.setOpenid(openid);
		prizeCordEntity.setPhone(phone);
		prizeCordEntity.setState(1);
		prizeCordEntity.setCreateDate(new Date());
		ActivityEntity activityEntity = activityMapper.lockBySn(sn);
		if (activityEntity.getQuantity() < activityEntity.getCount()) {
			prizeCordMapper.add(prizeCordEntity);
			activityMapper.quantityIncr(sn);
			return prizeCord;
		}
		return null;
	}

	@Override
	public PrizeCordEntity findByActivitySnLicense(String activitySn,
			String license) {
		return prizeCordMapper.findByActivitySnLicense(activitySn, license);
	}

	@Override
	public String validation(String sn, String phone, String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
