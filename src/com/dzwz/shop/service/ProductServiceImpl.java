package com.dzwz.shop.service;

import java.util.List;

import com.dzwz.shop.dao.ProductDao;
import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;


public class ProductServiceImpl extends BaseServiceImpl<Product> implements
		ProductService {
	
	public ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	
	
	/**
	 * 
	 * 类别管理查询出类别表以及关联的user
	 * @author zrui
	 * @time 2015年8月27日16:04:50
	 * @version  v.0.1
	 * 
	 */
	
	@Override
	public List<Product> QueryJoinProduct(String name, int page, int size) {
		return productDao.QueryJoinProduct(name, page, size);
	}
	/**
	 * 
	 * 类别管理查询出类别表的总数
	 * @author zrui
	 * @time 2015年8月27日16:04:50
	 * @version  v.0.1
	 * 
	 */
	@Override
	public Integer totalCategory(String type) {
		return productDao.totalCategory(type);
	}
	@Override
	public List<Forder> QueryJoinProduct1(String name, int page, int size) {
		return productDao.QueryJoinProduct1(name, page, size);
	}
	/**
	 * 
	 * 类别管理查询出类别表的总数
	 * @author zrui
	 * @time 2015年8月27日16:04:50
	 * @version  v.0.1
	 * 
	 */
	@Override
	public Integer totalCategory1(String type) {
		return productDao.totalCategory1(type);
	}
	/**
	 * 
	 * 根据id多类别删除
	 * @author zrui
	 * @time 2015年8月27日16:04:50
	 * @version  v.0.1
	 * 
	 */
	@Override
	public void deleteByids(String ids) {
		productDao.deleteByids(ids);
	}

	
}
