package com.dzwz.shop.service;

import java.util.List;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {

	/**
	 * 添加商品到购物车
	 * 
	 * @param forder
	 * @param product
	 * @return
	 */
	public Forder addSorder(Forder forder, Product product);
	public Sorder getSorder(Forder forder, Product product);

	/**
	 * 将得到的商品信息放进购物项
	 * 
	 * @param product
	 * @return
	 */
	public Sorder productToSorder(Product product);

	// 分页查询
	public List<Sorder> QueryJoinProduct(String type, int page, int size);

	// 查询总数
	public Integer totalCategory(String name);

	/**
	 * 
	 * 更新商品信息
	 * 
	 * @param forder
	 * @param product
	 * @return
	 */
	public Forder upadteSorder(Forder forder, Sorder sorder);

	/**
	 * 查询销售额
	 * 
	 * @param number
	 * @return
	 */
	public List<Object> querySale(int number);

	/**
	 * 删除订单项
	 * 
	 * @param forder
	 * @return
	 */
	public Forder removeSorder(Forder forder, Sorder sorder);
	
	public List<Sorder> getAllCartByUid(int uid);
	public boolean addCart(Sorder s);
	
	public boolean deleteById(int id);
	
	public boolean modifyNumberById(int id,int number);
	
	public boolean deleteAllSorder(int uid);
}
