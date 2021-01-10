package com.yc.damai.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.CategoryDao;
import com.yc.damai.dao.CategorySecondDao;

@RestController
public class CategorySecondAction {

	@Resource
	private CategorySecondDao csdao;
	
	@Resource
	private CategoryDao cdao;
	
	@RequestMapping(path="categorySecond.s",params="op=queryAll")
	public Map<String, Object> queryAll(){
		Map<String, Object> data = new HashMap<>();
		data.put("listc", cdao.queryAllCategory());
		data.put("listcs", csdao.queryAllCategorySecond());
		return data;
	}
}
