package com.yc.vue.d1128.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.vue.d1128.bean.User;
import com.yc.vue.dyg.util.DBHelper;

public class UserDao {

	public void insert(User user) throws SQLException {
		String sql = "insert into user values(null,?,?,?,?,?,default)";
		DBHelper.update(sql, user.getPhone(),user.getEmail(),user.getName(),user.getHead(),user.getPwd());
	}
	
	public User selectByName(String name) {
		String sql = "select * from user where name = ?";
		List<User> list = null;
		//list = DBHelper.selectList(sql, new ResultSetMapper<>, params)
		return null;
	}
	
}
