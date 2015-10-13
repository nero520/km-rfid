package com.msds.km.service;

import com.msds.base.service.BaseService;
import com.msds.km.entity.MemberModelEntity;

/**
 * 
 * <br>
 * <b>功能：</b>MemberModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface MemberModelService extends BaseService<MemberModelEntity> {
	
	/**
	 * 保存我的爱车
	 * @param memberModelEntity
	 */
	public void saveMemberModel(MemberModelEntity memberModelEntity);
	
	/**
	 * 默认爱车设置
	 * @param memberModelEntity
	 */
	public void updateFlag(MemberModelEntity memberModelEntity);
	
	/**
	 * 删除爱车
	 * @param memberModelEntity
	 */
	public void delMemberModel(MemberModelEntity memberModelEntity);
	
	
    /**
     * 
     * 除了本人以外不能有重复牌照
     * @param memberModelEntity
     * @return
     */
	boolean isExists(MemberModelEntity memberModelEntity);

	/**
	 * 
	 * 查询默认爱车
	 * @param memberId
	 * @return
	 */
	public MemberModelEntity queryDefaultById(Integer memberId);

}
