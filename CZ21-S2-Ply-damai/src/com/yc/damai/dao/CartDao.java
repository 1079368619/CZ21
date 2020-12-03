package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.dao.ProductDao.ProdctMapper;
import com.yc.damai.po.Cart;
import com.yc.damai.po.Product;
import com.yc.damai.po.User;
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
	
	public List<?> queryByUid(int uid){
		String sql = "select a.*,b.* from product a,cart b where a.pid = b.pid and b.uid = ?";
		try {
			List<?> list = DBHelper.selectListMap(sql, uid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public void insert(Cart cart) throws SQLException{
		String sql = "insert into cart values (null, ?, ?, 1)";
		DBHelper.update(sql, cart.getUid(), cart.getPid());
	}
	
	public int update(Cart cart) throws SQLException{
		String sql = "update cart set count=count+1 where uid = ? and pid = ?";
		return DBHelper.update(sql, cart.getUid(), cart.getPid());
	}
	
	public int deletebyCiid(int ciid) throws SQLException{
		String sql = "delete from cart where ciid=?";
		return DBHelper.update(sql, ciid);
	}
}
