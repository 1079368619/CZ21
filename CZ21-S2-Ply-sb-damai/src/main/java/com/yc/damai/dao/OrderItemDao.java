package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.OrderItem;

@Repository
public class OrderItemDao extends BaseDao {

	private RowMapper<OrderItem> om = new RowMapper<OrderItem>() {

		@Override
		public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderItem o = new OrderItem();
			o.setItemid(rs.getInt("itemid"));
			o.setCount(rs.getInt("count"));
			o.setSubtotal(rs.getDouble("subtotal"));
			o.setPid(rs.getInt("pid"));
			o.setOid(rs.getInt("oid"));
			return o;
		}
		
	};
	
	/**
	 * 三表联合查询
	 * orderitem表、product表、orders表
	 * @param uid
	 * @return
	 */
	public List<?> queryByUid(int uid){
		String sql = "select a.*, b.*, c.* from orderitem a left join orders b on a.oid = b.oid " + 
				"left join product c on a.pid = c.pid where b.uid = ? ";
		List<?> list = jt.queryForList(sql, uid);
		return list;
		
	}
	
	public void insert(OrderItem o) throws SQLException{
		String sql = "insert into orderitem values (null, ?, ?, ?, ?)";
		jt.update(sql, o.getCount(), o.getSubtotal(), o.getPid(), o.getOid());
	}
}
