package com.dzwz.shop.action;

import java.util.HashMap;
import java.util.List;

import com.dzwz.shop.model.Status;
import com.dzwz.shop.model.User;
import com.dzwz.shop.model.Forder;

public class ForderAction extends BaseAction<Forder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 重写getModel从session中的的到 装配好的 购物车 此方法不安全
	/*
	 * @Override public Forder getModel() { model = (Forder)
	 * session.get("forder"); return model; }
	 */

	/**
	 * 实现订单项和购物车的级联入库
	 * 
	 */
	public String save() {
		/*
		 * Forder forder = (Forder) session.get("forder");
		 * model.setSorders(forder.getSorders());
		 * model.setPrice(forder.getPrice());
		 * model.setUser((User)session.get("userInof")); //建立与购物项的关联
		 * forderService.save(model);
		 */
		/******************************************************/
		// 重写getModel从session中的的到 装配好的 购物车的方式
		/*
		 * User user = (User)session.get("userInfo"); model.setUser(user);
		 * model.setStatus(new Status(1)); forderService.save(model);
		 */
		Forder forder = (Forder) session.get("forder");
		forder.setAddress("test");
		forder.setName("user");
		forder.setPost(model.getAddress());
		forder.setPost(model.getPost());
		forder.setPhone(model.getPhone());
		forder.setRemak(model.getRemak());
		forder.setStatus("1");
		forder.setUser("buyer");
		forder.setPrice(Double.valueOf(session.get("totalPrice").toString()));
		try {
			forderService.save(forder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 购物车 另存
		session.put("oldForder", forder);
		// 清空购物车
		session.put("forder", new Forder());

		return "bank";
	}

	public String productManage1() {
		try {
			resultMap = new HashMap<String, Object>();
			List<Forder> list = productService.QueryJoinProduct1(model
					.getName(), page, rows);
			resultMap.put("rows", list);
			resultMap.put("total", productService.totalCategory1(model
					.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsonSuccess";
	}

}
