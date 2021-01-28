package com.yc.mvc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.mvc.dao.BooksMapper;
import com.yc.mvc.po.JsjBook;
import com.yc.mvc.po.Result;

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
	
	@RequestMapping("queryKeyname.do")
	public Result queryKeyname(String keyname) {
		if(keyname.length() == 0 || "".equals(keyname)) {
			return Result.failure("请输入你想搜索的物品", null);
		}else {
			List<JsjBook> list = bm.queryKeyname(keyname);
			if(list.isEmpty() || list.size() == 0){
				return Result.failure("没有搜索到您想要的商品", null);
			} else {
				return Result.success("搜索成功", null);
			}
		}
	}
	
	@RequestMapping("search.do")
	public List<JsjBook> search(String keyname) {
		return bm.queryKeyname(keyname);
	}
	
	@RequestMapping("queryHotBooks.do")
	public List<JsjBook> queryHotBooks() {
		return bm.queryHotBooks();
	}

}
