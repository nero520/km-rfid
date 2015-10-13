package com.msds.km.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.common.BasePage;
import com.msds.km.entity.CompanyEntity;
/**
 * 
 * <br>
 * <b>功能：</b>CompanyMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface CompanyMapper extends BaseMapper<CompanyEntity> {

	/**
	 * 
	 * 根据服务code查询相关维修厂信息
	 * @param serviceCode
	 * @return
	 */
	List<CompanyEntity> findListByserviceCode(String serviceCode);

	/**
	 * 
	 * 通过账号查询相关信息（修理厂登录使用）
	 * @param username
	 * @return
	 */
	CompanyEntity queryByUserName(String username);
	
	/**
	 * 模糊查询修理厂列表
	 */
	List<CompanyEntity> findCompanyList(BasePage page);
	/**
	 * 模糊查询修理厂列表
	 */
	Integer queryCompanyCount(BasePage page);

	/**
	 * 
	 * 修改密码
	 * @param id
	 * @param newps
	 * @param oldps
	 * @return
	 */
	int updatePs(@Param("id")Integer id,@Param("newps") String newps,@Param("oldps") String oldps);
	
}
