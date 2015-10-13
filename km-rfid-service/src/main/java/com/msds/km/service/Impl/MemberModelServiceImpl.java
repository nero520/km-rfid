package com.msds.km.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.entity.MemberModelEntity;
import com.msds.km.enums.MemberModelTypeEnum;
import com.msds.km.mapper.MemberModelMapper;
import com.msds.km.service.MemberModelService;

/**
 * 
 * <br>
 * <b>功能：</b>MemberModelService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("memberModelService")
public class MemberModelServiceImpl extends BaseServiceImpl<MemberModelEntity> implements MemberModelService{


	@Autowired
    private MemberModelMapper memberModelMapper;
		
	public MemberModelMapper baseMapper() {
		return memberModelMapper;
	}

	@Override
	@Transactional
	public void saveMemberModel(MemberModelEntity memberModelEntity) {
	
		MemberModelEntity result =  this.queryDefaultById(memberModelEntity.getMemberId());
		/*
		//1.先更改默认爱车
		MemberModelEntity param = new MemberModelEntity();
		param.setMemberId(memberModelEntity.getMemberId());
		param.setDefaultFlag(MemberModelTypeEnum.notype.getId());		
		memberModelMapper.updateByMemberId(param);*/
		if(result == null){
		//2.保存爱车
		memberModelEntity.setDefaultFlag(MemberModelTypeEnum.type.getId());
		}else{
		memberModelEntity.setDefaultFlag(MemberModelTypeEnum.notype.getId());	
		}
		Date date = new Date();
		memberModelEntity.setCreateDate(date);
		memberModelEntity.setModifyDate(date);
		memberModelMapper.add(memberModelEntity);
	}

	@Override
	@Transactional
	public void delMemberModel(MemberModelEntity memberModelEntity) {	
		
		MemberModelEntity param3 = new MemberModelEntity();
		param3.setMemberId(memberModelEntity.getMemberId());
	    param3.setId(memberModelEntity.getId());	
		memberModelMapper.delByIdAndMemberId(memberModelEntity);
		
		if(1== memberModelEntity.getDefaultFlag()){
		//1.查询爱车列表
		MemberModelEntity param = new MemberModelEntity();
		param.setMemberId(memberModelEntity.getMemberId());
		param.setSortField("modify_date");
		param.setSortOrder("desc");	
		List<MemberModelEntity> datalists = memberModelMapper.queryByList(param);
		//2.修改默认状态
		if(datalists != null && datalists.size()>0){
			MemberModelEntity member = datalists.get(0);
			MemberModelEntity member2 = new MemberModelEntity();
			member2.setMemberId(member.getMemberId());
			member2.setDefaultFlag(MemberModelTypeEnum.type.getId());
			member2.setId(member.getId());
			memberModelMapper.update(member2);
		}
		}
	}

	@Override
	@Transactional
	public void updateFlag(MemberModelEntity memberModelEntity) {
		//1.先更改默认爱车
		MemberModelEntity param = new MemberModelEntity();
		param.setMemberId(memberModelEntity.getMemberId());
		param.setDefaultFlag(MemberModelTypeEnum.notype.getId());		
		memberModelMapper.updateByMemberId(param);
		param.setDefaultFlag(MemberModelTypeEnum.type.getId());
		param.setId(memberModelEntity.getId());
		param.setModifyDate(new Date());
		memberModelMapper.update(param);
		
	}

	@Override
	public boolean isExists(MemberModelEntity memberModelEntity) {
	
		return memberModelMapper.isExists(memberModelEntity)>0;
	}

	@Override
	public MemberModelEntity queryDefaultById(Integer memberId) {
		
		return memberModelMapper.queryDefaultById(memberId);
	}
	
	

	
	
	
}
