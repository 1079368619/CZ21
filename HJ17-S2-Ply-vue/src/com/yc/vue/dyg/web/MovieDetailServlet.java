package com.yc.vue.dyg.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.vue.dyg.bean.DygMovieWithBLOBs;
import com.yc.vue.dyg.dao.DygDao;

@WebServlet("/movieDetail.s")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DygDao dao = new DygDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DygMovieWithBLOBs dmwb = null;
		try {
			dmwb = dao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(dmwb);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
