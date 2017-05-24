package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;
import com.dzwz.shop.model.User;
import com.opensymphony.xwork2.ActionContext;

public class SorderAction extends BaseAction<Sorder> {

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
		/*List<Forder> ff = productService.QueryJoinProduct1(null, 0, 999);
		// 2.判断当前购物车是否存在,，没有则创建一个
		session.put("forder", new Forder(ff.size() + 1));
		Forder forder = (Forder) session.get("forder");
		// 3.将得到的商品信息放进购物项
		Sorder s = sorderService.getSorder(forder, product);
		List<Sorder> sl = new ArrayList<Sorder>();
		sl.add(s);
		session.put("sorder", sl);
		session.put("totalPrice", s.getPrice());
		// forder = sorderService.addSorder(forder, product);
		// 计算总价格
		forder.setPrice(s.getPrice());
		session.put("forder", forder);*/
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
		
		List<Sorder> cartList=new ArrayList<Sorder>();
		User user=(User) session.get("userInfo");
		
		int uid=user.getId();
		//System.out.println(uid);
		cartList=sorderService.getAllCartByUid(uid);
		//System.out.println(cartList);
		request.put("cartList", cartList);
		return "sorder_list";
	}
	public String delete(){
		//System.out.println(model);
		sorderService.deleteById(model.getId());
		return "add_success";
	}

}
