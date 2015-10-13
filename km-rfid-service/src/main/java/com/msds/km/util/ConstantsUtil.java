package com.msds.km.util;

import java.util.HashMap;
import java.util.Map;

import com.msds.km.entity.CompanyEntity;
import com.msds.km.service.CompanyService;
import com.msds.util.SpringUtils;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class ConstantsUtil {
    public static final String CURRENT_USER = "user";
    /** 修理厂MAP,由于修理厂动态维护，所以不这么用了 */
    public static Map<Integer,CompanyEntity> COMPANY_MAP = new HashMap<Integer,CompanyEntity>();
    
    static{
    	CompanyService companyService = (CompanyService) SpringUtils.getBean("companyService");
    	COMPANY_MAP.putAll(companyService.getCompanyMap());
    }
}
