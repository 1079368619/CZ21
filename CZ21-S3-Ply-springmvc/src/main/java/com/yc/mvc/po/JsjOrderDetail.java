package com.yc.mvc.po;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class JsjOrderDetail implements java.io.Serializable{
	
	private static final long serialVersionUID = 2028909196711864219L;
	
	private Integer id;
	
	private Integer oid;
	
	private Integer bid;
	
	private Integer count;
	
	private Double price;
	
	private Timestamp createTime;

	private JsjBook book;
	
	public JsjBook getBook() {
		return book;
	}

	public void setBook(JsjBook book) {
		this.book = book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "JsjOrderDetail [id=" + id + ", oid=" + oid + ", bid=" + bid + ", count=" + count + ", price=" + price
				+ ", createTime=" + createTime + ", book=" + book + "]";
	}

}
