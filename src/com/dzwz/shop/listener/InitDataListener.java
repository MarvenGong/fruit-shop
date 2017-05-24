package com.dzwz.shop.listener;


import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.dzwz.shop.util.FileUpload;
import com.dzwz.shop.util.ProductTimerTask;



/**
 * 用与项目启动的时候初始化
 * @author zrui
 * @time 2015年9月6日17:41:55
 * @version v.0.1
 *
 */



public class InitDataListener implements ServletContextListener {
	
    private ApplicationContext context=null;
	
    private ProductTimerTask   productTimerTask; 
    
    private FileUpload fileUpload;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//1.获取业务逻辑查询商品信息
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		//ServletContext 中获取Sping 配置信息 通过工具类加载
		 context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());	
		 productTimerTask  = (ProductTimerTask) context.getBean("productTimerTask");
		 fileUpload  = (FileUpload) context.getBean("fileUpload");
		 productTimerTask.setApplication(event.getServletContext());
		 //设置守护线程的让首页的数据每隔30秒同步一次  定时刷新
		 new  Timer(true).schedule(productTimerTask, 0, 1000*30);
		 
		 
		 //初始化银行图标 得到容器路径
		 String bankPath = event.getServletContext().getRealPath("/images/bank");
		 System.out.println("*******"+bankPath+"********************************");
		 event.getServletContext().setAttribute("bankImage",fileUpload.getBankImage(bankPath) );
	}

}
