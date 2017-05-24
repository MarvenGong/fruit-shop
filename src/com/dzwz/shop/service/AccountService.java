package com.dzwz.shop.service;

import com.dzwz.shop.model.Account;


public interface AccountService extends BaseService<Account>{
	public Account login(Account account);
}
