package com.j1702.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j1702.action.CartAction;
import com.j1702.action.UserAction;
import com.j1702.model.*;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cart(){
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("username");
		CartAction ca=new CartAction();
		UserAction ua=new UserAction();
		User user=ua.showUser(name);
		Double money=user.getMoney();
		request.setAttribute("money", money);
		List<com.j1702.model.Cart> list=ca.showCart(name);
		if(request.getAttribute("alert")!=null){
			request.setAttribute("alert", request.getAttribute("alert"));
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

}
