package com.yc.damai.po;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private int itemid;
	private Integer count;
	private Double subtotal;
	private int pid;
	private int oid;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", pid=" + pid + ", oid="
				+ oid + "]";
	}
	
}
