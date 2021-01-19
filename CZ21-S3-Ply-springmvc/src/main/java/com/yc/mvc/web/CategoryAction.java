package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.dao.CategoryMapper;
import com.yc.mvc.po.JsjCategory;

@RestController
public class CategoryAction {

	@Resource
	private CategoryMapper cm;
	
	@RequestMapping("queryAllCategory.do")
	public List<JsjCategory> queryAllCategory(int category) {
		return cm.selectAll();
	}
	
	@RequestMapping("queryByCategoryId.do")
	public JsjCategory queryByCategoryId(int id) {
		return cm.selectById(id);
	}

}
