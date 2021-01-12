package com.yc.mybatis.bean;

import java.io.Serializable;

public class JsjSchool implements Serializable {
    
	private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}