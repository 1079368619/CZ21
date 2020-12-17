package com.yc.CZ21S2Plyspringboot.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.CZ21S2Plyspringboot.dao.Account;
import com.yc.CZ21S2Plyspringboot.dao.AccountDao;

@Service
public class BankBiz {

	@Resource
	private AccountDao adao;
	
	@Resource
	private MailBiz mbiz;
	
	public String sendVcode(String name) {
		//
		Account a = adao.selectByName(name);
		//
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		mbiz.sendSimpleMail(a.getEmail(), "密码重置验证码", "请使用" + vcode + "验证码重置你的密码");
		return vcode;
	}

	public String resetPwd(String name, String vcode, String pwd, String sessionVcode) {
		if(vcode.equalsIgnoreCase(sessionVcode)) {
			adao.updatePwdByName(pwd, name);
			return "密码重置成功！";
		}else {
			return "验证码错误！";
		}
	}

}
