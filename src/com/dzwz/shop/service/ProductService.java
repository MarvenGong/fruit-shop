package com.dzwz.shop.service;

import java.util.List;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;



public interface ProductService extends BaseService<Product> {
		//分页查询
		public List<Product>  QueryJoinProduct(String type, int page, int size);
		//查询总数
		public Integer totalCategory(String name);
		//分页查询
		public List<Forder>  QueryJoinProduct1(String type, int page, int size);
		//查询总数
		public Integer totalCategory1(String name);
		
		//根据ids删除
		public void deleteByids(String ids);
	
}
