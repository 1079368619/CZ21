package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.po.Cart;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class CartDao {

	private CartMapper cm = new CartMapper();
	
	public static class CartMapper implements ResultSetMapper<Cart>{
		
		@Override
		public Cart map(ResultSet rs) throws SQLException {
			Cart c = new Cart();
			c.setCiid(rs.getInt("ciid"));
			c.setUid(rs.getInt("uid"));
			c.setPid(rs.getInt("pid"));
			c.setCount(rs.getInt("count"));
			return c;
		}
	}
	
	public List<Cart> queryByUid(int uid){
		String sql = "select a.*,b.* from product a,cart b where a.pid = b.pid and b.uid = 2";
		try {
			return DBHelper.selectList(sql, cm, uid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addCart(String pid, String count, int uid) throws SQLException{
		String sql = "update cart set count=count+? where uid = ? and pid = ?";
		if(DBHelper.update(sql, count, uid, pid) == 0) {
			sql = "insert into cart values(null, ?, ?, ?)";
			DBHelper.update(sql, uid, pid, count);
		}
	}
}
