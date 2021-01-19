package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjCategory;

public interface CategoryMapper {

	@Select("select * from jsj_category")
	public List<JsjCategory> selectAll();
	
	@Select("select * from jsj_category where id=#{id}")
	public JsjCategory selectById(Integer id);
}
