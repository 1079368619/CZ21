package com.yc.cloud.user.web;

import org.springframework.stereotype.Component;

import com.yc.cloud.user.bean.Numbers;

@Component
public class OrderAction implements IOrderAction {

	@Override
	public String orderway() {
		return "降级后的way: user's order way";
	}

	@Override
	public String add(Numbers numbers) {
		return "降级后的add: " + (numbers.getA() + numbers.getB());
	}

	@Override
	public String show(Integer a) {
		// TODO Auto-generated method stub
		return "降级后的show: " + a;
	}

}
