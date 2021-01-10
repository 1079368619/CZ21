package com.yc.damai.biz;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.damai.dao.UserDao;
import com.yc.damai.po.User;
import com.yc.damai.util.Utils;

@Service
public class UserBiz {

	@Resource
	private UserDao udao;
	
	@Resource
	private MailBiz mbiz;
	
	public String sendVcode(String name) {
		User user = udao.selectByName(name);
		//生成随机验证码
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-4);
		mbiz.sendSimpleMail(user.getEmail(), "密码重置验证码", "请使用"+vcode+"验证码来重置密码");
		return vcode;
	}
	
	
	/**
	 * 注册
	 * @param user
	 * @throws BizException
	 * @throws SQLException 
	 */
	public void register(User user) throws BizException {
		//字段验证
		Utils.checkNull(user.getUsername(), "用户名不能为空");
		Utils.checkNull(user.getPassword(), "密码不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		Utils.checkNull(user.getName(), "昵称不能为空");
		Utils.checkNull(user.getSex(), "性别不能为空");
		Utils.checkNull(user.getAddr(), "地址不能为空");
		
		try {
			/*同用户名验证*/
			String username = user.getUsername();
			User duser = udao.selectByName(username);
			if(duser != null ) {
				throw new BizException("该用户名已经被注册");
			}
			
			//写入数据库
			udao.insert(user);
		} catch (SQLException e) {
			throw new BizException("注册失败，请联系管理员！", e);
		}
	}
	
	/**
	 * login 方法要返回登录的用户对象
	 * @param user
	 * @return
	 * @throws BizException
	 * @throws SQLException
	 */
	public User login(String username, String password, String vcode,HttpSession session) throws BizException, SQLException {
		//字段验证
		Utils.checkNull(username, "请输入用户名");
		Utils.checkNull(password, "请输入密码");
		Utils.checkNull(vcode, "请输入验证码");
		
		User user = new User();
		user = udao.selectByName(username);
		if(user == null) {
			throw new BizException("请检查用户名是否正确");
		}
	
		if( !user.getPassword().equals(password)  ) {
			throw new BizException("密码错误");
		}
		String svcode = (String) session.getAttribute("vcode");
		if( !vcode.equalsIgnoreCase(svcode)) {
			throw new BizException("验证码错误");
		}
		return user;
	}
	
}
