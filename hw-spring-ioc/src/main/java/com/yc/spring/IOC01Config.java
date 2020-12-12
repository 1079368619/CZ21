package com.yc.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bbs.bean.Page;
import com.yc.spring.bbs.bean.User;

public class IOC01Config {

	@Bean(name="myUser")
	public User myUser() {
		User u = new User();
		u.setUname("武松");
		u.setUpass("abc123");
		u.setHead("20.gif");
		u.setGender(1);
		return u;
	}
	
	@Bean
	@Primary
	public User User() {
		User u = new User();
		u.setUname("石秀");
		u.setUpass("XYZ890");
		u.setHead("345.gif");
		u.setGender(0);
		return u;
	}
	
	@Bean
	public Page page1() {
		Page p = new Page();
		p.setTotal(100);
		p.setRows(new ArrayList<>());
		p.getRows().add("湖南");
		p.getRows().add("广东");
		p.getRows().add(100);
		return p;
	}
	@Autowired
	@Qualifier("myUser")
	private User user1;
	
	@Bean
	public Page page2() {
		Page p = new Page();
		p.setTotal(200);
		p.setRows(new ArrayList<>());
		
		User u = new User();
		u.setUname("华荣");
		p.getRows().add(u);
		
		Map<String, Object> m = new HashMap<>();
		m.put("0734", "衡阳");
		m.put("0731", "长沙");
		p.getRows().add(m);
		
		Set<Object> s = new HashSet<>();
		s.add(100);
		s.add("呵呵");
		s.add(user1);
		p.getRows().add(s);
		
		return p;
	}
}
