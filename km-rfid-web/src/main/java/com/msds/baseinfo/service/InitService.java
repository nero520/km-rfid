package com.msds.baseinfo.service;

import java.util.List;

import com.msds.baseinfo.entity.InitForm;
import com.msds.baseinfo.entity.ProductDetail;


public interface InitService {

	public List<InitForm> getCategoryList(InitForm group);
	
	public List<InitForm> getCategoryAllList();
	
	public List<ProductDetail> getProductList(ProductDetail init);
	
	public List<ProductDetail> getProductDetailList(ProductDetail init);
	
	public List<InitForm>  getProductCategoryList(InitForm init);
	
	public List<InitForm> getCategoryIds(InitForm init);
	
	public void deleteCategoryByProductId(Integer productId);
	
	public void saveProductCategory(InitForm init);
	
	public List<InitForm> getProductJoinList(InitForm init);
	
	public void updateStatus(ProductDetail init);
	
}
