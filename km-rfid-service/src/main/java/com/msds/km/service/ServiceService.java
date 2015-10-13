package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.common.BasePage;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.vo.SimpleModelDetail;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:15 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ServiceService extends BaseService<ServiceEntity> {

	/**
	 * 
	 * 获取组装服务列表信息
	 * 
	 * @param Id
	 *            爱车Id
	 * @param cityId
	 *            市id
	 * @return
	 * @throws Exception
	 */
	public SimpleModelDetail getSimpleInfo(Integer Id, Integer cityId)
			throws Exception;

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
