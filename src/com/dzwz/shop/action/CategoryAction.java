package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import com.dzwz.shop.model.Category;

public class CategoryAction extends BaseAction<Category> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 类别管理
	 * 
	 * @author zrui
	 * @time 2015年8月27日17:14:05
	 * @version v.0.1
	 * 
	 */
	public String CategoryManage(){
		
		resultMap = new HashMap<String,Object>();
		List<Category> CategoryList = categoryService.QueryJoinUser(model.getType(), page, rows);
		resultMap.put("total", categoryService.totalCategory(model.getType()));
		resultMap.put("rows", CategoryList);
		return "categoryOk";
	}
	/**
	 * 类别删除
	 * @author zrui
	 * @time 2015年8月27日17:14:05
	 * @version v.0.1
	 */
	public String deleteByids(){
		categoryService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	/**
	 * 类别添加
	 * @author zrui
	 * @time 2015年8月27日17:14:05
	 * @version v.0.1
	 */
	public void save(){
		System.out.println(model);
		categoryService.save(model);
		
	}
	
	/**
	 * 类别更新
	 * @author zrui
	 * @time 2015年8月27日17:14:05
	 * @version v.0.1
	 */
	public void update(){
		System.out.println(model);
		categoryService.update(model);
		
	}
	
	/**
	 * 类别查询
	 * @author zrui
	 * @time 2015年9月4日23:15:23
	 * @version v.0.1
	 * 
	 */
	 public String quercategory(){
		 jsonList = categoryService.query();
		 return "jsonlist";
	 }	
	
	
}
