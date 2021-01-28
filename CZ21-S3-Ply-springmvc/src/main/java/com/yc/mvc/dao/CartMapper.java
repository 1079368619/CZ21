package com.yc.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.mvc.po.JsjCart;

public interface CartMapper {

	@Insert("insert into jsj_cart values(default, #{bid}, #{uid}, #{count}, default)")
	public int insert(JsjCart cart);
	
	@Insert("update jsj_cart set count=count+#{count} where id=#{id}")
	public int updateCount(JsjCart cart);
	
	@Select("select * from jsj_cart where uid=#{uid}")
	//@Results(id="rmbook", value = { @Result(column = "bid", property = "book",
	//  one = @One(select = "com.yc.mvc.dao.BooksMapper.quertBookDetail")) })
	public List<JsjCart> quertBookDetail(int uid);

}
