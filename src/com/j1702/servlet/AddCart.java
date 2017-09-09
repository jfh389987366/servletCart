package com.j1702.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j1702.action.CartAction;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String goodsname=request.getParameter("goodsname");
		String goodsurl=request.getParameter("goodsurl");
		String goodsintro=request.getParameter("goodsintro");
		Double goodsprice=Double.parseDouble(request.getParameter("goodsprice"));
		Integer goodsnumber=1;
		CartAction ca=new CartAction();
		if(ca.isGoodsExist(goodsname,username)){//判断购物车中是否已有该商品，有就将该商品数量加一
			ca.changeNumber(goodsnumber+1, username);
			response.sendRedirect("Begin");
		}else{//没有则增加该商品
			ca.addCart(username, goodsname, goodsprice, goodsnumber, goodsurl, goodsintro);
			response.sendRedirect("Begin");
		}
	}

}
