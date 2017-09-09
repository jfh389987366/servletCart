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
				sb.append("alert('�ۣ���ϲ���ɹ�ע�������칺�һ��Ҫ�μ������˺ź�����Ӵ�������ڻ���Ҫǰȥ��¼��ֵ�ſ��Թ��������ǵı���Ŷ��')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}else{
				sb.append("alert('������̫��С���ˣ�������������벻һ������������������ɣ�')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Regist.jsp").forward(request, response);
			}
		}else{
			sb.append("alert('Ү�����˻��Ѿ���ע����Ү�����ǻ�һ�����԰ɣ�')");
			request.setAttribute("alert", sb.toString());
			request.getRequestDispatcher("Regist.jsp").forward(request, response);
		}
	}

}
