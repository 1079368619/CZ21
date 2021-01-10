package com.yc.damai.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.CategoryDao;
import com.yc.damai.po.Category;

@RestController
public class CategoryAction {

	@Resource
	private CategoryDao cdao;
	
	@RequestMapping(path="category.s",params="op=queryAll")
	public List<Category> queryAll(){
		return cdao.queryAllCategory();
		
	}
	
}
