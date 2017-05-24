package com.dzwz.shop.action;


import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dzwz.shop.service.AccountService;
import com.dzwz.shop.service.CategoryService;
import com.dzwz.shop.service.ForderService;
import com.dzwz.shop.service.PayService;
import com.dzwz.shop.service.ProductService;
import com.dzwz.shop.service.SorderService;
import com.dzwz.shop.service.UserService;
import com.dzwz.shop.util.FileImage;
import com.dzwz.shop.util.FileUpload;
import com.dzwz.shop.util.MassageUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Action基本类实现RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T>接口
 * 
 * @Time 2015-08-17
 * @author zrui
 *
 * @param <T>
 */


public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Map<String,Object> request;
	public Map<String,Object> session;
	public Map<String,Object> application;
	
	public T model;
	
	public UserService userService;
	
	public CategoryService  categoryService;
	
	public ForderService forderService;
	
	public SorderService sorderService;
	
	public AccountService accountService;
	
	public ProductService productService;
	
	public PayService payService;
	
	public FileUpload fileUplaod;
	
	public InputStream inputStream;
	
	public FileImage fileImage;
	
	@Resource
	public MassageUtil massageUtil;
	
	public String ids;


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	
	//json list
	
	public List<T>  jsonList = null;
	public List<T> getJsonList() {
		return jsonList;
	}

	//分页属性
	public int page;
	public int rows;
	
	public Map<String,Object> resultMap;
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
	 
	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
    
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setPayService(PayService payService) {
		this.payService = payService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}

	public void setForderService(ForderService foderService) {
		this.forderService = foderService;
	}

	public void setFileUplaod(FileUpload fileUplaod) {
		this.fileUplaod = fileUplaod;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//获取application
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;

	}
	//获取session
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	//获取session
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	/**
	 * 利用泛型实例化getModel方法
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();   //获取父类的泛型
		Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];	 //获取类型中的对应的类型的的class
		try {
			model =  clazz.newInstance();		//使用反射对model实例化
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return model;
	}
	
	

}
