package com.dzwz.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.dzwz.shop.dao.CategoryDao;
import com.dzwz.shop.dao.ProductDao;
import com.dzwz.shop.model.Category;
import com.dzwz.shop.model.Product;

public class IndexServiceImpl implements IndexService<Product> {

	private ProductDao productDao;
	private CategoryDao categoryDao;
	
	
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}



	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}



	@Override
	public List<List<Product>> indexInof() {
		List<List<Product>> proList = new ArrayList<List<Product>>();
		 
		 for (Category category : categoryDao.queryBycut(true)) {
			 proList.add(productDao.querybycid(category.getId()));
		}
		return proList;
	}

}
