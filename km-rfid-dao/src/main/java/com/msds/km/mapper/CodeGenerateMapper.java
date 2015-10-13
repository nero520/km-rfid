package com.msds.km.mapper;


import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.CodeGenerateEntity;
/**
 * 
 * <br>
 * <b>功能：</b>CodeGenerateMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2014-10-08 14:14:02 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface CodeGenerateMapper extends BaseMapper<CodeGenerateEntity> {
	
	public CodeGenerateEntity getEntity(@Param("codeType")int codeType,@Param("prefix")String prefix,
			@Param("suffix")String suffix,@Param("dateStr")String dateStr);
}
