package com.yc.favorite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.favorite.bean.Tag;

public interface TagMapper {

	@Insert("insert into tag values(null, #{tname}, #{tcount})")
	int insert(Tag tag);
	
	@Select("select * from tag where tname=#{n}")
	Tag selectByName(String tname);

	@Update("update tag set tcount = tcount+1 where tname=#{tname}")
	int updataCountByName(String tag);

	@Select("select * from tag")
	List<Tag> selectAll();

}
