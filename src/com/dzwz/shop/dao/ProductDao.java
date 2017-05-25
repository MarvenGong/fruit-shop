package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;

public interface ProductDao extends BaseDao<Product>{
	//分页查询
	public List<Forder>  QueryJoinProduct1(String name, int page, int size);
	//查询总数
	public Integer totalCategory1(String name);
	//分页查询
	public List<Product>  QueryJoinProduct(String name, int page, int size);
	//查询总数
	public Integer totalCategory(String name);
	
	//根据ids删除
	public void deleteByids(String ids);
	
	//根据类别热点查询商品信息
	public List<Product>  querybycid(int cid);
	
	//编辑产品信息
	public boolean modifyProduct(Product p);
	
}
