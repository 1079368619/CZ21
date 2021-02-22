package com.yc.blog;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.dao.CategoryMapper;

@SpringBootTest
public class BaseTest {

	@Resource
	private CategoryMapper cm;
	
	public void test1() {
		Category c = new Category();
		c.setName("");
		c.setSort(99);
		
		cm.insert(c);
		System.out.println("" + c.getId());
		
		c.setName("");
		cm.updateByPrimaryKey(c);
		
		cm.updateByPrimaryKeySelective(c);
		
		cm.deleteByPrimaryKey(c.getId());
		
		cm.selectByPrimaryKey(1);
		
		CategoryExample ce = new CategoryExample();
		
		ce.createCriteria().andNameEqualTo("")
			.andNameLike("")
			.andSortGreaterThan(2)
			.andSortGreaterThanOrEqualTo(3)
			.andIdIsNotNull();
		ce.or(ce.createCriteria()
				.andIntroduceEqualTo("")
				.andIdBetween(1, 2));
		
		cm.selectByExample(ce);
		cm.deleteByExample(ce);
		cm.updateByExample(c, ce);
	}
	
}
