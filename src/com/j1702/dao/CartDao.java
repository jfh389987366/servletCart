package com.j1702.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.j1702.dbcp.DBCPUtil;
import com.j1702.model.Cart;

public class CartDao {
	//�������
	public void add(String userName1,String goodsName1,Double goodsPrice1,Integer goodsNumber1,String goodsUrl1,String goodsIntro1){
		String sql="insert cart (userName,goodsName,goodsPrice,goodsNumber,goodsUrl,goodsIntro) values (?,?,?,?,?,?)";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, userName1);
			ptmt.setString(2,goodsName1);
			ptmt.setDouble(3, goodsPrice1);
			ptmt.setInt(4, goodsNumber1);
			ptmt.setString(5, goodsUrl1);
			ptmt.setString(6, goodsIntro1);
			ptmt.execute();
			conn.commit();
			conn.close();
			System.out.println("��ӳɹ���");
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
				System.out.println("���ʧ�ܣ�");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//���ָ���û���ָ������
	public void deleteCart(String userName1,String goodsName1){
		String sql="delete from cart where userName=? and goodsName=?";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, userName1);
			ptmt.setString(2, goodsName1);
			ptmt.execute();
			conn.commit();
			conn.close();
			System.out.println("����ɾ���ɹ���");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("����ɾ��ʧ�ܣ�");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//���ָ���û�����������
	public void deleteAll(String userName1){
		String sql="delete from cart where userName=?";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, userName1);
			ptmt.executeQuery();
			conn.commit();
			conn.close();
			System.out.println("����ɾ���ɹ���");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("����ɾ��ʧ�ܣ�");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//�ж��Ƿ��и���Ʒ
	public Boolean isGoodsExist(String goodsname,String username){
		String sql="select * from cart where goodsName=? and username=?";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, goodsname);
			stmt.setString(2, username);
			ResultSet rSet=stmt.executeQuery();
			while (rSet.next()) {
				if(rSet != null){
					if(goodsname.equals(rSet.getString("goodsName"))){
						return true;
					}
				}
			}
			conn.commit();
			rSet.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//���������ҹ��ﳵ����
	public List<Cart> show(String userName1){
		String sql="select * from cart where userName=?";
		Connection conn=DBCPUtil.getConnection();
		List<Cart> list=new ArrayList<Cart>();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, userName1);
			ResultSet rSet=ptmt.executeQuery();
			while (rSet.next()) {
				Cart cart=new Cart();
				cart.setUserName(rSet.getString("userName"));
				cart.setGoodsName(rSet.getString("goodsName"));
				cart.setGoodsPrice(rSet.getDouble("goodsPrice"));
				cart.setGoodsNumber(rSet.getInt("goodsNumber"));
				cart.setGoodsUrl(rSet.getString("goodsUrl"));
				cart.setGoodsIntro(rSet.getString("goodsIntro"));
				list.add(cart);
			}
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//���û����޸���Ʒ����
	public void changeNumber(Integer goodsnumber, String username){
		String sql="update cart set goodsNumber=? where userName=?";
		Connection conn=DBCPUtil.getConnection();
		try{
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, goodsnumber);
			ptmt.setString(2, username);
			ptmt.execute();
			conn.commit();
			conn.close();
			System.out.println("�����޸ĳɹ���");
		}catch(Exception e){
			try {
				conn.rollback();
				System.out.println("�����޸�ʧ�ܣ�");
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
