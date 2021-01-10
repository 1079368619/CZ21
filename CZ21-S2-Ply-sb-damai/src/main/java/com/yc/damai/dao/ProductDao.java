package com.yc.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.damai.po.Product;

@Repository
public class ProductDao extends BaseDao {

	private RowMapper<Product> pm = new RowMapper<Product>(){
		
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	};

	
	public List<Product> queryHot(){
		String sql = "select * from product where is_hot=1 limit 0,10";
		return jt.query(sql, pm);
	}


	public Product queryByPid(int pid) {
		String sql = "select * from product where pid=?";
		return jt.query(sql, rs -> {
			return rs.next() ? pm.mapRow(rs, -1) : null;
		}, pid);
	}
	
	public List<Product> queryLatest(){
		String sql = "select * from product order by pdate desc limit 0,10";
		return jt.query(sql, pm);
	}
	
	public Product queryByPid(String pid){
		String sql = "select * from product where pid = ?";
		return jt.query(sql, rs->{
			return rs.next() ? pm.mapRow(rs, -1) : null;
		}, pid);
	}
	
	/**
	 * product表和categorysecond表关联查询，根据categorysecond表cid字段查询
	 * @param cid
	 * @return
	 */
	public List<Product> queryByCid(int cid) {
		String sql = "select a.* from product a, categorysecond b where a.csid = b.csid and b.cid = ?";
		return jt.query(sql, pm, cid);
	}
	
	public List<Product> queryByCsid(int csid) {
		String sql = "select * from product where csid = ?";
		return jt.query(sql, pm, csid);
	}
	
	/**
	 * 新增商品
	 * @param p
	 */
	public void insert(Product product) {
		String sql = "insert into product values (null, ?, ?, ?, ?, ?, ?, now(), ?)";
		jt.update(sql, product.getPname(), product.getMarketPrice(),
				product.getShopPrice(), product.getImage(), product.getPdesc(),
				product.getIsHot(),product.getCsid());
	}
	
}
