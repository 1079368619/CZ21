package com.yc.damai.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.dao.CartDao;
import com.yc.damai.po.Result;

@WebServlet("/cart.s")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private CartDao cdao = new CartDao();
	
	public void queryByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询当前登录的用户的购物车商品
		Object object = request.getSession().getAttribute("loginedUser");
		Map<String, Object> map = (Map<String, Object>) object;
		Object ouid = map.get("uid");//ouid ==》 Integer，
		int uid = Integer.parseInt("" + ouid);//万能类型转换int
		append(response, cdao.queryByUid(uid));
	}

	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		
		//查询当前登录的用户的购物车商品
		Object object = request.getSession().getAttribute("loginedUser");
		//map 你是什么类型就转成什么类型 
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) object;
		Object ouid = map.get("uid");//ouid ==》 Integer，
		int uid = Integer.parseInt("" + ouid);//万能类型转换int
		try {
			//增删改的操作，最后使用biz实现
			cdao.addCart(pid, count, uid);
			append(response, Result.success("添加购物车成功！"));
		} catch (SQLException e) {
			e.printStackTrace();
			append(response, Result.failure("添加购物车失败！"));
		}
	}
}
