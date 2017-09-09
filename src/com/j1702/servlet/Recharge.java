package com.j1702.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j1702.action.UserAction;
import com.j1702.model.User;

@WebServlet("/Recharge")
public class Recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Recharge() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		UserAction ua=new UserAction();
		HttpSession session=request.getSession(true);
		String name=(String)session.getAttribute("username");
		 user=ua.showUser(name);
		String money1=request.getParameter("usermoney");
		System.out.println(money1);
		Double money=Double.parseDouble(money1);
		ua.updateMoney(user.getName(), money+user.getMoney());
		request.setAttribute("alert", "alert('充值成功！当前余额为'+'money+user.getMoney()')");
		request.getRequestDispatcher("Begin").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
