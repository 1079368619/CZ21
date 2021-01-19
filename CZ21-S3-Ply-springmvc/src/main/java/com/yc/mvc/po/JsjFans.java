package com.yc.mvc.po;

import java.util.Date;

public class JsjFans implements java.io.Serializable{
	
	private static final long serialVersionUID = 2028909196711864219L;

    private Integer id;

    private Integer uid;

    private Integer fid;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}