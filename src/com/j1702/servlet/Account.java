package com.j1702.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j1702.action.*;
import com.j1702.model.*;

import java.util.*;

@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Account() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("我是结账页面！1");
		HttpSession session=request.getSession();
		System.out.println("我是结账页面！2");
		String username=(String)session.getAttribute("username");
		
		String[] selectall=request.getParameterValues("selectall");
		System.out.println("我是结账页面！3");
		CartAction ca=new CartAction();
		RecordAction ra=new RecordAction();
		GoodsAction ga=new GoodsAction();
		System.out.println("我是结账页面！4");
		UserAction ua=new UserAction();
		User user=ua.showUser(username);
		List<com.j1702.model.Cart> list=new ArrayList<>();
		
		list=ca.showCart(username);
		
		StringBuffer sb=new StringBuffer();
		System.out.println("我是结账页面！5"+selectall);
		if(selectall==null){//如果全选框没被选中
			
			for(int i=1;i<=list.size();i++){
				
				String[] chek=request.getParameterValues("cheked");
				System.out.println("我是结账页面！6"+chek);
				if(chek!=null && chek.length>0){//如果该商品前面的复选框被选中，则说明该商品要被购买
					System.out.println("我是结账页面！7");
					String goodsname=request.getParameter("goodsname");
					com.j1702.model.Goods goods=ga.queryGoods(goodsname);
					Double money=Double.parseDouble(request.getParameter("money"));
					int number=Integer.parseInt(request.getParameter("sel"));
					System.out.println("我是结账页面！8"+number);
					double total=number*money;
					System.out.println("我是结账页面！9"+total);
					if(total>user.getMoney()){//判断余额够不够
						System.out.println("我是结账页面！0");
						sb.append("alert('哇！您的余额不够耶！快去充值吧！')");
						request.setAttribute("alert", sb.toString());
						
						request.getRequestDispatcher("Cart").forward(request, response);
					}else{
						System.out.println("我是结账页面！0");
						ga.updateGoods(goodsname, number);//修改商品库该商品的数量
						ca.deleteCart(username, goodsname);//删除指定用户的指定商品
						//添加交易记录
						ra.addRecord(username, goodsname, goods.getUrl(), goods.getIntro(), goods.getPrice(), number);
						sb.append("alert('OK!交易成功了！')");
						request.setAttribute("alert", sb.toString());
					
						request.getRequestDispatcher("Cart").forward(request, response);
					}
				}
			}
		}else{//如果全选框被选中，则全部商品都要购买
			System.out.println("我是10");
		}
		
	}

}
