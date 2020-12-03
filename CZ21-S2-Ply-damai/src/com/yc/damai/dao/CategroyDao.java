package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.po.Category;
import com.yc.damai.po.Product;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class CategroyDao {

	private CategroyMapper cm = new CategroyMapper();
	
	public static class CategroyMapper implements ResultSetMapper<Category>{
		
		@Override
		public Category map(ResultSet rs) throws SQLException {
			Category c = new Category();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			return c;
		}
	}
	
	
	public List<Category> queryAll(){
		String sql = "select * from category";
		try {
			return DBHelper.selectList(sql, cm);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
