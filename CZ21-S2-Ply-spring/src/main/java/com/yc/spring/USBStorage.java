package com.yc.spring;

public class USBStorage implements Storage {

	@Override
	public void save(Object data) {
		System.out.println("将数据保存在U盘中");
	}

}
