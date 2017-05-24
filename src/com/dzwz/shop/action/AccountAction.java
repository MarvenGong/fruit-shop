package com.dzwz.shop.action;

import com.dzwz.shop.model.Account;
import com.dzwz.shop.model.User;

public class AccountAction extends BaseAction<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 用户查询
	 * @author zrui
	 * @time 2015年9月2日15:12:17
	 * @version v.0.1
	 */
	public String queryAccount(){
		jsonList =accountService.query();
		return "jsonlist";
	}
	
	public String login(){
		//进行登录的判断
	    Account  account= accountService.login(model);
	    if(account!=null){
	    	session.put("auserInfo", account);
	    	if(session.get("goURL")==null){
	    		return "index";
	    	}else{
	    		return "goURL";
	    	}
	    }else{
	    	request.put("error", "登录失败");
	    	return "loginFa";
	    }
	}
	
}
