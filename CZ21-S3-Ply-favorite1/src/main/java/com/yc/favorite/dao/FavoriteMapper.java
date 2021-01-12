package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.yc.favorite.bean.Favorite;

public interface FavoriteMapper {

	@Insert("insert into favorite values(null, #{flabel}, #{furl}, #{fdesc}, #{ftags})")
	@Options(useGeneratedKeys = true, keyColumn = "fid", keyProperty = "fid")
	int insert(Favorite f);
	
	@Select("select * from favorite where flabel=#{1}")
	Favorite selectByLabel(String flabel);
}
