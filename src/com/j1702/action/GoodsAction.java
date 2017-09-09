package com.j1702.action;

import java.util.List;

import com.j1702.dao.GoodsDao;
import com.j1702.model.Goods;

public class GoodsAction {
	//�����Ʒ
	public void addGoods(String name1,Double price1,String factory1,Integer number1,String url1,String intro1){
		GoodsDao gd=new GoodsDao();
		gd.add(name1, price1, factory1, number1,url1,intro1);
	}
	//�޸�ָ����Ʒ����
	public void updateGoods(String name1,Integer number1){
		GoodsDao gd=new GoodsDao();
		gd.update(name1, number1);
	}
	//��ҳ��ѯ��Ʒ����
	public List<Goods> fint(int page){
		GoodsDao gd=new GoodsDao();
		return gd.find(page);
	}
	//�鿴������Ʒ����
	public List<Goods> showGoods(){
		GoodsDao gd=new GoodsDao();
		return gd.show();
	}
	//�鿴��Ʒ����
	public int findCount(){
		GoodsDao fd=new GoodsDao();
		return fd.findCount();
	}
	//����ָ����Ʒ
	public Goods queryGoods(String name){
		GoodsDao gd=new GoodsDao();
		return gd.queryGoods(name);
	}
}
