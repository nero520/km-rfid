package com.msds.km.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.common.BasePage;
import com.msds.km.CodeGenerator;
import com.msds.km.CodeType;
import com.msds.km.entity.LaborcostEntity;
import com.msds.km.entity.ServiceEntity;
import com.msds.km.entity.ServiceModelEntity;
import com.msds.km.enums.CodeTypeEnum;
import com.msds.km.mapper.LaborcostMapper;
import com.msds.km.mapper.ModelMapper;
import com.msds.km.mapper.ServiceMapper;
import com.msds.km.mapper.ServiceModelDetailMapper;
import com.msds.km.mapper.ServiceModelMapper;
import com.msds.km.service.ServiceModelService;
import com.msds.km.vo.Laborcost;
import com.msds.km.vo.Product;
import com.msds.km.vo.ServiceMode;
import com.msds.km.vo.ServiceModelVo;
import com.msds.util.JsonUtils;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("serviceModelService")
public class ServiceModelServiceImpl extends
		BaseServiceImpl<ServiceModelEntity> implements ServiceModelService {

	@Autowired
	private ServiceModelMapper serviceModelMapper;
	@Autowired
	private ServiceMapper serviceMapper;
	@Autowired
	private LaborcostMapper laborcostMapper;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ServiceModelDetailMapper serviceModelDetailMapper;
	
	@Resource(name = "codeGenerator")
	CodeGenerator codeGenerator;

	public ServiceModelMapper baseMapper() {
		return serviceModelMapper;
	}

	@Override
	public ServiceMode findDetailed(String serviceCode, Integer modelId) {
		// 服务车型
		ServiceModelEntity serviceModelEntity = serviceModelMapper
				.findByCodeMId(serviceCode, modelId);
		if (serviceModelEntity != null) {
			// 服务
			ServiceEntity serviceEntity = serviceMapper.findByCode(serviceCode);
			if (serviceEntity != null) {
				// 车型
				// ModelEntity modelEntity = modelMapper.findById(modeId);
				// 商品
				List<Product> productList = serviceModelDetailMapper
						.findProductListByServiceModelCode(serviceModelEntity
								.getServiceModelCode());
				// TODO 价格、数量暂时不显示
				// BigDecimal productPrice = new BigDecimal(0);
				// for (Product product : productList) {
				// productPrice = productPrice.add(product.getKMPrice());
				// }
				// String productsJson = JsonUtils.toJson(productList);
				// 工时
				List<Laborcost> laborcostlist = JsonUtils.toObject(
						serviceModelEntity.getLaborcostJson(),
						new TypeReference<List<Laborcost>>() {
						});
				// TODO 价格、数量暂时不显示
				// BigDecimal laborcostPrice = new BigDecimal(0);
				if (laborcostlist != null && laborcostlist.size() > 0) {
					for (Laborcost laborcost : laborcostlist) {
						LaborcostEntity laborcostEntity = laborcostMapper
								.findById(laborcost.getId());
						laborcost.setItemName(laborcostEntity.getItemName());
						laborcost.setPrice(laborcostEntity.getPrice());
						// laborcostPrice =
						// laborcostPrice.add(laborcost.getPrice());
					}
				}
				// String laborcostsJson = JsonUtils.toJson(laborcostlist);
				// 封装
				ServiceMode serviceMode = new ServiceMode();
				serviceMode.setServiceModelEntity(serviceModelEntity);
				serviceMode.setServiceEntity(serviceEntity);
				// serviceMode.setModelDetailEntity(modelEntity);

				// serviceMode.setProductsJson(productsJson);
				// serviceMode.setLaborcostsJson(laborcostsJson);
				serviceMode.setProductList(productList);
				serviceMode.setLaborcostlist(laborcostlist);
				// serviceMode.setLaborcostsPrice(laborcostPrice);
				// serviceMode.setProductsPrice(productPrice);
				return serviceMode;
			}
		}
		return null;
	}

	@Override
	public List<com.msds.km.vo.Service> findServiceLists(Integer modelId,
			Integer cityId) {

		return serviceMapper.findServiceLists(modelId, cityId);
	}
	
	

	@Transactional(rollbackFor=Exception.class)
	@Override
	public String batchInsertLists(ServiceModelEntity entity) {
		batchInsertData(entity);		
		return null;
	}

	private void batchInsertData(ServiceModelEntity entity) {
		String param = entity.getLaborcostJson();
		String costjson = objCovertJson(param);
		Date date = new Date();
		String[] modelIDs = dealModelLists(entity.getModelId());		
		for(String modelId :modelIDs){
			ServiceModelEntity serviceModel = new ServiceModelEntity();
			String sn = codeGenerator.getCode(CodeType.SERVICE_MODEL_CODE_PREFIX, "",
					CodeTypeEnum.service_model_code.getId());
			serviceModel.setServiceModelCode(sn);	
			serviceModel.setModelId(modelId);		
			serviceModel.setLaborcostJson(costjson);
			serviceModel.setCreateDate(date);
			serviceModel.setModifyDate(date);
			serviceModel.setMileage(entity.getMileage());
			serviceModel.setOperator(entity.getOperator());
			serviceModel.setPrice(entity.getPrice());
			serviceModel.setServiceCode(entity.getServiceCode());
			serviceModelMapper.add(serviceModel);	
		}
	}
	
	public String[] dealModelLists(String param){
		String[] result = null;
		if(param != null){
			result = param.split(",");
		}
		return result;
	}
	
	class Labor {

		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
	}
	
	public String objCovertJson(String param){
		List<Labor> list = new ArrayList<Labor>();
		if(param != null){
		String [] ids = param.split(",");
		Labor lb = null;
		for (String id : ids) {
			lb = new Labor();
			lb.setId(id);
			list.add(lb);
		}
		}
		if(list.size()<=0){
			Labor lb = new Labor();
			lb.setId("1");//默认1是免工时费
			list.add(lb);
		}
		return JsonUtils.toJson(list);
	}
	

	@Override
	public ServiceModelEntity findSmById(Object id) throws Exception {
		ServiceModelEntity serviceModelEntity = super.findById(id);
		String labor = serviceModelEntity.getLaborcostJson();
		labor = convertJsonToObj(labor);
		serviceModelEntity.setLaborcostJson(labor);
		return serviceModelEntity;
	}

	private String convertJsonToObj(String labor) throws IOException {
		StringBuffer sb = new StringBuffer();
		if(labor != null){
		List<LinkedHashMap> list = JsonUtils.toObjectList(labor, LinkedHashMap.class);
		for (LinkedHashMap labor2 : list) {		
			sb.append(labor2.get("id")+",");
		}
		}
		return sb.toString();
	}

	@Transactional
	@Override
	public String batchUpdateLists(ServiceModelEntity entity) {
		//1.删除当前数据
	    super.delete(entity.getId());
		//2.批量插入数据
	    batchInsertData(entity);
		return null;
	}

	@Override
	public List<ServiceModelVo> queryServiceModelByList(BasePage page)
			throws Exception {		
			Integer rowCount = queryByCount(page);
			page.getPager().setRowCount(rowCount);
			return baseMapper().queryServiceModelByList(page);
	}
	
	
	
	

}
