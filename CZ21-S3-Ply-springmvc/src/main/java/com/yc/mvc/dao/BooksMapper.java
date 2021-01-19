package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjBook;

public interface BooksMapper {

	@Select("select * from jsj_book where category=#{cgy}")
	public List<JsjBook> selectByCategory(int category);
}
