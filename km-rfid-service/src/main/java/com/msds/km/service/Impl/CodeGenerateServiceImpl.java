package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.CodeGenerateMapper;
import com.msds.km.entity.CodeGenerateEntity;
import com.msds.km.service.CodeGenerateService;

/**
 * 
 * <br>
 * <b>功能：</b>CodeGenerateService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:37 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("codeGenerateService")
public class CodeGenerateServiceImpl extends BaseServiceImpl<CodeGenerateEntity> implements CodeGenerateService{

	@Autowired
    private CodeGenerateMapper codeGenerateMapper;
		
	public CodeGenerateMapper baseMapper() {
		return codeGenerateMapper;
	}

}
