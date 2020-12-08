package com.yc.spring;

public class DiskStorage implements Storage {

	@Override
	public void save(Object data) {
		System.out.println("将数据保存在磁盘中");
	}

}
