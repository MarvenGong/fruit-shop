package com.dzwz.shop.Interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation Invocation) throws Exception {
		ActionContext act = ActionContext.getContext();
		Map<String,Object> session = act.getSession();
		if(session.get("auserInfo")!=null){
			String result = Invocation.invoke();
			return	result;
		}
		return "login";
	}

}
