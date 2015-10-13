package com.msds.km.job;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import UHF.Reader18Utils;

import com.msds.km.entity.RfidLogEntity;
import com.msds.km.service.RfidLogService;

/**
 * rfid自动查询
 * @author xiaoxiong
 *
 */
public class RfidJob {
	private final static Logger log = LoggerFactory.getLogger(RfidJob.class);

	private static final ResourceBundle bundle = ResourceBundle.getBundle("baseconfig");

	@Autowired
	private RfidLogService rfidLogService;

	/**
	 * 自动G2查询命令（待服务1秒刷新）
	 */
	public void autoInventory_G2() throws Exception {
		log.info("============= 自动查询rfid卡autoInventory_G2 开始  =======  ");
		List<String> list = null;
		try {
			list = Reader18Utils.getEPCList();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询异常不处理{}",e.getMessage());
		}
		if(list == null){
			return;
		}
		
		Date  dateTime = new Date(); 
		for(String epcNo : list){
			RfidLogEntity rfidLog = new RfidLogEntity();
			rfidLog.setCreateDate(dateTime);
			rfidLog.setModifyDate(dateTime);
			rfidLog.setEpcNo(epcNo);
			rfidLog.setFullArea(bundle.getString("rfid.fullArea"));
			rfidLog.setProviceId(Integer.parseInt(bundle.getString("rfid.proviceId")));
			rfidLog.setCityId(Integer.parseInt(bundle.getString("rfid.cityId")));
			rfidLog.setStreetId(Integer.parseInt(bundle.getString("rfid.streetId")));
			rfidLogService.add(rfidLog);
		}
		log.info("============= 自动查询rfid卡autoInventory_G2 结束  =======  ");
	}


	
}
