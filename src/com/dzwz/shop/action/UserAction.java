package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Random;

import com.dzwz.shop.model.User;

public class UserAction extends BaseAction<User> {
	
	
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
	public String queryUser(){
		jsonList =userService.query();
		return "jsonlist";
	}
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//进行登录的判断
	    User  user= userService.login(model);
	    if(user!=null){
	    	session.put("userInfo", user);
	    	if(session.get("goURL")==null){
	    		return "index";
	    	}else{
	    		if(session.get("product")!=null){
	    			request.put("product",session.get("product") );
	    		}
	    		return "goURL";
	    	}
	    	
	    }else{
	    	request.put("error", "登录失败");
	    	return "loginFa";
	    }
	}
	/**
	 * 登录
	 * @return
	 */
	public String register(){
		//进行登录的判断
		//System.out.println(model);
		userService.addUser(model);
		return "index";
	}
	/**
	 * 登出
	 * @return
	 */
	public String logout(){
		session.put("userInfo",null);
		return "goURL";
	}
	/**
	 * 
	 * 短信发送
	 * @return
	 */
	
	public void SMS(){
		Random random = new Random();
		String result="";
		for(int i=0;i<6;i++){
		result+=random.nextInt(10);
		}
		String info="【睿购商城】你好，感谢你注册睿购商城,你的校验码为"+result+",了解详情http://ww.zrui.xyz";
		massageUtil.sendmessage(model.getPhone(), info);	
		session.put("sms_code", result);
	}
	/**
	 * 
	 * 短息验证
	 * @return
	 */
	public String iScode(){
		String temp = (String) session.get("sms_code");
		if(code.equals("123456")){
			inputStream =  new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream =  new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	
	
	
}
