package com.yc.mvc.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mvc.dao.BooksMapper;
import com.yc.mvc.po.JsjBook;

@RestController
public class BooksAction {

	@Resource
	private BooksMapper bm;
	
	@RequestMapping("queryByCategory.do")
	public Map<String, Object> queryByCategory(int category,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		boolean count = true;
		Page<JsjBook> p = PageHelper.startPage(page, size, count);
		bm.selectByCategory(category);
		Map<String, Object> ret = new HashMap<>();
		//
		ret.put("list", p);
		//
		ret.put("pages", p.getPages());
		//
		ret.put("page", p.getPageNum());
		
		return ret;
	}
	

}
