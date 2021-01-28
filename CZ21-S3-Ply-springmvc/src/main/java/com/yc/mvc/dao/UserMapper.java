package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.mvc.po.JsjUser;

public interface UserMapper {

	@Select("select * from jsj_user where account=#{account}")
	public JsjUser selectByname(String account);
	
	@Insert("insert into jsj_user(account,name,pwd,phone,email) values(#{account},#{name},#{pwd},#{phone},#{email})")
	public int insert(String account, String name, String pwd, String phone, String email);

	@Update("update jsj_user set head_img = #{headImg} where id = #{id}")
	public void updataHeadImg(JsjUser loginedUser);

	@Select("select * from jsj_user order by last_login_time desc limit 0 , 24")
	public List<JsjUser> queryLastLoginUsers();

	@Select("select * from jsj_user order by reg_time desc limit 0 , 24")
	public List<JsjUser> queryregTimeUsers();
	
	@Select("select * from jsj_user where id=#{id}")
	//@Results(id="rmuser", value = { @Result(column = "school", property = "schoolObj", 
	//one = @One(select = "com.yc.mvc.dao.SchoolMapper.selectById"))})
	public JsjUser selectById(int id);
}
