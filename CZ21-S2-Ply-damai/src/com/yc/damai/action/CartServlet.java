package com.yc.damai.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.damai.biz.CartBiz;
import com.yc.damai.dao.CartDao;
import com.yc.damai.po.Cart;
import com.yc.damai.po.Result;
import com.yc.damai.po.User;

@WebServlet("/cart.s")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private CartDao cdao = new CartDao();
	private CartBiz cbiz = new CartBiz();
	
	public void queryByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询当前登录的用户的购物车商品
		//request.getSession().getAttribute()返回的是Object类型
		Object loginedUser = request.getSession().getAttribute("loginedUser");
		if(loginedUser == null || loginedUser.equals("")) {
			append(response, Result.failure("请登录"));
			return;
		}
		/**
		Map<String, Object> map = (Map<String, Object>) object;
		Object ouid = map.get("uid");//ouid ==》 Integer，
		int uid = Integer.parseInt("" + ouid);//万能类型转换int
		 */
		
		User user = (User) loginedUser;
		int uid = user.getUid();
		System.out.println("方法queryByUid:" + uid);
		append(response, cdao.queryByUid(uid));
	}

	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spid = request.getParameter("pid");
		int pid = spid == null ? null : Integer.parseInt(spid);
		
		//查询当前登录的用户的购物车商品
		Object object = request.getSession().getAttribute("loginedUser");
		User user = (User) object;
		int uid = user.getUid();
		/*map 你是什么类型就转成什么类型 
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) object;
		Object ouid = map.get("uid");//ouid ==》 Integer，
		int uid = Integer.parseInt("" + ouid);//万能类型转换int
		*/
		System.out.println("user表的uid:"+uid);
		Cart cart = new Cart();
		cart.setUid(uid);
		cart.setPid(pid);
		try {
			//增删改的操作，最后使用biz实现,已用biz实现
			cbiz.addCart(cart);
			append(response, Result.success("添加购物车成功！"));
		} catch (SQLException e) {
			e.printStackTrace();
			append(response, Result.failure("添加购物车失败！"));
		}
	}
	
	public void deletebyCiid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sciid = request.getParameter("ciid");
		int ciid = sciid == null ? null : Integer.parseInt(sciid);
		try {
			if(cdao.deletebyCiid(ciid) == 0) {
				append(response, Result.failure("购物信息删除失败！"));
			} else {
				append(response, Result.success("购物信息删除成功！"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			append(response, Result.failure("购物信息删除失败！"));
		}
	}
}
