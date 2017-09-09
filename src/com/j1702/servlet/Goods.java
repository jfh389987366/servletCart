package com.j1702.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Goods")
public class Goods extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Goods() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String username=(String)session.getAttribute("username");
		
		String goodsname=request.getParameter("name");
		String goodsurl=request.getParameter("url");
		String goodsintro=request.getParameter("intro");
		Double goodsprice=Double.parseDouble(request.getParameter("price"));
		Integer goodsnumber=Integer.parseInt(request.getParameter("number"));
		
		if(request.getAttribute("alert") != null){
			request.setAttribute("alert", request.getAttribute("alert"));
		}
		
System.out.println(goodsname+"\n"+goodsurl+"\n"+goodsintro+"\n"+goodsnumber+"\n"+goodsprice+"\n"+username);
		
		request.setAttribute("username", username);
		request.setAttribute("name", goodsname);
		request.setAttribute("price", goodsprice);
		request.setAttribute("number", goodsnumber);
		request.setAttribute("url", goodsurl);
		request.setAttribute("intro", goodsintro);
		request.getRequestDispatcher("Goods.jsp").forward(request, response);
	}

}
