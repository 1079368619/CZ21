package another.bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class User {

	private int id;
	
	private String name;
	
	private String pwd;
	
	private Date birthday;
	
	private School school;
	
	private String[] likes;
	
	private List<User> friends;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String[] getLikes() {
		return likes;
	}

	public void setLikes(String[] likes) {
		this.likes = likes;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", birthday=" + birthday + ", school=" + school
				+ ", likes=" + Arrays.toString(likes) + ", friends=" + friends + "]";
	}
	
	
}
