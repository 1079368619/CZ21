package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Address;

@Repository
public class AddressDao extends BaseDao {
	
	private RowMapper<Address> am = new RowMapper<Address>(){

		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address a = new Address();
			a.setAid(rs.getInt("aid"));
			a.setUid(rs.getInt("uid"));
			a.setAddr(rs.getString("addr"));
			return a;
		}
	};
	
	public void insert(Address a) throws SQLException{
		String sql = "insert into address values (null, ?, ?)";
		jt.update(sql, a.getUid(), a.getAddr());
	}
}
