package com.dzwz.shop.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.dzwz.shop.model.User;

public  class UserDaoImpl<Uset> extends BaseDaoIpml<User> implements UserDao {

	@Override
	public User QueryUser(User user) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("login", user.getLogin()));
		criteria.add(Restrictions.eq("pwd", user.getPwd()));
		return (User) criteria.uniqueResult();
	}

	
	

}
