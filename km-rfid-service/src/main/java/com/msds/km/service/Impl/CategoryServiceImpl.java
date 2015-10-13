package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.CategoryMapper;
import com.msds.km.entity.CategoryEntity;
import com.msds.km.service.CategoryService;

/**
 * 
 * <br>
 * <b>功能：</b>CategoryService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:37 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<CategoryEntity> implements CategoryService{

	@Autowired
    private CategoryMapper categoryMapper;
		
	public CategoryMapper baseMapper() {
		return categoryMapper;
	}

}
