package com.dzwz.shop.service;

import com.dzwz.shop.model.User;

public interface UserService extends BaseService<User>{
	/**
	 * 
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	
}
