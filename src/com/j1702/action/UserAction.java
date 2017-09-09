package com.j1702.action;

import java.util.List;

import com.j1702.dao.UserDao;
import com.j1702.model.User;

public class UserAction {

	//����û�
	public void addUser(String name1,String passWord1,Double money1){
		UserDao ud=new UserDao();
		ud.add(name1, passWord1, money1);
	}
	//�޸�ָ���û����
	public void updateMoney(String name1,Double money1){
		UserDao ud=new UserDao();
		ud.update(name1, money1);
	}
	//���������û�����
	public List<User> showUser(){
		UserDao ud=new UserDao();
		return ud.show();
	}
	//��֤�û��Ƿ����
	public Boolean isUserExist(String username){
		UserDao ud=new UserDao();
		return ud.isUserExist(username);
	}
	//����ָ���û��Ķ���
	public User showUser(String username){
		UserDao ud=new UserDao();
		return ud.showUser(username);
	}
}
