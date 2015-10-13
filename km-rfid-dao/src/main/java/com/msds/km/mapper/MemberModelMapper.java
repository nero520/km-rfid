package com.msds.km.mapper;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.MemberModelEntity;

/**
 * 
 * <br>
 * <b>功能：</b>MemberModelMapper<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
public interface MemberModelMapper extends BaseMapper<MemberModelEntity> {

	public void delByIdAndMemberId(MemberModelEntity memberModelEntity);


	public void updateByMemberId(MemberModelEntity param);
	


	/**
	 * 查询会员车型
	 * 
	 * @Description TODO
	 * @param memberId
	 *            会员
	 * @param modeId
	 *            车型
	 * @return
	 * @return MemberModelEntity
	 */
	public MemberModelEntity findByMemberIdModelId(
			@Param("memberId") Integer memberId, @Param("modelId") Integer modelId);


	/**
	 * 除了本人以外不能有重复牌照
	 * @param memberModelEntity
	 * @return
	 */
	public Integer isExists(MemberModelEntity memberModelEntity);


	/**
	 * 
	 * 查询默认爱车
	 * @param memberId
	 * @return
	 */
	public MemberModelEntity queryDefaultById(Integer memberId);

}
