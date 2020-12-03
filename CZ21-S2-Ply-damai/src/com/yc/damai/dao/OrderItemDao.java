package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.po.OrderItem;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class OrderItemDao {

	private OrderItemMapper oim = new OrderItemMapper();
	
	public static class OrderItemMapper implements ResultSetMapper<OrderItem>{
		
		@Override
		public OrderItem map(ResultSet rs) throws SQLException {
			OrderItem o = new OrderItem();
			o.setItemid(rs.getInt("itemid"));
			o.setCount(rs.getInt("count"));
			o.setSubtotal(rs.getDouble("subtotal"));
			o.setPid(rs.getInt("pid"));
			o.setOid(rs.getInt("oid"));
			return o;
		}
	}
	
	/**
	 * 三表联合查询
	 * orderitem表、product表、orders表
	 * @param uid
	 * @return
	 */
	public List<?> queryByUid(int uid){
		String sql = "select a.*, b.*, c.* from orderitem a left join orders b on a.oid = b.oid " + 
				"left join product c on a.pid = c.pid where b.uid = ? ";
		try {
			List<?> list = DBHelper.selectListMap(sql, uid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insert(OrderItem o) throws SQLException{
		String sql = "insert into orderitem values (null, ?, ?, ?, ?)";
		DBHelper.update(sql, o.getCount(), o.getSubtotal(), o.getPid(), o.getOid());
	}
}
