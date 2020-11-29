package com.yc.damai.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	private int oid;
	private Double total;
	private Timestamp ordertime;
	private int state;
	private String addr;
	private String phone;
	private int uid;
	private String name;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
