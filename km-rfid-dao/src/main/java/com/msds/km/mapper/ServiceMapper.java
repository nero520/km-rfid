package com.msds.km.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.common.BasePage;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.vo.Service;
/**
 * 
 * <br>
 * <b>功能：</b>ServiceMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:15 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface ServiceMapper extends BaseMapper<ServiceEntity> {

	ServiceEntity findByCode(String serviceCode);

	List<Service> findServiceLists(@Param("modelId") Integer modelId,@Param("cityId") Integer cityId);
	
	public List<ServiceEntity> findByCompany_id(Integer companyId);
	
	/**
	 * 模糊查询服务列表
	 */
	List<ServiceEntity> findServiceList(BasePage page);
	/**
	 * 模糊查询服务总数
	 */
	Integer queryServiceCount(BasePage page);
	
	
}
