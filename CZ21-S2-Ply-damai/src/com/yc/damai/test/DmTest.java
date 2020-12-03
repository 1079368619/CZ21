package com.yc.damai.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.yc.damai.po.Category;
import com.yc.damai.po.Product;
import com.yc.damai.po.User;
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
	
	@Test
	public void test5() throws SQLException {
		User user = new User();
		user.setUsername("m"); 
		user.setPassword("a");
		user.setName("悟空"); 
		user.setEmail("song@shop.com"); 
		user.setPhone("13283710950"); 
		user.setSex("男");
		user.setCode("");
		user.setAddr("花果山");
		String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
		DBHelper.update(sql, user.getUsername(), user.getPassword(),
				user.getName(), user.getEmail(), user.getPhone(), 
				user.getSex(), user.getCode(),user.getAddr());
	}
	
	@Test
	public void test6() throws SQLException {
		String username = "a";
		String sql = "select * from user where username = ?";
		List<User> list  = DBHelper.selectList(sql, new com.yc.damai.dao.UserDao.UserMapper(), username);
		System.out.println(list.get(0).getName()+"-"+list.get(0).getUsername());
		
	}
	
	@Test
	public void test7() throws SQLException {
		String username = "w";
		String sql = "select * from user where username = ?";
		List<User> list  = DBHelper.selectList(sql, new com.yc.damai.dao.UserDao.UserMapper(), username);
		if(list.contains(username)) {
			System.out.println("no");
		}else {
			System.out.println("yes-"+ list.get(0).getUid()+"-"+list.get(0).getUsername());
		}
		
	}
	
	@Test
	public void test8() throws SQLException {
		String username = "1";
		String sql = "select * from user where username = ?";
		try {
			List<User> list  = DBHelper.selectList(sql,  new com.yc.damai.dao.UserDao.UserMapper(), username);
			System.out.println( list.get(0).getUid());
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
}
