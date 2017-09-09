package com.j1702.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.j1702.dbcp.DBCPUtil;
import com.j1702.model.User;

public class UserDao {
	//����û�����
	public void add(String name1,String passWord1,Double money1){
		String sql="insert into user (name,passWord,money) values(?,?,?)";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement cs=conn.prepareStatement(sql);
			cs.setString(1, name1);
			cs.setDouble(3, money1);
			cs.setString(2, passWord1);
			cs.execute();
			conn.commit();
			conn.close();
			System.out.println("��ӳɹ���");
		} catch (Exception e) {
			try {
				System.out.println("���ʧ�ܣ�");
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
	}
	//�޸Ľ��
	public void update(String name1,Double money1){
		String sql="update user set money=? where name=?";
		Connection conn=DBCPUtil.getConnection();
		try {
			PreparedStatement cs=conn.prepareStatement(sql);
			cs.setDouble(1, money1);
			cs.setString(2, name1);
			cs.execute();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//�鿴����
	public List<User> show(){
		String sql="select * from user";
		Connection conn=DBCPUtil.getConnection();
		List<User> list=new ArrayList<User>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rSet=stmt.executeQuery(sql);
			while (rSet.next()) {
				User user=new User();
				user.setId(rSet.getInt("id"));
				user.setName(rSet.getString("name"));
				user.setPassWord(rSet.getString("passWord"));
				user.setMoney(rSet.getDouble("money"));
				list.add(user);
			}
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//��֤�û��Ƿ����
	public Boolean isUserExist(String username){
		String sql="select * from user";
		Connection conn=DBCPUtil.getConnection();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rSet=stmt.executeQuery(sql);
			while (rSet.next()) {
				if(rSet != null){
					if(username.equals(rSet.getString("name"))){
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
	//����ָ������
	public User showUser(String username){
		String sql="select * from user where name=?";
		Connection conn=DBCPUtil.getConnection();
		User user=new User();
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, username);
			ResultSet rSet=ptmt.executeQuery();
			while (rSet.next()) {
				user.setId(rSet.getInt("id"));
				user.setName(rSet.getString("name"));
				user.setPassWord(rSet.getString("passWord"));
				user.setMoney(rSet.getDouble("money"));
			}
			conn.commit();
			rSet.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
