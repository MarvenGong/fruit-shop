package com.dzwz.shop.test;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dzwz.shop.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class BaseDaoIpmlTest {
	
	
	@Resource
	private UserDao userdao;

	@Test
	public void testSave() {
	
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByid() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

}
