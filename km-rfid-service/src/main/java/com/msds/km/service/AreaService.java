package com.msds.km.service;

import java.util.List;

import com.msds.base.service.BaseService;
import com.msds.km.entity.AreaEntity;

/**
 * 
 * <br>
 * <b>功能：</b>AreaService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface AreaService extends BaseService<AreaEntity> {

	/**
	 * 根据城市查询code
	 * 
	 * @param province
	 * @param city
	 * @return
	 */
	Integer findIdByName(String province, String city);
	
	/**
	 * 查询所有省份
	 * 
	 * @Description 
	 * @return
	 */
	List<AreaEntity> getProvinceList();
	
	/**
	 * 查询所有市
	 * 
	 * @Description 
	 * @return
	 */
	public List<AreaEntity> getCityList(Integer provinceId);
	
	/**
	 * 查询所有区县
	 * 
	 * @Description 
	 * @return
	 */
	public List<AreaEntity> getAreaList(Integer cityId); 
	
	
	List<AreaEntity> findList(AreaEntity area);
}