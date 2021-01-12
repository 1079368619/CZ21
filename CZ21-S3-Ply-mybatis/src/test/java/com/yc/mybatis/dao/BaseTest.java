package com.yc.mybatis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yc.mybatis.bean.JsjCategory;

public class BaseTest {

	private SqlSession session;
	
	@Before
	public void before() throws IOException {
		//
		String resource = "mybatis.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		session = sqlSessionFactory.openSession();
		
	}
	
	@Test
	public void test1() throws IOException {
		List<Map<?, ?>> list = session.selectList("com.yc.mybatis.dao.CategoryMapper.selectAll");
		for(Map<?, ?> row : list) {
			System.out.println(row);
		}
	}
	
	@Test
	public void test2() throws IOException {
		List<JsjCategory> list = session.selectList("com.yc.mybatis.dao.CategoryMapper.selectAll1");
		for(JsjCategory row : list) {
			System.out.println(row.getId() + "  " + row.getName());
		}
	}
}
