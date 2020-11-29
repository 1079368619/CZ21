package com.yc.damai.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.yc.damai.po.Product;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class DmTest {

	@Test
	public void test1() throws SQLException {
		String sql = "select * from product";
		DBHelper.selectList(sql, new ProdctMapper());
		
	}
}

class ProdctMapper implements ResultSetMapper<Product>{

	@Override
	public Product map(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setPid(rs.getInt("pid"));
		p.setCsid(rs.getInt("csid"));
		p.setImage(rs.getString("image"));
		return p;
	}
	
}