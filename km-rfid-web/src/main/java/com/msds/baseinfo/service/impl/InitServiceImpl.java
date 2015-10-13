package com.msds.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.baseinfo.entity.InitForm;
import com.msds.baseinfo.entity.ProductDetail;
import com.msds.baseinfo.mapper.InitMapper;
import com.msds.baseinfo.service.InitService;


@Service
public class InitServiceImpl implements InitService {
	@Autowired
	private InitMapper initMapper;

	@Transactional
	public List<InitForm> getCategoryList(InitForm group) {
		List<InitForm> permissionList=initMapper.getCategoryList(group);
		
		return permissionList;
	}
	
	@Transactional
	public List<InitForm> getCategoryAllList() {
		List<InitForm> permissionList=initMapper.getCategoryAllList();
		
		return permissionList;
	}
	
	public List<ProductDetail> getProductDetailList(ProductDetail init){
		return initMapper.getProductDetailList(init);
	}
	
	public List<ProductDetail> getProductList(ProductDetail init){
		return initMapper.getProductList(init);
	}
	
	public List<InitForm>  getProductCategoryList(InitForm init){
		return initMapper.getProductCategoryList(init);
	}

	@Override
	public List<InitForm> getCategoryIds(InitForm init) {
		// TODO Auto-generated method stub
		return initMapper.getCategoryIds(init);
	}

	@Override
	public void deleteCategoryByProductId(Integer productId) {
		// TODO Auto-generated method stub
		initMapper.deleteCategoryByProductId(productId);
	}

	@Override
	public void saveProductCategory(InitForm init) {
		// TODO Auto-generated method stub
		initMapper.saveProductCategory(init);
	}
	
	
	public List<InitForm> getProductJoinList(InitForm init){
		return initMapper.getProductJoinList(init);
	}
	
	public void updateStatus(ProductDetail init){
		initMapper.updateStatus(init);
	}
}
