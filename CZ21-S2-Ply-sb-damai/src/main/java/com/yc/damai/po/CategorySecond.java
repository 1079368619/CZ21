package com.yc.damai.po;

import java.io.Serializable;

public class CategorySecond implements Serializable {

	private static final long serialVersionUID = 1L;

	private int csid;
	private String csname;
	private int cid;
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", cid=" + cid + "]";
	}
	
}
