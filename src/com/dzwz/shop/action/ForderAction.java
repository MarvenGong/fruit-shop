package com.dzwz.shop.action;

import java.util.Date;
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
		model.setStatus(1);
		model.setCreatedate(String.valueOf(new Date().getTime()));
		forderService.save(model);
		
		return "success";
	}
	public String pay(){
		//forderService.save
		//订单生成成功，清空购物车
		User user=(User) session.get("userInfo");
		int uid=user.getId();
		sorderService.deleteAllSorder(uid);
		//获取刚刚生成的订单信息
		Forder forder=forderService.getNewForder();
		request.put("forder", forder);
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
