package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.biz.BizException;
import com.yc.damai.po.User;

@Repository
public class UserDao extends BaseDao {

	private RowMapper<User> um = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		
	};
	
	
	public void insert(User user) throws SQLException{
		String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
		jt.update(sql, user.getUsername(), user.getPassword(),
				user.getName(), user.getEmail(), user.getPhone(), 
				user.getSex(), user.getCode(),user.getAddr());
	}

	
	public List<User> selectAll() {
		String sql = "select * from user";
		return jt.query(sql, um);
		
	}
	
	public User selectByName(String username) {
		String sql = "select * from user where username = ?";
		return jt.query(sql, rs -> {
			return rs.next() ? um.mapRow(rs, -1) : null;
		}, username);
	}
	
	public List<User> selectByUNameAndPwD(String username, String password) throws SQLException {
		String sql = "select * from user where username = ?";
		try {
			List<User> list = jt.query(sql, um, username);
			if(list.get(0) == null) {
				throw new BizException("请检查用户名是否正确！");
			}else {
				sql = sql + " and password = ? ";
				list = jt.query(sql, um, username, password);
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
	
	public String queryName(String name) {
		String loginname =  name;
		return loginname;
	}
}
