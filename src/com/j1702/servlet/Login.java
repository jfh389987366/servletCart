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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserAction ua=new UserAction();
		StringBuffer sb=new StringBuffer();
		if(username != null && !username.equals("") && ua.isUserExist(username)){
			User user=ua.showUser(username);
			if(password != null && !password.equals("") && user.getPassWord().equals(password)){
				//��¼�ɹ��򴴽�����user�����session
				HttpSession session=request.getSession(true);
				session.setAttribute("username", username);
				sb.append("alert('�ۣ���¼�ɹ���Ү��ʹ�������ϽǾͿ���ȥ���İ��ı�����Ӵ')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}else{
				sb.append("alert('�ϣ�������ˣ�����ϸ���뿴��')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			}
		}else{
			sb.append("alert('Ү����������˺ž�Ȼ��û��ע�ᣡ��һ���Ǹ����˰ɣ��ٲ�Ȼ��ȥע���ᣡ')");
			request.setAttribute("alert", sb.toString());
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

}
