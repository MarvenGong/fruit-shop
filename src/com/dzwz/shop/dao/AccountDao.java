package com.dzwz.shop.dao;

import com.dzwz.shop.model.Account;


public interface AccountDao extends BaseDao<Account> {
	
	public Account QueryAccount(Account account);

}
