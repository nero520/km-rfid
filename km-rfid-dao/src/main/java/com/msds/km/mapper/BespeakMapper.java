package com.msds.km.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.msds.base.mapper.BaseMapper;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.vo.BespeakOrderDetailVo;
/**
 * 
 * <br>
 * <b>功能：</b>BespeakMapper<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-04-22 14:21:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */ 
public interface BespeakMapper extends BaseMapper<BespeakEntity> {
	
	
	public List<BespeakEntity> getBespeakList(BespeakEntity entity);
	
	public int getBespeakListCount(BespeakEntity entity);
	

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void addBespeak(BespeakEntity entity)
			throws Exception;
	
	/**
	 * 
	 * @param bespeakSn
	 * @return
	 */
	public BespeakEntity findByBespeakId(BespeakEntity bespeakEntity);
	
	
	public List<ProcessEntity> getFirstLevel();
	
	public List<ProcessEntity> getSecondById(Integer id);
	
	public List<MemberEntity> getMemberList(MemberEntity member);
	
	public List<BespeakEntity> getBespeakModelList(BespeakEntity bespeakEntity);
	
	public int queryBespeakCount(BespeakEntity bespeakEntity);

	public BespeakEntity findDetailedBySnAndCompanyId(@Param("bespeakSn")String bespeakSn,@Param("companyId")Integer companyId);
	
	/**
	 * 
	 * 通过修理厂Id与预约单查询详情列表
	 * @param bespeakSn
	 * @param id
	 * @return
	 */
	public BespeakOrderDetailVo findBespeakOrderInfo(@Param("bespeakSn")String bespeakSn,@Param("id") Integer id);
	
	/**
	 * 车主预约单消息列表
	 * @param bespeakEntity
	 * @return
	 */
	public List<BespeakEntity> getMemberBespeakList(BespeakEntity bespeakEntity);
	public int queryMemberBespeakCount(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单消息列表
	 * @param bespeakEntity
	 * @return
	 */
	public List<BespeakEntity> queryBespeakList(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单明细
	 * @param bespeakEntity
	 * @return
	 */
	public BespeakEntity findDetailByBespeak(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单条数
	 * @param bespeakEntity
	 * @return 
	 * @author lijingkun
	 * int
	 */
	public int queryByBespeakCount(BespeakEntity bespeakEntity);
	
	/**
	 * 预约单列表（菜单使用）
	 * @param bespeakEntity
	 * @return 
	 * List<BespeakEntity>
	 */
	public List<BespeakEntity> findBespeakList(BespeakEntity bespeakEntity);

}
