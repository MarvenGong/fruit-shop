package com.dzwz.shop.service;

import com.dzwz.shop.dao.BaseDao;
import com.dzwz.shop.dao.UserDao;
import com.dzwz.shop.model.Category;
import com.dzwz.shop.model.User;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	

	public UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

	public User login(User user){
		User result = userDao.QueryUser(user);
		return result;
	}



	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		return true;
	}

	
}
