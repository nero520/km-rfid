package com.msds.km.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UHF.Reader18Utils;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.RfidMapper;
import com.msds.km.entity.RfidEntity;
import com.msds.km.service.RfidService;

/**
 * 
 * <br>
 * <b>功能：</b>RfidService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-10 13:29:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("rfidService")
public class RfidServiceImpl extends BaseServiceImpl<RfidEntity> implements RfidService{

	@Autowired
    private RfidMapper rfidMapper;
		
	public RfidMapper baseMapper() {
		return rfidMapper;
	}

	@Override
	public Boolean mkrfid(RfidEntity entity) {
		Date date = new Date();
		entity.setModifyDate(date);
		try {
			 String epcNo = entity.getEpcNo();
			 int length = epcNo.length()/2;
			 int epcAttrs[] = new int[length];
			 for(int k=0;k<length;k++){
			 for(int i=k*2,m=epcNo.length();i<m;i++){
				 epcAttrs[k] = Integer.parseInt(epcNo.substring(i, i+2),16);
				 break;
			 }
			 }
			
			 Boolean isOk = Reader18Utils.iswriteEPC_G2(epcAttrs);
			 if(!isOk){
				return false;
			 }
			 entity.setState(1);
			 rfidMapper.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("制卡异常{}",e.getMessage());
			return false;
		}
		
		return true;
		
	}

}
