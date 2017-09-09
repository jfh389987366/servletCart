package com.j1702.action;

import java.util.List;

import com.j1702.dao.GoodsDao;
import com.j1702.model.Goods;

public class GoodsAction {
	//添加商品
	public void addGoods(String name1,Double price1,String factory1,Integer number1,String url1,String intro1){
		GoodsDao gd=new GoodsDao();
		gd.add(name1, price1, factory1, number1,url1,intro1);
	}
	//修改指定商品数量
	public void updateGoods(String name1,Integer number1){
		GoodsDao gd=new GoodsDao();
		gd.update(name1, number1);
	}
	//分页查询商品数量
	public List<Goods> fint(int page){
		GoodsDao gd=new GoodsDao();
		return gd.find(page);
	}
	//查看所有商品数据
	public List<Goods> showGoods(){
		GoodsDao gd=new GoodsDao();
		return gd.show();
	}
	//查看商品总数
	public int findCount(){
		GoodsDao fd=new GoodsDao();
		return fd.findCount();
	}
	//返回指定商品
	public Goods queryGoods(String name){
		GoodsDao gd=new GoodsDao();
		return gd.queryGoods(name);
	}
}
