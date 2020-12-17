package com.yc.damai.biz;

import java.sql.SQLException;

import com.yc.damai.dao.CartDao;
import com.yc.damai.po.Cart;

public class CartBiz {

	private CartDao cdao = new CartDao();
	
	public void addCart(Cart cart) throws SQLException{
		/*String sql = "update cart set count=count+? where uid = ? and pid = ?";
		if(DBHelper.update(sql, count, uid, pid) == 0) {
			sql = "insert into cart values(null, ?, ?, ?)";
			DBHelper.update(sql, uid, pid, count);
		}*/
		//如果在cart表中没有根据uid--用户id和pid--商品id查询的数据，就在cart表中插入一条数据
		if(cdao.update(cart) == 0) {
			cdao.insert(cart);
		}
	}
	
}
