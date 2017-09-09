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
				//登录成功则创建包含user对象的session
				HttpSession session=request.getSession(true);
				session.setAttribute("username", username);
				sb.append("alert('哇！登录成功了耶！使劲戳左上角就可以去买心爱的宝贝了哟')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}else{
				sb.append("alert('呦！密码错了，再仔细想想看！')");
				request.setAttribute("alert", sb.toString());
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			}
		}else{
			sb.append("alert('耶！您输入的账号居然还没有注册！你一定是搞忘了吧！再不然先去注个册！')");
			request.setAttribute("alert", sb.toString());
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

}
