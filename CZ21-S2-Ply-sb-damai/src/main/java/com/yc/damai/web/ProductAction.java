package com.yc.damai.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.ProductDao;
import com.yc.damai.po.Product;

@RestController
public class ProductAction {

	@Resource
	private ProductDao pdao;
	
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
	
	
}
