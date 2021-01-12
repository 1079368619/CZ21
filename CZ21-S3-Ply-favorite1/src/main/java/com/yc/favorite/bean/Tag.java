package com.yc.favorite.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer tid;
	
	private String tname;
	
	private Long tcount;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Long getTcount() {
		return tcount;
	}

	public void setTcount(Long tcount) {
		this.tcount = tcount;
	}

	@Override
	public String toString() {
		return "Tag [tid=" + tid + ", tname=" + tname + ", tcount=" + tcount + "]";
	}
	
	
	
}
