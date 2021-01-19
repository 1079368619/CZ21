package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.mvc.dao.SearchMapper;
import com.yc.mvc.po.JsjSearch;

@RestController
public class SearchAction {

	@Resource
	private SearchMapper sm;
	
	@RequestMapping("querySearch.do")
	public List<JsjSearch> querySearch() {
		return sm.selectAll();
	}
	
}
