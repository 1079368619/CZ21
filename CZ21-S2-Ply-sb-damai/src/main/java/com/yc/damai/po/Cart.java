package com.yc.damai.po;

import java.io.Serializable;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ciid;
	private int uid;
	private int pid;
	private int count;
	
	
	public int getCiid() {
		return ciid;
	}
	public void setCiid(int ciid) {
		this.ciid = ciid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Cart [ciid=" + ciid + ", uid=" + uid + ", pid=" + pid + ", count=" + count + "]";
	}
	
}
