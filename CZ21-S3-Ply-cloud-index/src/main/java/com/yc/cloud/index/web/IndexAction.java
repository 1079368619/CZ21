package com.yc.cloud.index.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexAction {

	@GetMapping("index/way")
	public String way(HttpServletRequest req) {
		return "index way:" + req.getServerPort();
	}
	
	@Resource
	private RestTemplate rt;
	
	@GetMapping("user/way")
	public String orderWay() {
		String url = "http://cloud-user/user/way";
		return rt.getForObject(url, String.class);
	}
}
