package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Orders;
import com.yc.damai.po.Product;

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
	
	public void insert(Orders o) throws SQLException{
		String sql = "insert into orderitem values (null, ?, default, 1, ?, ?, ?, ?)";
		jt.update(sql, o.getTotal(), o.getAddr(), o.getPhone(), o.getUid(), o.getName());
	}
}
