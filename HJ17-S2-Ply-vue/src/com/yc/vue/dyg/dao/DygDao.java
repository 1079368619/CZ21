package com.yc.vue.dyg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.vue.dyg.bean.DygCategory;
import com.yc.vue.dyg.bean.DygMovie;
import com.yc.vue.dyg.util.DBHelper;
import com.yc.vue.dyg.util.DBHelper.ResultSetMapper;

public class DygDao {

	public List<DygCategory> selectAllCategory() throws SQLException{
		String sql = "select * from dyg_category";
		List<DygCategory> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygCategory>(){

			@Override
			public DygCategory map(ResultSet rs) throws SQLException {
				DygCategory dc = new DygCategory();
				dc.setId(rs.getInt("id"));
				dc.setName(rs.getString("name"));
				dc.setSn(rs.getString("sn"));
				return dc;
			}
				
		});
		return list;
	}
	
	public List<DygMovie> selectIndexYs() throws SQLException{
		String sql = "select * from dyg_category";
		List<DygMovie> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygMovie>(){

			@Override
			public DygMovie map(ResultSet rs) throws SQLException {
				DygMovie dm = new DygMovie();
				dm.setId(rs.getInt("id"));
				dm.setName(rs.getString("name"));
				dm.setPoster(rs.getString("poster"));
				dm.setCreateDate(rs.getInt("create_date"));
				
				return dm;
			}
			
		});
		return list;
	}
	
}
