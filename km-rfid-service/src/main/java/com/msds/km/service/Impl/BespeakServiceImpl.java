package com.msds.km.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.BespeakEntity;
import com.msds.km.entity.MemberEntity;
import com.msds.km.entity.ProcessEntity;
import com.msds.km.mapper.BespeakMapper;
import com.msds.km.service.BespeakService;
import com.msds.km.vo.BespeakOrderDetailVo;

/**
 * 
 * <br>
 * <b>功能：</b>BespeakServiceImpl<br>
 * <b>作者：</b>zhengxd<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("bespeakService")
public class BespeakServiceImpl extends BaseServiceImpl<BespeakEntity>
		implements BespeakService {

	@Autowired
	private BespeakMapper bespeakMapper;

	public BespeakMapper baseMapper() {
		return bespeakMapper;
	}

	@Override
	public void updateBespeak(BespeakEntity entity) {

		bespeakMapper.update(entity);
	}

	@Override
	public void addBespeak(BespeakEntity entity) throws Exception {

		bespeakMapper.addBespeak(entity);
	}

	@Override
	public BespeakEntity findByBespeakId(BespeakEntity entity) {

		return bespeakMapper.findByBespeakId(entity);
	}

	@Override
	public List<ProcessEntity> getFirstLevel() {
		// TODO Auto-generated method stub
		return bespeakMapper.getFirstLevel();
	}

	@Override
	public List<ProcessEntity> getSecondById(Integer id) {
		// TODO Auto-generated method stub
		return bespeakMapper.getSecondById(id);
	}

	@Override
	public List<MemberEntity> getMemberList(MemberEntity member) {
		// TODO Auto-generated method stub
		return bespeakMapper.getMemberList(member);
	}
	
	@Override
	public List<BespeakEntity> getBespeakList(BespeakEntity entity){
		return bespeakMapper.getBespeakList(entity);
	}
	
	@Override
	public int getBespeakListCount(BespeakEntity entity){
		return bespeakMapper.getBespeakListCount(entity);
	}

	@Override
	public BespeakOrderDetailVo findBespeakOrderInfo(String bespeakSn, Integer id) {
		
		return bespeakMapper.findBespeakOrderInfo(bespeakSn, id);
	}

	@Override
	public BespeakEntity findDetailedBySnAndCompanyId(String bespeakSn,
			Integer companyId) throws Exception {
		
		return bespeakMapper.findDetailedBySnAndCompanyId(bespeakSn, companyId);
	}

	@Override
	public List<BespeakEntity> getMemberBespeakList(BespeakEntity bespeakEntity) {
		Integer rowCount = bespeakMapper.queryMemberBespeakCount(bespeakEntity);
		bespeakEntity.getPager().setRowCount(rowCount);
		return bespeakMapper.getMemberBespeakList(bespeakEntity);
	}

	@Override
	public List<BespeakEntity> queryBespeakList(BespeakEntity bespeakEntity) {
		Integer rowCount = bespeakMapper.getBespeakListCount(bespeakEntity);
		bespeakEntity.getPager().setRowCount(rowCount);
		return bespeakMapper.queryBespeakList(bespeakEntity);
	}

	@Override
	public BespeakEntity findDetailByBespeak(BespeakEntity bespeakEntity) {
		return bespeakMapper.findDetailByBespeak(bespeakEntity);
	}

	@Override
	public List<BespeakEntity> findBespeakList(BespeakEntity bespeakEntity) {
		Integer rowCount = bespeakMapper.queryByBespeakCount(bespeakEntity);
		bespeakEntity.getPager().setRowCount(rowCount);
		return bespeakMapper.findBespeakList(bespeakEntity);
	}
	

}
