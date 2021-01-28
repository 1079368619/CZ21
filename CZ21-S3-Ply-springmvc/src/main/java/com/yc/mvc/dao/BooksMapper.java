package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjBook;

public interface BooksMapper {

	@Select("select * from jsj_book where category=#{cgy}")
	public List<JsjBook> selectByCategory(int category);
	
	@Select("select * from jsj_book where name like concat('%', #{name},'%')")
	public List<JsjBook> queryKeyname(String name);

	@Select("select * from jsj_book order by up_time  limit 0,40")
	public List<JsjBook> queryHotBooks();
	
	@Select("select * from jsj_book where id=#{id}")
	//@Results(id="rmbook", value = { @Result(column = "owner_id", property = "user", 
	//	one = @One(select = "com.yc.mvc.dao.UserMapper.selectById")) })
	public JsjBook quertBookDetail(int id);

	
}
