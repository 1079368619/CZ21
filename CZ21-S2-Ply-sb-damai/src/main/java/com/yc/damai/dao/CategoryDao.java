package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Category;

@Repository
public class CategoryDao extends BaseDao {

	private RowMapper<Category> cm = new RowMapper<Category>() {

		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category c = new Category();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			return c;
		}
		
	};
	
	public List<Category> queryAllCategory(){
		String sql = "select * from category";
		return jt.query(sql, cm);
	}
}
