package com.j1702.action;

import java.util.ArrayList;
import java.util.List;

import com.j1702.dao.CartDao;
import com.j1702.model.Cart;

public class CartAction {

	//添加购物车数据
	public void addCart(String userName1,String goodsName1,Double goodsPrice1,Integer goodsNumber1,String goodsUrl1,String goodsIntro1){
		CartDao cd=new CartDao();
		cd.add(userName1,goodsName1,goodsPrice1,goodsNumber1,goodsUrl1,goodsIntro1);
	}
	//删除指定用户的指定数据
	public void deleteCart(String username,String goodsname){
		CartDao cd=new CartDao();
		cd.deleteCart(username, goodsname);
	}
	//删除指定用户在购物车中的所有数据
	public void deleteAll(String userName1){
		CartDao cd=new CartDao();
		cd.deleteAll(userName1);
	}
	//查找指定用户在购物车中的数据
	public List<Cart> showCart(String userName1){
		CartDao cd=new CartDao();
		List<Cart> list=new ArrayList<>();
		list=cd.show(userName1);
		return list;
	}
	//查询是否有指定商品
	public Boolean isGoodsExist(String goodsname,String username){
		CartDao cd=new CartDao();
		return cd.isGoodsExist(goodsname,username);
	}
	//修改指定商品的数量
	public void changeNumber(Integer goodsnumber,String username){
		CartDao cd=new CartDao();
		cd.changeNumber(goodsnumber, username);
	}
}
