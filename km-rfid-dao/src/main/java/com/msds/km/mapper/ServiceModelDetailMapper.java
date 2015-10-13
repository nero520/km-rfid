package com.msds.km.mapper;

import java.util.List;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.ServiceModelDetailEntity;
import com.msds.km.vo.Product;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelDetailMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ServiceModelDetailMapper extends
		BaseMapper<ServiceModelDetailEntity> {

	/**
	 * 查询所需商品信息集合
	 * 
	 * @Description TODO
	 * @param string
	 * @return
	 * @return List<Product>
	 */
	List<Product> findProductListByServiceModelCode(String string);

	/**
	 * 查询品牌为显示的车型信息
	 * 
	 * @return List<ServiceModelDetailEntity>
	 */
	public List<ServiceModelDetailEntity> findByBrandIsShow();

}
