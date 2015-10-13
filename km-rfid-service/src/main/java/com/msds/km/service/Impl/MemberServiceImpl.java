package com.msds.km.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.MemberMapper;
import com.msds.km.entity.MemberEntity;
import com.msds.km.service.MemberService;

/**
 * 
 * <br>
 * <b>功能：</b>MemberService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-04-24 11:18:36 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<MemberEntity> implements MemberService{

	@Autowired
    private MemberMapper memberMapper;
		
	public MemberMapper baseMapper() {
		return memberMapper;
	}

}
