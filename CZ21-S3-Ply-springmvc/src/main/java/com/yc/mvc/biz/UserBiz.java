package com.yc.mvc.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;

@Service
public class UserBiz {

	@Resource
	private UserMapper um; 
	
	public JsjUser login(JsjUser user) throws BizException {
		if ("".equals(user.getAccount()) && null==user.getAccount()) {
			throw new BizException("用户名为空！");
		}
		if ("".equals(user.getPwd()) && null==user.getPwd()) {
			throw new BizException("密码为空！");
		}
		JsjUser dbuser = um.selectByname(user.getAccount());
		if(dbuser == null || !dbuser.getPwd().equals(user.getPwd())) {
			throw new BizException("用户名或密码错误"); 
		}
		return dbuser;
	}

	public int regist(JsjUser user) {
		int i = um.insert(user.getAccount(), user.getName(), user.getPwd(), user.getPhone(), user.getEmail());
		if(i>0) {
			return i;
		}else {
			return 0;
		}
	}

	public void updataHeadImg(JsjUser loginedUser) {
		um.updataHeadImg(loginedUser);
	}
}
