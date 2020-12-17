package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.CategorySecond;

@Repository
public class CategorySecondDao extends BaseDao {

	private RowMapper<CategorySecond> csm = new RowMapper<CategorySecond>() {

		@Override
		public CategorySecond mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategorySecond cs = new CategorySecond();
			cs.setCsid(rs.getInt("csid"));
			cs.setCsname(rs.getString("csname"));
			cs.setCid(rs.getInt("cid"));
			return cs;
		}
	};
	
	public List<CategorySecond> queryAllCategorySecond(){
		String sql = "select * from categorysecond";
		return jt.query(sql, csm);
		
	}
}
