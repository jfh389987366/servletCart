package com.j1702.action;

import java.util.ArrayList;
import java.util.List;

import com.j1702.dao.CartDao;
import com.j1702.model.Cart;

public class CartAction {


	public void addCart(String userName1,String goodsName1,Double goodsPrice1,Integer goodsNumber1,String goodsUrl1,String goodsIntro1){
		CartDao cd=new CartDao();
		//ddddddd
		cd.add(userName1,goodsName1,goodsPrice1,goodsNumber1,goodsUrl1,goodsIntro1);
	}

	public void deleteCart(String username,String goodsname){
		CartDao cd=new CartDao();
		//ddddffflo;iy6ju
		cd.deleteCart(username, goodsname);
	}
	
	public void deleteAll(String userName1){
		CartDao cd=new CartDao();
		//ddddddd
		cd.deleteAll(userName1);
	}
	//����ָ���û��ڹ��ﳵ�е�����
	public List<Cart> showCart(String userName1){
		CartDao cd=new CartDao();
		List<Cart> list=new ArrayList<>();
		list=cd.show(userName1);
		return list;
	}
	//��ѯ�Ƿ���ָ����Ʒ
	public Boolean isGoodsExist(String goodsname,String username){
		CartDao cd=new CartDao();
		return cd.isGoodsExist(goodsname,username);
	}
	//�޸�ָ����Ʒ������
	public void changeNumber(Integer goodsnumber,String username){
		CartDao cd=new CartDao();
		cd.changeNumber(goodsnumber, username);
	}
}
