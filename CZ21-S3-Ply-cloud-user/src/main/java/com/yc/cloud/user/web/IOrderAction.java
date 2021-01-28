package com.yc.cloud.user.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.cloud.user.bean.Numbers;

@FeignClient("cloud-order")
public interface IOrderAction {

	@GetMapping("order/way")
	String orderway();
	
	@PostMapping("add")
	String add(Numbers numbers);
	
	// Feign 使用 Post 请求
	// @RequestBody 表示该参数写入到请求体中
	@PostMapping("show")
	String show(Integer a);
	
}
