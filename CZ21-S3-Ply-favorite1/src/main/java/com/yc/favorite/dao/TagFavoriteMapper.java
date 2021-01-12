package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.yc.favorite.bean.Favorite;

public interface TagFavoriteMapper {

	@Insert("insert into tagfavorite values(#{tid}, #{fid})")
	int insert(@Param("tid") Integer tid, @Param("fid") Integer fid);
	
}
