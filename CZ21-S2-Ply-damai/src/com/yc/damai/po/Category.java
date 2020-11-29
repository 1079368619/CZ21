package com.yc.damai.po;

import java.io.Serializable;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
