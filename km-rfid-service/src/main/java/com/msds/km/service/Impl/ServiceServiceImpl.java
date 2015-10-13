package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.mapper.ServiceMapper;
import com.msds.km.service.MemberModelService;
import com.msds.km.service.ModelService;
import com.msds.km.service.ServiceModelService;
import com.msds.km.service.ServiceService;
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
@Service("serviceService")
public class ServiceServiceImpl extends BaseServiceImpl<ServiceEntity>
		implements ServiceService {

	@Autowired
	private ServiceMapper serviceMapper;

	@Autowired
	private ServiceModelService serviceModelService;

	@Autowired
	private MemberModelService memberModelService;

	@Autowired
	private ModelService modelService;

	public ServiceMapper baseMapper() {
		return serviceMapper;
	}

	@Override
	public SimpleModelDetail getSimpleInfo(Integer Id, Integer cityId)
			throws Exception {

		MemberModelEntity param = new MemberModelEntity();
		param.setId(Id);
		List<MemberModelEntity> modelList = memberModelService
				.findListByCondition(param);
		MemberModelEntity memberModelEntity = new MemberModelEntity();
		if (modelList != null && modelList.size() > 0) {
			memberModelEntity = modelList.get(0);
		}

		SimpleModelDetail simpleModelDetail = new SimpleModelDetail();
		simpleModelDetail.setId(memberModelEntity.getId());
		simpleModelDetail.setModelGroupName(memberModelEntity
				.getModelGroupName());
		simpleModelDetail.setMileage(memberModelEntity.getMileage());
		simpleModelDetail.setRegion(memberModelEntity.getRegion());
		simpleModelDetail.setModelId(memberModelEntity.getModelId());
		simpleModelDetail.setLicense(memberModelEntity.getLicense());
		String logo = modelService.findLogoById(memberModelEntity.getModelId());
		simpleModelDetail.setLogo(logo);
		if (cityId != null) {
			List<com.msds.km.vo.Service> serviceLists = serviceModelService
					.findServiceLists(memberModelEntity.getModelId(), cityId);
			simpleModelDetail.setServiceList(serviceLists);
		}

		return simpleModelDetail;

	}

	@Override
	public List<ServiceEntity> findByCompany_id(Integer companyId) {

		return serviceMapper.findByCompany_id(companyId);
	}

	@Override
	public List<ServiceEntity> findServiceList(BasePage page) {
		int rowCount = serviceMapper.queryServiceCount(page);
		page.getPager().setRowCount(rowCount);
		Assert.notNull(page);
		return serviceMapper.findServiceList(page);
	}

	@Override
	public Integer queryServiceCount(BasePage page) {
		return serviceMapper.queryServiceCount(page);
	}

}
