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
		System.out.println("���ǽ���ҳ�棡1");
		HttpSession session=request.getSession();
		System.out.println("���ǽ���ҳ�棡2");
		String username=(String)session.getAttribute("username");
		
		String[] selectall=request.getParameterValues("selectall");
		System.out.println("���ǽ���ҳ�棡3");
		CartAction ca=new CartAction();
		RecordAction ra=new RecordAction();
		GoodsAction ga=new GoodsAction();
		System.out.println("���ǽ���ҳ�棡4");
		UserAction ua=new UserAction();
		User user=ua.showUser(username);
		List<com.j1702.model.Cart> list=new ArrayList<>();
		
		list=ca.showCart(username);
		
		StringBuffer sb=new StringBuffer();
		System.out.println("���ǽ���ҳ�棡5"+selectall);
		if(selectall==null){//���ȫѡ��û��ѡ��
			
			for(int i=1;i<=list.size();i++){
				
				String[] chek=request.getParameterValues("cheked");
				System.out.println("���ǽ���ҳ�棡6"+chek);
				if(chek!=null && chek.length>0){//�������Ʒǰ��ĸ�ѡ��ѡ�У���˵������ƷҪ������
					System.out.println("���ǽ���ҳ�棡7");
					String goodsname=request.getParameter("goodsname");
					com.j1702.model.Goods goods=ga.queryGoods(goodsname);
					Double money=Double.parseDouble(request.getParameter("money"));
					int number=Integer.parseInt(request.getParameter("sel"));
					System.out.println("���ǽ���ҳ�棡8"+number);
					double total=number*money;
					System.out.println("���ǽ���ҳ�棡9"+total);
					if(total>user.getMoney()){//�ж�������
						System.out.println("���ǽ���ҳ�棡0");
						sb.append("alert('�ۣ���������Ү����ȥ��ֵ�ɣ�')");
						request.setAttribute("alert", sb.toString());
						
						request.getRequestDispatcher("Cart").forward(request, response);
					}else{
						System.out.println("���ǽ���ҳ�棡0");
						ga.updateGoods(goodsname, number);//�޸���Ʒ�����Ʒ������
						ca.deleteCart(username, goodsname);//ɾ��ָ���û���ָ����Ʒ
						//��ӽ��׼�¼
						ra.addRecord(username, goodsname, goods.getUrl(), goods.getIntro(), goods.getPrice(), number);
						sb.append("alert('OK!���׳ɹ��ˣ�')");
						request.setAttribute("alert", sb.toString());
					
						request.getRequestDispatcher("Cart").forward(request, response);
					}
				}
			}
		}else{//���ȫѡ��ѡ�У���ȫ����Ʒ��Ҫ����
			System.out.println("����10");
		}
		
	}

}
