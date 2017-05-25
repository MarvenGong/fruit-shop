package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
	//查询总数
	public Integer totalCategory(String name);
	/**
	 * 
	 * 查询销售额
	 * 
	 * @param number
	 * @return
	 */
	public List<Object> querySale(int number);

	List<Sorder> QueryJoinProduct(String name, int page, int size);
	
	List<Sorder> findSorderByUid(int uid);
	
	boolean removeById(int id);
	
	boolean deleteAll(int uid);

}
