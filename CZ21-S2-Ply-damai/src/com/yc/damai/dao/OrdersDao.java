package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.po.Orders;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class OrdersDao {

	private OrdersMapper om = new OrdersMapper();
	
	public static class OrdersMapper implements ResultSetMapper<Orders>{
		
		@Override
		public Orders map(ResultSet rs) throws SQLException {
			Orders o = new Orders();
			o.setOid(rs.getInt("oid"));
			o.setTotal(rs.getDouble("total"));
			o.setOrdertime(rs.getTimestamp("ordertime"));
			o.setState(rs.getInt("state"));
			o.setAddr(rs.getString("addr"));
			o.setPhone(rs.getString("phone"));
			o.setUid(rs.getInt("uid"));
			o.setName(rs.getString("name"));
			return o;
		}
	}
	
	public List<?> queryByUid(int uid){
		String sql = "select a.*,b.* from user a,orders b where a.uid = b.uid and a.uid = ?";
		try {
			List<?> list = DBHelper.selectListMap(sql, uid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insert(Orders o) throws SQLException{
		String sql = "insert into orderitem values (null, ?, default, 1, ?, ?, ?, ?)";
		DBHelper.update(sql, o.getTotal(), o.getAddr(), o.getPhone(), o.getUid(), o.getName());
	}
}
