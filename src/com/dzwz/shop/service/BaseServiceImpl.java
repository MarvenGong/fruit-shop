package com.dzwz.shop.service;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;



import com.dzwz.shop.dao.BaseDao;


public class BaseServiceImpl<T> implements BaseService<T>{

	private Class<T> clazz;
	public BaseServiceImpl() {
		ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
		 clazz = (Class<T>) type.getActualTypeArguments()[0];
	}	
    
	public void init(){
	  //根据clazz的类型把不同的dao赋值给Basedao
	  String clazzName = clazz.getSimpleName();   
	  String clazzDao = clazzName.substring(0, 1).toLowerCase()+clazzName.substring(1)+"Dao";
	  try {
		 
		  Field clazzField = this.getClass().getDeclaredField(clazzDao);
		  Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
		  baseField.set(this, clazzField.get(this));
	  } catch (Exception e) {
		throw new  RuntimeException(e);
		
	}
	}
	
   public BaseDao baseDao;
   
  
  
	
	@Override
	public void save(T t) {
		baseDao.save(t);
		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T queryByid(int id) {
		return (T) baseDao.queryByid(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}
    


	


	
	

}
