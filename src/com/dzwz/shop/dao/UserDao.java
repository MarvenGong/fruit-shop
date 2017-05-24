package com.dzwz.shop.dao;

import com.dzwz.shop.model.User;


public interface UserDao extends BaseDao<User> {
	
	public User QueryUser(User user);

}
