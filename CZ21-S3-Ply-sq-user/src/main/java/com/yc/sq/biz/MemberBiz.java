package com.yc.sq.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.sq.bean.SqMember;
import com.yc.sq.bean.SqMemberExample;
import com.yc.sq.dao.SqMemberMapper;

@Service
public class MemberBiz {

	@Resource
	private SqMemberMapper sum;
	
	public SqMember login(SqMember sm) throws BizException {
		SqMemberExample example = new SqMemberExample();
		example.createCriteria()
			.andNameEqualTo(sm.getName())
			.andPwdEqualTo(sm.getPwd());
		List<SqMember> list = sum.selectByExample(example);
		if(list.isEmpty()) {
			throw new BizException("");
		}
		return list.get(0);
	}
}
