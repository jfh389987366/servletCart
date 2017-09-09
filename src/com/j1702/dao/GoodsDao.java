package com.j1702.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.j1702.dbcp.DBCPUtil;
import com.j1702.model.Goods;

public class GoodsDao {
	//添加数据
	public void add(String name1,Double price1,String factory1,Integer number1,String url1,String intro1){
		String sql="insert into goods (name,price,factory,number,url,intro) values(?,?,?,?,?,?)";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement cs=conn.prepareStatement(sql);
			cs.setString(1, name1);
			cs.setDouble(2, price1);
			cs.setString(3, factory1);
			cs.setInt(4, number1);
			cs.setString(5, url1);
			cs.setString(6, intro1);
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
	//修改数据
	public void update(String name1,Integer number1){
		String sql="update goods set number=? where name=?";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement cs=conn.prepareStatement(sql);
			cs.setInt(1, number1);
			cs.setString(2, name1);
			cs.execute();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
	}
	//分页查询商品数量
	public List<Goods> find(int page){
		List<Goods> list=new ArrayList<>();
		String sql="select * from goods limit ?,?";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, (page - 1) * Goods.PAGE_SIZE);
			ptmt.setInt(2, Goods.PAGE_SIZE);
			ResultSet rSet=ptmt.executeQuery();
			while(rSet.next()){
				Goods goods=new Goods();
				goods.setId(rSet.getInt("id"));
				goods.setName(rSet.getString("name"));
				goods.setPrice(rSet.getDouble("price"));
				goods.setFactory(rSet.getString("factory"));
				goods.setNumber(rSet.getInt("number"));
				goods.setUrl(rSet.getString("url"));
				goods.setIntro(rSet.getString("intro"));
				list.add(goods);
			}
			conn.commit();
			rSet.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//查看数据
	public List<Goods> show(){
		String sql="select * from goods";
		Connection conn=DBCPUtil.getConnection();
		List<Goods> list=new ArrayList<Goods>();
		Goods goods=new Goods();
		try {
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rSet=stmt.executeQuery(sql);
			while (rSet.next()) {
				goods.setId(rSet.getInt("id"));
				goods.setName(rSet.getString("name"));
				goods.setPrice(rSet.getDouble("price"));
				goods.setFactory(rSet.getString("factory"));
				goods.setNumber(rSet.getInt("number"));
				goods.setUrl(rSet.getString("url"));
				goods.setIntro(rSet.getString("intro"));
				list.add(goods);
			}
			conn.commit();
			rSet.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//查询数据总条数
	public int findCount(){
		int count=0;
		Connection conn=DBCPUtil.getConnection();
		String sql="select count(*) from goods";
		try {
			Statement ptmt=conn.createStatement();
			ResultSet rSet=ptmt.executeQuery(sql);
			while (rSet.next()) {
				count=rSet.getInt(1);
			}
			conn.commit();
			rSet.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	//返回指定商品
	public Goods queryGoods(String name){
		String sql="select * from goods where name=?";
		Connection conn=DBCPUtil.getConnection();
		Goods goods=new Goods();
		try{
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				goods.setName(rs.getString("name"));
				goods.setFactory(rs.getString("factory"));
				goods.setIntro(rs.getString("intro"));
				goods.setNumber(rs.getInt("number"));
				goods.setPrice(rs.getDouble("price"));
				goods.setUrl(rs.getString("url"));
			}
			conn.commit();
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return goods;
	}
}
