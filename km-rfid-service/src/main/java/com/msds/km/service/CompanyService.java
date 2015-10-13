package com.msds.km.service;

import java.util.List;
import java.util.Map;

import com.msds.base.service.BaseService;
import com.msds.common.BasePage;
import com.msds.km.entity.CompanyEntity;

/**
 * 
 * <br>
 * <b>功能：</b>CompanyService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface CompanyService extends BaseService<CompanyEntity> {

	/**
	 * 
	 * 根据服务code查询相关维修厂信息
	 * @param serviceCode
	 * @return
	 */
	List<CompanyEntity> findListByserviceCode(String serviceCode);
	
	public Map<Integer,CompanyEntity> getCompanyMap();
	
	/**
	 * 
	 * 通过账号查询相关信息（修理厂登录使用）
	 * @param username
	 * @return
	 */
	public CompanyEntity queryByUserName(String username);
	
	public List<CompanyEntity> findCompanyList(BasePage page);

	/**
	 * 
	 * 修改密码
	 * @param id 用户id
	 * @param newps 新密码
	 * @param oldps 老密码
	 * @return
	 */
	int updatePs(Integer id,String newps, String oldps);

}
