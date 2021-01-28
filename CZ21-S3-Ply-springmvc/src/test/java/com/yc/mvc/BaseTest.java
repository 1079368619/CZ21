package com.yc.mvc;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.mvc.dao.BooksMapper;
import com.yc.mvc.dao.CartMapper;
import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjBook;
import com.yc.mvc.po.JsjCart;
import com.yc.mvc.po.JsjUser;

@SpringBootTest
public class BaseTest {

	@Resource
	private CartMapper cm;
	
	@Resource
	private BooksMapper bm;
	
	@Resource
	private UserMapper um;
	
	@Test
	public void test1() {
		List<JsjCart> list = cm.quertBookDetail(21788442);
		for(JsjCart c : list) {
			System.out.println(c);
			JsjBook book = bm.quertBookDetail(c.getBid());
			System.out.println(book);
			JsjUser user = um.selectById(book.getOwnerId());
			System.out.println(user);
			
		}
		
	}
}
