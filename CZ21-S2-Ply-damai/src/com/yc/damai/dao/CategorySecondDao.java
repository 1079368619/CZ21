package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yc.damai.po.CategorySecond;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class CategorySecondDao {

	public static class CategorySecondMapper implements ResultSetMapper<CategorySecond>{
		
		@Override
		public CategorySecond map(ResultSet rs) throws SQLException {
			CategorySecond cs = new CategorySecond();
			cs.setCsid(rs.getInt("csid"));
			cs.setCsname(rs.getString("csname"));
			cs.setCid(rs.getInt("cid"));
			return cs;
		}
	}
}
