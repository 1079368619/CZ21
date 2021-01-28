package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.mvc.biz.CartBiz;
import com.yc.mvc.dao.CartMapper;
import com.yc.mvc.po.JsjCart;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.po.Result;

@RestController
public class CartAction {

	@Resource
	private CartBiz cbiz;
	
	@Resource
	private CartMapper cm;

	@RequestMapping("addCart.do")
	public Result addCart(JsjCart cart) {
		cbiz.addCart(cart);
		return Result.success("", null);
	}
	
	@RequestMapping("queryCart.do")
	public List<JsjCart> queryCartByUid(@SessionAttribute JsjUser loginedUser) {
		return cm.quertBookDetail(loginedUser.getId());
	}
}
