package com.yc.damai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Orders;

@Repository
public class OrdersDao extends BaseDao {

	private RowMapper<Orders> om = new RowMapper<Orders>() {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		
	};
	
	public List<?> queryByUid(int uid){
		String sql = "select a.*,b.* from user a,orders b where a.uid = b.uid and a.uid = ?";
		List<?> list = jt.queryForList(sql, uid);
		return list;
	}
	
	/**
	 * 新增订单主表
	 * @param orders
	 */
	public void insert(Orders o){
		String sql = "insert into orders values (null, ?, now(), 1, ?, ?, ?, ?)";
		jt.update(sql, o.getTotal(), o.getAddr(), o.getPhone(), o.getUid(), o.getName());
	}

	/**
	 * 新增订单明细
	 * @param orders
	 */
	public void insertItems(Orders orders) {
		String sql = "insert into orderitem select null,a.count, a.count*b.shop_price,a.pid,? from cart a " + 
				"join product b on a.pid = b.pid where a.uid = ?";
		jt.update(sql, orders.getOid(), orders.getUid());
	}

	public int insertOrders(Orders orders) {
		String sql = "insert into orders values (null, ?, now(), ?, ?, ?, ?, ?)";
		KeyHolder kh = new GeneratedKeyHolder();
		jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"oid"});
				ps.setObject(1, orders.getTotal());
				ps.setObject(2, orders.getState());
				ps.setObject(3, orders.getAddr());
				ps.setObject(4, orders.getPhone());
				ps.setObject(5, orders.getUid());
				ps.setObject(6, orders.getName());
				return ps;
			}
		}, kh);
		return kh.getKey().intValue();
	}
}
