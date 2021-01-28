package com.yc.mvc.po;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class JsjCart implements java.io.Serializable{
	
	private static final long serialVersionUID = 2028909196711864219L;

	private Integer id;
	
	private Integer bid;
	
	private Integer uid;
	
	private Integer count;
	
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

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "JsjCart [id=" + id + ", bid=" + bid + ", uid=" + uid + ", count=" + count + ", createTime=" + createTime
				+ ", book=" + book + "]";
	}

	
}
