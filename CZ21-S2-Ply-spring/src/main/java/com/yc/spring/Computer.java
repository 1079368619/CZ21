package com.yc.spring;

public class Computer {

	private Storage storage = new RWCDStorage();
	
	public void save(Object data) {
		storage.save(data);
	}
	
	public static void main(String[] args) {
		Computer c = new Computer();
		c.save("文档数据");
	}
}
