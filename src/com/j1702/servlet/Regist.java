package com.j1702.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j1702.action.UserAction;

@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Regist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		Double money=0.00;
		UserAction ua=new UserAction();
		StringBuffer sb=new StringBuffer();
		if(username != null && !username.equals("") && !ua.isUserExist(username)){
			if(password != null && !password.equals("") && password.equals(repassword)){
				ua.addUser(username, password, money);
				sb.append("alert('哇！恭喜您成功注册了天天购物！一定要牢记您的账号和密码哟！您现在还需要前去登录充值才可以购买您心仪的宝贝哦！')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}else{
				sb.append("alert('哎！您太不小心了，两次输入的密码不一样呃！还是重新输入吧！')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Regist.jsp").forward(request, response);
			}
		}else{
			sb.append("alert('耶！该账户已经被注册了耶，还是换一个试试吧！')");
			request.setAttribute("alert", sb.toString());
			request.getRequestDispatcher("Regist.jsp").forward(request, response);
		}
	}

}
