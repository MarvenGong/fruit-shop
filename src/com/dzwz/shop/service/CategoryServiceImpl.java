package com.dzwz.shop.service;

import java.util.List;

import com.dzwz.shop.dao.BaseDao;
import com.dzwz.shop.dao.CategoryDao;
import com.dzwz.shop.model.Category;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements
		CategoryService {
	
	public CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
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
	public List<Category> QueryJoinUser(String type, int page, int size) {
		return categoryDao.QueryJoinUser(type, page, size);
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
		return categoryDao.totalCategory(type);
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
		categoryDao.deleteByids(ids);
	}

}
