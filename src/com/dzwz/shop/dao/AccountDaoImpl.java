package com.dzwz.shop.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import com.dzwz.shop.model.Account;



public  class AccountDaoImpl extends BaseDaoIpml<Account> implements AccountDao {

	@Override
	public Account QueryAccount(Account account) {
		Criteria cra  = getSession().createCriteria(Account.class);
		cra.add(Restrictions.eq("login", account.getLogin()));
		cra.add(Restrictions.eq("pass", account.getPass()));
		return (Account) cra.uniqueResult();
	}

	


	
}

	
	

