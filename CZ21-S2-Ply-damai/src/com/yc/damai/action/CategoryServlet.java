package com.yc.damai.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.CategroyDao;

@WebServlet("/category.s")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private CategroyDao cdao = new CategroyDao();
	
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		append(response, cdao.queryAll());
	}

}
