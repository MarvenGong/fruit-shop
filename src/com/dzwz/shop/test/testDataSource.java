package com.dzwz.shop.test;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration(locations={"classpath*:applicationContext-*.xml"}) // 
public class testDataSource {
	
	@Resource
	private DataSource dataSource;
	
	
	@Resource
	private Date date;
	
	@Test
	public void test(){
		System.out.println(date);
	}
	
	@Test
	public void testDataSource(){
		
//	    ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext-public.xml");
//		DataSource dataSource = act.getBean(DataSource.class);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
