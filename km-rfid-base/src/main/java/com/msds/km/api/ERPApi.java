package com.msds.km.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.msds.km.form.MaintenanceBylidForm;
import com.msds.km.form.StockBigForm;
import com.msds.util.HttpRequest;
import com.msds.util.JsonUtils;

public class ERPApi {

	private final static Logger logger  = Logger.getLogger(ERPApi.class);
	
	public static String getMaintenanceBylid(MaintenanceBylidForm form) throws Exception{

		String url = "http://115.29.176.68:9010/datasrv/2.0/outer/acc/getMaintenanceBylid";
		StockBigForm bigForm = new StockBigForm();
		bigForm.setBusinessCode("2032");
		bigForm.setParams(form);
		
		logger.info(url);
		String data = JsonUtils.toJson(bigForm);
		logger.info(data);
		
		Map<String, String> bodyMap = new HashMap<String, String>();
		bodyMap.put("param", data);
		
        //发送 POST 请求
		Date date = new Date();   
//        String reverse = HttpRequest.sendPost(API_DOMAIN+DATAPREFIX+API_VERSION+url, "businessCode="+businessCode+"&params="+data);
        String reverse = HttpRequest.post(url, bodyMap);
		logger.info(reverse);
		Date date2 = new Date();
        long temp = date2.getTime() - date.getTime();    //相差毫秒数
        logger.info("接口调用时长(毫秒)："+temp);
        return reverse;
	}
}
