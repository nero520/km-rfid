package com.msds.km.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.common.BasePage;
import com.msds.km.entity.ServiceModelEntity;
import com.msds.km.vo.ServiceModelVo;

/**
 * 
 * <br>
 * <b>功能：</b>ServiceModelMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-29 10:57:16 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface ServiceModelMapper extends BaseMapper<ServiceModelEntity> {

	/**
	 * 查询服务车型数据
	 * 
	 * @Description TODO
	 * @param serviceId
	 * @param modeId
	 * @return
	 * @return ServiceModeEntity
	 */
	ServiceModelEntity findByCodeMId(@Param("serviceCode")String serviceCode,@Param("modeId") Integer modeId);
	
	
	
	public List<ServiceModelVo> queryServiceModelByList(BasePage page);

}
