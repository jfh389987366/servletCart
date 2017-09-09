package com.j1702.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j1702.action.CartAction;

@WebServlet("/DelCart")
public class DelCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String goodsname=request.getParameter("goodsname");
		CartAction ca=new CartAction();
		if(username!=null && goodsname!=null){
		ca.deleteCart(username, goodsname);
		response.sendRedirect("Cart");
		}
	}

}
