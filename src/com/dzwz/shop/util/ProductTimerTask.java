package com.dzwz.shop.util;

import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;


import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.dzwz.shop.model.Product;
import com.dzwz.shop.service.IndexService;

/**
 * 
 * 定时器刷新首页信息
 * 
 * @author zrui
 *
 */


@Component
public class ProductTimerTask extends TimerTask {
	
	@Resource
	private IndexService<Product> indexService = null;
	
	private ServletContext application = null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		System.out.println("-------------刷新首页信息----------------");
		 List<List<Product>> proList = indexService.indexInof();
		 //把查询的信息放入applicaion
		 application.setAttribute("proList", proList);
	}

}
