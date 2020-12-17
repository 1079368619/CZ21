package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Cart;

@Repository
public class CartDao extends BaseDao {

	private RowMapper<Cart> cm = new RowMapper<Cart>() {

		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart c = new Cart();
			c.setCiid(rs.getInt("ciid"));
			c.setUid(rs.getInt("uid"));
			c.setPid(rs.getInt("pid"));
			c.setCount(rs.getInt("count"));
			return c;
		}
		
	};
	
	public void insert(Cart c) {
		String sql = "insert into cart values(null,?,?,?)";
		jt.update(sql, c.getUid(), c.getPid(), c.getCount());
	}

	public List<?> queryByUid(int uid){
		String sql = "select a.*,b.* from product a,cart b where a.pid = b.pid and b.uid = ?";
		List<?> list = null;
		list = jt.queryForList(sql,uid);
		System.out.println("queryByUid:"+list);
		return list;
	}
	
	
	public int update(Cart cart) {
		String sql = "update cart set count=count+1 where uid = ? and pid = ?";
		return jt.update(sql, cart.getUid(), cart.getPid());
	}
	
	public void deletebyCiid(int ciid) {
		String sql = "delete from cart where ciid=?";
		jt.update(sql, ciid);
	}
	
	public void deletebyUid(int uid) {
		String sql = "delete from cart where uid=?";
		jt.update(sql, uid);
	}
	
	public List<Map<String, Object>> selectCart(int uid){
		String sql = "select * from cart a" + 
				" left join user b on a.uid=b.uid" + 
				" left join product c on a.pid=c.pid" + 
				" where a.uid=?";
		return jt.queryForList(sql,uid);
	}
	
}
