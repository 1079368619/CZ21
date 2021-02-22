package com.yc.blog.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleAction {

	@Resource
	private ArtcleMapper am;
	
	public List<Article> queryNewArticle() {
		
	}
}
