package com.yc.damai.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.yc.damai.po.Category;
import com.yc.damai.po.Product;
import com.yc.damai.util.DBHelper;

public class DmTest {

	@Test
	public void test1() throws SQLException {
		String sql = "select * from product";
		DBHelper.selectList(sql, new com.yc.damai.dao.ProductDao.ProdctMapper());
		
	}
	
	@Test
	public void test2() throws SQLException {
		int pid = 1;
		String sql = "select * from product where pid = ?";
		try {
			List<Product> list = DBHelper.selectList(sql,  new com.yc.damai.dao.ProductDao.ProdctMapper(), pid);
			System.out.println("数据：" + list.get(0).getPid()+list.get(0).getPname()); ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() throws SQLException {
		String sql = "select * from category";
		try {
			List<Category> list = DBHelper.selectList(sql, new com.yc.damai.dao.CategroyDao.CategroyMapper());
			for(Category c : list) {
				System.out.println(c.getCid() +"-"+ c.getCname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() throws SQLException {
		
		String sql = "select a.* from product a,category b where b.cid = ? and a.csid = b.cid";
		try {
			int cid = 1;
			List<Product> list = DBHelper.selectList(sql, new com.yc.damai.dao.ProductDao.ProdctMapper(),cid );
			for(Product p : list) {
				System.out.println(p.getPid() +"-"+ p.getPname() + "-" + p.getCsid());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
