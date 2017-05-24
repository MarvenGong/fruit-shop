package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

@SuppressWarnings("unchecked")
public class SorderDaoImpl extends BaseDaoIpml<Sorder> implements SorderDao {
	
	/**
	 * 查询销售额
	 * 
	 */
	@Override
	public List<Object> querySale(int number) {
		String hql = "SELECT  s.name, sum(s.number)  FROM Sorder s JOIN s.product GROUP BY s.product.id";
		return getSession()			//
				.createQuery(hql)   //
				.setFirstResult(0)  // 
				.setMaxResults(number)    //
				.list();       //
	}
	@Override
	public Integer totalCategory(String name) {
		String hql = "FROM Sorder p WHERE p.foreder.id :name";
		return getSession().createQuery(hql).setString("name","%"+name+"%").list().size();
	}
	@Override
	public List<Sorder> QueryJoinProduct(String name, int page, int size) {
		
		//迫切左外连接
		String hql ="FROM Sorder p WHERE p.foreder.id :name";
		return getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}

}