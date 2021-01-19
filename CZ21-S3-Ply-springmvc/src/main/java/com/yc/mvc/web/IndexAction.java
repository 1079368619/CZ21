package com.yc.mvc.web;

import java.io.InputStream;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes(names = "数据1", types = Date.class)
public class IndexAction {

	@GetMapping("index")
	public String index(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			InputStream in) {
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		System.out.println(in);
		session.setAttribute("数据1", "你好啊");
		request.setAttribute("数据2", "我好啊");
		return "index";
	}
	
	@GetMapping("index1")
	public String index1(HttpServletRequest request,
			HttpSession session) {
		String ret = session.getAttribute("数据1") + "<br>";
		ret += request.getAttribute("数据2");
		return ret;
	}
	
	@GetMapping("index2")
	public String index2(@SessionAttribute(name = "", required = false) String data) {
		return "index2 : " + data;
	}
	
	@GetMapping("index3")
	public String index3(Model m) {
		m.addAttribute("数据1", "下午好");
		return "index3";
	}
	
	@GetMapping("index4")
	public ModelAndView index4(ModelAndView mav) {
		mav.addObject("数据1", "下午好");
		mav.setViewName("index");
		return mav;
	}
}
