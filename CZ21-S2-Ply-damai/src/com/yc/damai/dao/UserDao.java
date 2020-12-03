package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.damai.biz.BizException;
import com.yc.damai.po.User;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.Utils;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class UserDao {

	private UserMapper um = new UserMapper();
	
	public static class UserMapper implements ResultSetMapper<User>{
		
		@Override
		public User map(ResultSet rs) throws SQLException {
			User u = new User();
			u.setUid(rs.getInt("uid"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPhone(rs.getString("phone"));
			u.setSex(rs.getString("sex"));
			u.setState(rs.getInt("state"));
			u.setCode(rs.getString("code"));
			u.setAddr(rs.getString("addr"));
			return u;
		}
	}
	
	
	public void insert(User user) throws SQLException{
		String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
		DBHelper.update(sql, user.getUsername(), user.getPassword(),
				user.getName(), user.getEmail(), user.getPhone(), 
				user.getSex(), user.getCode(),user.getAddr());
	}

	
	public List<User> selectAll() {
		String sql = "select * from user";
		try {
			return DBHelper.selectList(sql, um);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> selectByName(String username) throws SQLException {
		String sql = "select * from user where username = ?";
		try {
			return DBHelper.selectList(sql, um, username);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/**
	public Object selectByUNameAndPwD(String username,String password) throws SQLException, BizException {
		String sql = "select * from user where username = ?";
		Map<String, Object> m;
		m = DBHelper.selectOne(sql, username);
			m = DBHelper.selectlistMap(sql,username).get(0);
		if(m == null) {
			throw new BizException("请检查用户名是否正确！");
		}else {
			sql = sql + " and password = ? ";
			m = DBHelper.selectOne(sql, username, password);
			if(m == null) {
				throw new BizException("密码错误！");
			}
		}
		return m;
	}*/
	
	public List<User> selectByUNameAndPwD(String username, String password) throws SQLException {
		String sql = "select * from user where username = ?";
		try {
			List<User> list = DBHelper.selectList(sql, um, username);
			if(list.get(0) == null) {
				throw new BizException("请检查用户名是否正确！");
			}else {
				sql = sql + " and password = ? ";
				list = DBHelper.selectList(sql, um, username, password);
				if(list.get(0) == null) {
					throw new BizException("密码错误！");
				}
			}
			return list;
		} catch (BizException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String queryName(String name) throws SQLException {
		String loginname =  name;
		return loginname;
	}
}