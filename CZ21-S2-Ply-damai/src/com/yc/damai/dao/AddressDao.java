package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yc.damai.po.Address;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class AddressDao {

	private AddressMapper cm = new AddressMapper();
	
	public static class AddressMapper implements ResultSetMapper<Address>{
		
		@Override
		public Address map(ResultSet rs) throws SQLException {
			Address a = new Address();
			a.setAid(rs.getInt("aid"));
			a.setUid(rs.getInt("uid"));
			a.setAddr(rs.getString("addr"));
			return a;
		}
	}
	
	public void insert(Address a) throws SQLException{
		String sql = "insert into orderitem values (null, ?, ?)";
		DBHelper.update(sql, a.getUid(), a.getAddr());
	}
}
