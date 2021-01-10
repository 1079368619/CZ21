package com.yc.damai.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.biz.BizException;
import com.yc.damai.biz.ProductBiz;
import com.yc.damai.dao.ProductDao;
import com.yc.damai.po.Product;
import com.yc.damai.po.Result;

@RestController
public class ProductAction {

	@Resource
	private ProductDao pdao;
	
	@Resource
	private ProductBiz pbiz;
	
	@RequestMapping(path="product.s",params="op=queryHot")
	public List<Product> queryHot(){
		return pdao.queryHot();
	}
	
	@RequestMapping(path="product.s",params="op=queryByCid")
	public List<Product> queryByCid(int cid){
		return pdao.queryByCid(cid);
	}
	
	@RequestMapping(path="product.s",params="op=queryByCsid")
	public List<Product> queryByCsid(int csid){
		return pdao.queryByCsid(csid);
	}
	
	@RequestMapping(path="product.s",params="op=queryLatest")
	public List<Product> queryLatest(){
		return pdao.queryLatest();
	}
	
	@RequestMapping(path="product.s",params="op=queryByPid")
	public Product queryByPid(int pid){
		return pdao.queryByPid(pid);
	}
	
	@RequestMapping("createProduct")
	public Result create(Product p){
		try {
			pbiz.create(p);
			return Result.success("商品添加成功!");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}
	
}
