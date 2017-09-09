package com.j1702.action;

import java.util.List;

import com.j1702.dao.UserDao;
import com.j1702.model.User;

public class UserAction {

	//添加用户
	public void addUser(String name1,String passWord1,Double money1){
		UserDao ud=new UserDao();
		ud.add(name1, passWord1, money1);
	}
	//修改指定用户金额
	public void updateMoney(String name1,Double money1){
		UserDao ud=new UserDao();
		ud.update(name1, money1);
	}
	//查找所有用户数据
	public List<User> showUser(){
		UserDao ud=new UserDao();
		return ud.show();
	}
	//验证用户是否存在
	public Boolean isUserExist(String username){
		UserDao ud=new UserDao();
		return ud.isUserExist(username);
	}
	//返回指定用户的对象
	public User showUser(String username){
		UserDao ud=new UserDao();
		return ud.showUser(username);
	}
}
