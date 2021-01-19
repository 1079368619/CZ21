package com.yc.mvc.dao;

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
	
	
}
