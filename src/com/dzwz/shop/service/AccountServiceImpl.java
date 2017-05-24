package com.dzwz.shop.service;





import com.dzwz.shop.dao.AccountDao;
import com.dzwz.shop.model.Account;
import com.dzwz.shop.model.User;

public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{
	

	public AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account login(Account account) {
		
		return accountDao.QueryAccount(account);
	}


	
	
	



	
}
