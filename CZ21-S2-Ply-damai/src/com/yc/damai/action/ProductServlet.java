package com.yc.damai.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.ProductDao;

@WebServlet("/product.s")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private ProductDao pdao = new ProductDao();
	
	public void queryHot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		append(response, pdao.queryHot());
	}

	public void queryLatest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		append(response, pdao.queryLatest());
	}
	
	public void queryByPid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		append(response, pdao.queryByPid(pid));
	}
	
	public void queryByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		append(response, pdao.queryByCsid(cid));
	}
}
