package com.j1702.action;

import java.util.List;

import com.j1702.dao.RecordDao;
import com.j1702.model.Record;

public class RecordAction {

	//��Ӽ�¼����
	public void addRecord(String userName1,String goodsName1,String goodsUrl1,String goodsIntro1,Double price1,Integer number1){
		RecordDao rd=new RecordDao();
		rd.add(userName1,goodsName1,goodsUrl1,goodsIntro1,price1,number1);
	}
	//�鿴���м�¼����
	public List<Record> showRecord(){
		RecordDao rd=new RecordDao();
		return rd.show();
	}
}
