package com.yc.mvc.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mvc.dao.CartMapper;
import com.yc.mvc.po.JsjCart;

@Service
@Transactional
public class CartBiz {

	@Resource
	private CartMapper cm;

	public void addCart(JsjCart cart) {
		if(cm.updateCount(cart) == 0) {
			cm.insert(cart);
		}
	}
	
	
	
}
