package com.yc.vue.d1124;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/div.s")
public class DivServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		double da = a == null ? 0 :Double.parseDouble(a);
		double db = b == null ? 0 :Double.parseDouble(b);
		response.getWriter().write(da / db + "");
	}

}
