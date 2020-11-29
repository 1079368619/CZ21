package com.yc.vue.dyg.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.vue.dyg.bean.DygMovie;
import com.yc.vue.dyg.dao.DygDao;

@WebServlet("/queryTVshow.s")
public class QueryTVshowServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private DygDao dao = new DygDao();
	
	protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DygMovie> list = null;
		try {
			list = dao.selectlatestTVshow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		//
		response.getWriter().append(json);
	}

}
