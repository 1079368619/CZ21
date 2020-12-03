package com.yc.damai.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.CategorySecondDao;
import com.yc.damai.dao.CategroyDao;

@WebServlet("/categorySecond.s")
public class CategorySecondServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private CategorySecondDao csdao = new CategorySecondDao();
	private CategroyDao cdao = new CategroyDao();
	
	public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> data = new HashMap<>();
		data.put("listc", cdao.queryAll());
		data.put("listcs", csdao.queryAllCategory());
		append(response, data);
	}

}
