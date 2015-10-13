package com.msds.km.service;

import java.util.List;
import java.util.Map;

import com.msds.base.service.BaseService;
import com.msds.km.entity.ModelEntity;

/**
 * 
 * <br>
 * <b>功能：</b>ModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:57 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ModelService extends BaseService<ModelEntity> {

	public List<ModelEntity> getModelList(ModelEntity model);

	/**
	 * 查询汽车品牌
	 * 
	 * @return
	 */
	public Map<String, Object> queryBrandModels();

	/**
	 * 查询汽车厂商品牌
	 * 
	 * @return
	 */
	public Map<String, Object> queryfactorybrands(ModelEntity model);

	/**
	 * 查询车型
	 * 
	 * @param model
	 * @return
	 */
	public List<ModelEntity> queryVehicle(ModelEntity model);

	/**
	 * 
	 * 查询子车系通过厂商品牌id
	 * 
	 * @param model
	 * @return
	 */
	public List<ModelEntity> queryfactoryvehicle(ModelEntity model);

	/**
	 * 
	 * 根据车型明细Id查询LOGO
	 * 
	 * @param id
	 * @return
	 */
	String findLogoById(Integer id);

	/**
	 * 查询所有一级汽车品牌
	 * 
	 * @return map map的key：value说明: letters：为所有一级汽车品牌拼音首字母的升序的字符串数组
	 *         models:为所有一级汽车品牌List
	 * 
	 */
	public Map<String, Object> firstLevelModel();

	public Map<String, Object> firstRangeLevelModel();

}
