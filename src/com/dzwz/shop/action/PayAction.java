package com.dzwz.shop.action;

import java.util.Map;


import org.apache.struts2.interceptor.ParameterAware;


import com.dzwz.shop.model.BackData;
import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.SendData;
import com.dzwz.shop.model.User;


public class PayAction extends BaseAction<Object> implements ParameterAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7061630353212938617L;
	private Map<String, String[]> parameters;
	
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
	
	@Override
	public Object getModel() {
		if(parameters.get("pd_FrpId")!=null){
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}
	
	public String goBank(){
		//1.补全参数   p2 p3 pd pa 从session中获取
		Forder forder = (Forder)session.get("oldForder"); 
		User user = (User)session.get("userInfo");
		SendData sendData = (SendData) model;
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getPrice().toString());
		sendData.setPa_MP(user.getPhone()+","+user.getEmail());
		//对参数追加 加密获取签名   存储到request 中
		payService.saveDataToRequest(request, sendData);
		return "pay";
	}
	
	
	public void backpay(){
		
		//得到传回的参数
		BackData backData = (BackData) model;
		//MD5加密后对比是否成功
	    boolean isOk =	payService.checkBackData(backData);
	    if(isOk){
	    	//订单号
	    	int id = Integer.parseInt(backData.getR6_Order());
	    	//更新状态信息
	    	forderService.updateForder(id, 2);
	    	//发送邮件
	    	String Email = backData.getR8_MP().split(",")[0];
	    	massageUtil.sendEmail(id, Email);
	    	//发送短信
	    	String phone = backData.getR8_MP().split(",")[1];
	    	massageUtil.sendmessage(phone, "你的"+id+"订单已经支付成功,感谢你在本商城的购物,祝你生活愉快");
	    }
	    else{
	    	System.out.println("---------失败------------");
	    }
	}
	
	
}
