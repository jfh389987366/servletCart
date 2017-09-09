package com.j1702.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.j1702.dbcp.DBCPUtil;
import com.j1702.model.Record;

public class RecordDao {
	//添加数据
	public void add(String userName1,String goodsName1,String goodsUrl1,String goodsIntro1,Double price1,Integer number1){
		String sql="insert into record (userName,goodsName,goodsUrl,goodsIntro,price,number) values(?,?,?,?,?,?)";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement cs=conn.prepareStatement(sql);
			cs.setString(1, userName1);
			cs.setString(2, goodsName1);
			cs.setString(3, goodsUrl1);
			cs.setString(4, goodsIntro1);
			cs.setDouble(5, price1);
			cs.setInt(6, number1);
			cs.execute();
			conn.commit();
			conn.close();
			System.out.println("添加成功！");
		} catch (Exception e) {
			try {
				System.out.println("添加失败！");
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
	}
	//查看数据
	public List<Record> show(){
		String sql="select * from record";
		Connection conn=DBCPUtil.getConnection();
		List<Record> list=new ArrayList<Record>();
		try {
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rSet=stmt.executeQuery(sql);
			while (rSet.next()) {
				Record record=new Record();
				record.setId(rSet.getInt("id"));
				record.setUserName(rSet.getString("userName"));
				record.setGoodsName(rSet.getString("goodsName"));
				record.setGoodsUrl(rSet.getString("goodsUrl"));
				record.setGoodsIntro(rSet.getString("goodsIntro"));
				record.setPrice(rSet.getDouble("price"));
				record.setNumber(rSet.getInt("number"));
				record.setBuyTime(rSet.getString("buyTime"));
				list.add(record);
			}
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
