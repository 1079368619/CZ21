package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.damai.po.Cart;
import com.yc.damai.po.Product;
import com.yc.damai.util.DBHelper;
import com.yc.damai.util.DBHelper.ResultSetMapper;

public class ProductDao {

	//
	private ProdctMapper pm = new ProdctMapper();
	
	public static class ProdctMapper implements ResultSetMapper<Product>{
		
		@Override
		public Product map(ResultSet rs) throws SQLException {
			Product p = new Product();
			p.setPid(rs.getInt("pid"));
			p.setPname(rs.getString("pname"));
			p.setMarketPrice(rs.getDouble("market_price"));
			p.setShopPrice(rs.getDouble("shop_price"));
			p.setImage(rs.getString("image"));
			p.setPdesc(rs.getString("pdesc"));
			p.setIsHot(rs.getInt("is_hot"));
			p.setPdate(rs.getTimestamp("pdate"));
			p.setCsid(rs.getInt("csid"));
			return p;
		}
	}
	
	public List<Product> queryHot(){
		String sql = "select * from product where is_hot=1 limit 0,10";
		try {
			return DBHelper.selectList(sql, pm);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Product> queryLatest(){
		String sql = "select * from product order by pdate desc limit 0,10";
		try {
			return DBHelper.selectList(sql, pm);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Product queryByPid(String pid){
		String sql = "select * from product where pid = ?";
		List<Product> list = null;
		try {
			list = DBHelper.selectList(sql, pm, pid);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * product表和categorysecond表关联查询，根据categorysecond表cid字段查询
	 * @param cid
	 * @return
	 */
	public List<Product> queryByCid(String cid){
		String sql = "select a.* from product a, categorysecond b where a.csid = b.csid and b.cid = ?";
		try {
			return DBHelper.selectList(sql, pm, cid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Product> queryByCsid(String csid){
		String sql = "select * from product where csid = ?";
		try {
			return DBHelper.selectList(sql, pm, csid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insert(Product product) throws SQLException{
		String sql = "insert into product values (null, ?, ?, ?, ?, ?, ?, default, ?)";
		DBHelper.update(sql, product.getPname(), product.getMarketPrice(),
				product.getShopPrice(), product.getImage(), product.getPdesc(),
				product.getIsHot(),product.getCsid());
	}
}
