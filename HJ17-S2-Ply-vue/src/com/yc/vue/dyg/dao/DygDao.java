package com.yc.vue.dyg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.vue.dyg.bean.DygCategory;
import com.yc.vue.dyg.bean.DygMovie;
import com.yc.vue.dyg.bean.DygMovieWithBLOBs;
import com.yc.vue.dyg.bean.DygMsg;
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
	
	/**
	 * 查找最新电影
	 * @return
	 * @throws SQLException
	 */
	public List<DygMovie> selectIndexYs() throws SQLException{
		String sql = "select * from dyg_movie where category='ys' order by create_date desc limit 0,16";
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
	

	//
	public DygMovieWithBLOBs selectById(String id) throws SQLException {
		String sql = "select * from dyg_movie where id=?";
		List<DygMovieWithBLOBs> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygMovieWithBLOBs>(){

			@Override
			public DygMovieWithBLOBs map(ResultSet rs) throws SQLException {
				DygMovieWithBLOBs dmwb = new DygMovieWithBLOBs();
				dmwb.setId(rs.getInt("id"));
				dmwb.setName(rs.getString("name"));
				dmwb.setPoster(rs.getString("poster"));
				dmwb.setCreateDate(rs.getInt("create_date"));
				dmwb.setIntro(rs.getString("intro"));
				return dmwb;
			}
			
		}, id);
		return list.get(0);
	}
	
	public void insertMsg(DygMsg msg) throws SQLException{
		String sql = "insert into dyg_msg value(null,?,?,?,now(),null,null) ";
		DBHelper.update(sql, 
				msg.getName(),
				msg.getEmail(),
				msg.getContent());
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<DygMsg> selectAllMsg() throws SQLException{
		String sql = "select * from dyg_msg";
		List<DygMsg> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<DygMsg>(){

			@Override
			public DygMsg map(ResultSet rs) throws SQLException {
				DygMsg dm = new DygMsg();
				dm.setId(rs.getInt("id"));
				dm.setName(rs.getString("name"));
				dm.setContent(rs.getString("content"));
				dm.setCreateTime(rs.getTimestamp("create_time"));
				if(rs.getString("reply")==null || rs.getString("reply").isEmpty()) {
					return dm;
				}else {
					dm.setReply(rs.getString("reply"));
					dm.setReplyTime(rs.getDate("reply_time"));
				}
				return dm;
			}
				
		});
		return list;
	}
	
	/**
	 * 查找最新电视剧
	 */
	public List<DygMovie> selectlatestTVshow() throws SQLException{
		String sql = "SELECT * FROM dyg_movie where category = 'dsj1' or category = 'dsj' or category = 'yx'" + 
				" order by create_date desc limit 0,16";
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
	
	/**
	 * 查找最新高清
	 * @return
	 * @throws SQLException
	 */
	public List<DygMovie> selectlatesthighdefinition() throws SQLException{
		String sql = "SELECT * FROM dyg_movie where category = 'jilupian'" + 
				" order by create_date desc limit 0,16";
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
