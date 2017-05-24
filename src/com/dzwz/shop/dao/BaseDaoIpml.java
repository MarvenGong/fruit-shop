package com.dzwz.shop.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dzwz.shop.model.Account;

@SuppressWarnings("unchecked")
public  class BaseDaoIpml<T> implements BaseDao<T> {
	
	private Class<T> clazz;
	
	public BaseDaoIpml() {
		ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
		 clazz = (Class<T>) type.getActualTypeArguments()[0];
	}	
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//获取当前线程中绑定的session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		String hql = "FROM "+clazz.getSimpleName()+" WHERE id=:id";
		getSession().createQuery(hql)
			.setInteger("id", id)
			.executeUpdate();

	}

	@Override
	public T queryByid(int id) {	
		
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "FROM  "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}


}
