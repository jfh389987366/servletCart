package com.j1702.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j1702.dao.GoodsDao;
import com.j1702.model.Goods;

@WebServlet("/")
public class Begin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Begin() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currPage = 1; // ��ǰҳ��
		if (request.getParameter("page") != null) { // �жϴ���ҳ���Ƿ���Ч
			currPage = Integer.parseInt(request.getParameter("page"));// �Ե�ǰҳ�븳ֵ
		}
		GoodsDao dao = new GoodsDao(); // ʵ����BookDao
		List<Goods> list = dao.find(currPage); // ��ѯ����ͼ����Ϣ
		request.setAttribute("list", list); // ��list���õ�request��
		int pages; // ��ҳ��
		int count = dao.findCount(); // ��ѯ�ܼ�¼��
		if (count % Goods.PAGE_SIZE == 0) { // ������ҳ��,�ܼ�¼����ÿҳ��ʾ����
			pages = count / Goods.PAGE_SIZE; // ����ҳ����ֵ
		} else {
			pages = count / Goods.PAGE_SIZE + 1; // ����ҳ����ֵ
		}
		StringBuffer sb = new StringBuffer(); // ʵ����StringBuffer
		for (int i = 1; i <= pages; i++) { // ͨ��ѭ��������ҳ������
			if (i == currPage) { // �ж��Ƿ�Ϊ��ǰҳ
				sb.append("��" + i + "��"); // ������ҳ������
			} else {
				// ������ҳ������
				sb.append("<a href='Begin?page=" + i + "'>" + i + "</a>");
			}
			sb.append("��"); // ������ҳ������
		}
		
		String alert=(String)request.getAttribute("alert");
		request.setAttribute("alert", alert);
		request.setAttribute("bar", sb.toString()); // ����ҳ���������ַ������õ�request��
		// ת����bookList.jspҳ��
		request.getRequestDispatcher("Begin.jsp").forward(request, response);
	}
}
