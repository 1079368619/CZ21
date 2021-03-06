package com.yc.blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.blog.bean.Article;
import com.yc.blog.bean.ArticleExample;
import com.yc.blog.dao.ArticleMapper;

@RestController
public class ArticleAction {

	@Resource
	private ArticleMapper am;
	
	@GetMapping("queryNewArticle")
	public List<Article> queryNewArticle(@RequestParam(defaultValue = "1") int page) {
		ArticleExample ae = new ArticleExample();
		ae.setOrderByClause("createtime desc");
		PageHelper.startPage(page, 5);
		return am.selectByExampleWithBLOBs(ae);
	}
}
