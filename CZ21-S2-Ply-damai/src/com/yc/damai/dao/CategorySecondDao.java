package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.dao.CategroyDao.CategroyMapper;
import com.yc.damai.po.Category;
import com.yc.damai.po.CategorySecond;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class CategorySecondDao {

	private CategorySecondMapper csm = new CategorySecondMapper();
	
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
	
	public List<CategorySecond> queryAllCategory(){
		String sql = "select * from categorysecond";
		try {
			return DBHelper.selectList(sql, csm);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
