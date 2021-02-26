package com.yc.sq.bean;

import java.io.Serializable;

public class SqAlbum implements Serializable{

	private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer singerId;

    private Integer songId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }
}