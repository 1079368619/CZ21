package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjSearch;

public interface SearchMapper {

	@Select("select * from jsj_search order by hots desc")
	public List<JsjSearch> selectAll();
	

}
