package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.json.annotations.JSON;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;
import com.dzwz.shop.model.User;
import com.opensymphony.xwork2.ActionContext;

public class SorderAction extends BaseAction<Sorder> {
	private Map<String,Object> dataMap;
	private String key = "Just see see";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 将商品信息放进购物车中
	 * 
	 * @return
	 */
	public String addsorder() {
		// 1.根据product.id 获取 商品信息
		Product product = productService.queryByid(model.getProduct().getId());
		if(session.get("userInfo")==null){
			session.put("goURL", "/detail.jsp");
			session.put("product", product);
			return "loginFa";
		}else{
			User user=(User) session.get("userInfo");
			int uid=user.getId();
			int pid=model.getProduct().getId();
			int number=1;
			Sorder s=new Sorder();
			s.setUid(uid);
			s.setFid(5);
			s.setProduct(product);
			s.setNumber(number);
			s.setName(product.getName());
			s.setPrice(product.getPrice());
			try {
				sorderService.addCart(s);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return "add_success";
		}
		

	}

	// 根据id更新数量和价格
	public String updatesorder() {
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.upadteSorder(forder, model);
		forder.setPrice(forderService.totalPrice(forder));
		session.put("forder", forder);
		// 返回流格式
		try {
			inputStream = new ByteArrayInputStream(forder.getPrice().toString()
					.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return "stream";
	}

	/**
	 * 销售额查询
	 * 
	 * @return
	 */
	public String querySale() {
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		// 将对象压入值栈栈顶
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}

	/**
	 * 订单项删除
	 * 
	 * @return
	 */
	public String removeSorder() {
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.removeSorder(forder, model);
		forder.setPrice(forderService.totalPrice(forder));
		session.put("forder", forder);
		try {

			inputStream = new ByteArrayInputStream(forder.getPrice().toString()
					.getBytes("utf-8"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "stream";
	}
	//get all cart
	public String list(){
		if(session.get("userInfo")==null){
			session.put("goURL", "/index.jsp");
			//session.put("product", product);
			return "loginFa";
		}else{
			List<Sorder> cartList=new ArrayList<Sorder>();
			User user=(User) session.get("userInfo");
			int uid=user.getId();
			//System.out.println(uid);
			cartList=sorderService.getAllCartByUid(uid);
			//System.out.println(cartList);
			double totalPrice=0;
			if(cartList.size()!=0){
				for(int i=0;i<cartList.size();i++){
					Sorder o=cartList.get(i);
					totalPrice+=o.getPrice()*o.getNumber();
				}
			}
			request.put("cartList", cartList);
			request.put("totalPrice", totalPrice);
			return "sorder_list";
		}
		
	}
	//通过ajax获取购物车信息
	public String ajaxList(){
		if(session.get("userInfo")==null){
			dataMap.put("cartLength", 0);
			dataMap.put("totalPrice", 0);
		}else{
			List<Sorder> cartList=new ArrayList<Sorder>();
			User user=(User) session.get("userInfo");
			int uid=user.getId();
			dataMap=new HashMap<String,Object>();
			//System.out.println(uid);
			cartList=sorderService.getAllCartByUid(uid);
			//System.out.println(cartList);
			double totalPrice=0;
			if(cartList.size()!=0){
				for(int i=0;i<cartList.size();i++){
					Sorder o=cartList.get(i);
					totalPrice+=o.getPrice()*o.getNumber();
				}
			}
			dataMap.put("cartLength", cartList.size());
			dataMap.put("totalPrice", totalPrice);
			
		}
		return "ajax_list";
	}
	public String delete(){
		//System.out.println(model);
		sorderService.deleteById(model.getId());
		return "add_success";
	}
	//修改數量
	public String setNumber(){
		sorderService.modifyNumberById(model.getId(), model.getNumber());
		return "add_success";
	}
	//删除全部购物车
	public String deleteAll(){
		User user=(User) session.get("userInfo");
		int uid=user.getId();
		sorderService.deleteAllSorder(uid);
		return "add_success";
	}
	//提交訂單
	public String confirmOrder(){
		List<Sorder> cartList=new ArrayList<Sorder>();
		User user=(User) session.get("userInfo");
		
		int uid=user.getId();
		cartList=sorderService.getAllCartByUid(uid);
		double totalPrice=0;
		if(cartList.size()!=0){
			for(int i=0;i<cartList.size();i++){
				Sorder o=cartList.get(i);
				totalPrice+=o.getPrice()*o.getNumber();
			}
		}
		
		request.put("cartList", cartList);
		request.put("totalPrice", totalPrice);
		return "order_confirm";
	}
	public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  

}
