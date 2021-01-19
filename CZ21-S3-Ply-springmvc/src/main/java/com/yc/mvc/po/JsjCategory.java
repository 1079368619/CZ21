package com.yc.mvc.po;

public class JsjCategory implements java.io.Serializable{
	
	private static final long serialVersionUID = 2028909196711864219L;

    private Integer id;

    private String name;

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
}