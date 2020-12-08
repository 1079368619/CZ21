package com.yc.spring.di;

import java.util.Date;

public class User {

	private String name;
	
	private int age;
	
	private String email;

	private Date birthday;
	
	private String[] likes;
	
	private User friend;
	
	public User() {
		
	}

	public User(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public void setLikes(String[] likes) {
		this.likes = likes;
	}

	public String[] getLikes() {
		return likes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	
}
