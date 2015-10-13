package com.msds.km.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.entity.CompanyEntity;
import com.msds.km.mapper.CompanyMapper;
import com.msds.km.service.CompanyService;
import com.msds.km.vo.OrderlistEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:35 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<CompanyEntity> implements CompanyService{

	@Autowired
    private CompanyMapper companyMapper;
		
	public CompanyMapper baseMapper() {
		return companyMapper;
	}

	@Override
	public List<CompanyEntity> findListByserviceCode(String serviceCode) {
		
		return companyMapper.findListByserviceCode(serviceCode);
	}

	@Override
	public Map<Integer, CompanyEntity> getCompanyMap() {
		Map<Integer, CompanyEntity> companyMap = new HashMap<Integer, CompanyEntity>();
		List<CompanyEntity> companyList = findListByCondition(null);
		for (CompanyEntity companyEntity : companyList) {
			companyMap.put(companyEntity.getId(), companyEntity);
		}
		return companyMap;
	}

	@Override
	public CompanyEntity queryByUserName(String username) {
		
		return companyMapper.queryByUserName(username);
	}

	@Override
	public List<CompanyEntity> findCompanyList(BasePage page) {
		Integer rowCount = companyMapper.queryCompanyCount(page);
		page.getPager().setRowCount(rowCount);
		Assert.notNull(page);
		List<CompanyEntity> list = companyMapper.findCompanyList(page);

		return list;
	}

	@Override
	public int updatePs(Integer id, String newps, String oldps) {
		return companyMapper.updatePs(id,newps,oldps);
	}

	
}
