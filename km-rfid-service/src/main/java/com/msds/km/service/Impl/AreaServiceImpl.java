package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.AreaEntity;
import com.msds.km.mapper.AreaMapper;
import com.msds.km.service.AreaService;

/**
 * 
 * <br>
 * <b>功能：</b>AreaService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:17:52 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("areaService")
public class AreaServiceImpl extends BaseServiceImpl<AreaEntity> implements
		AreaService {

	@Autowired
	private AreaMapper areaMapper;

	public AreaMapper baseMapper() {
		return areaMapper;
	}

	@Override
	public Integer findIdByName(String province, String city) {
		return areaMapper.findIdByName(province, city);
	}
	

	@Override
	public List<AreaEntity> getProvinceList() {
		AreaEntity provinceEntity = new AreaEntity();
		provinceEntity.setRegionType(1);
		return areaMapper.findListByCondition(provinceEntity);
	}
	
	@Override
	public List<AreaEntity> getCityList(Integer provinceId) {
		AreaEntity cityEntity = new AreaEntity();
		cityEntity.setParent(provinceId);
		cityEntity.setRegionType(2);
		return areaMapper.findListByCondition(cityEntity);
	}
	
	@Override
	public List<AreaEntity> getAreaList(Integer cityId) {
		AreaEntity areaEntity = new AreaEntity();
		areaEntity.setParent(cityId);
		areaEntity.setRegionType(3);
		return areaMapper.findListByCondition(areaEntity);
	}
	
	@Override
	public List<AreaEntity> findList(AreaEntity area){
		return areaMapper.findList(area);
	}

}