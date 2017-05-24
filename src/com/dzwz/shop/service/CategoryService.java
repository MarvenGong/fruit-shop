package com.dzwz.shop.service;

import java.util.List;

import com.dzwz.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
		//分页查询
		public List<Category>  QueryJoinUser(String type, int page, int size);
		//查询总数
		public Integer totalCategory(String type);
		
		//根据ids删除
		public void deleteByids(String ids);
	
}
