package com.yc.damai.biz;

import java.sql.SQLException;
import java.util.List;

import com.yc.damai.dao.UserDao;
import com.yc.damai.po.User;
import com.yc.damai.util.Utils;

public class UserBiz {

	private UserDao dao = new UserDao();
	
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
			List<User> list = dao.selectByName(username);
			boolean flag = true;
			if(list.contains(username)) {
				System.out.println("no");
				flag = false;
			}else {
				System.out.println("yes-"+ list.get(0).getUid()+"-"+list.get(0).getUsername());
				flag = true;
			}
			if(flag == true) {
				throw new BizException("该用户名已经存在！");
			}
			//写入数据库
			dao.insert(user);
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
	public List<User> login(User user) throws BizException, SQLException {
		String username = user.getUsername();
		String password = user.getPassword();
		//字段验证
		Utils.checkNull(username, "请输入用户名");
		Utils.checkNull(password, "请输入密码");
		
		List<User> dbuser = dao.selectByUNameAndPwD(username, password);
		if(dbuser.get(0) == null) {
			throw new BizException("该用户名已经存在！");
		}
		return dbuser;
	}
	
}
