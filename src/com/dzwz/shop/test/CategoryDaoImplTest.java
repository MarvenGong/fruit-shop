package com.dzwz.shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dzwz.shop.dao.CategoryDao;
import com.dzwz.shop.model.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryDaoImplTest {

	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
	
	@Test
	public void testQueryJoinUser() {
	 List<Category> list =	categoryDao.QueryJoinUser("管理员", 1, 1);
	
	 for(Category cat : list){
		 System.out.println(cat);
	 }
	}

}
