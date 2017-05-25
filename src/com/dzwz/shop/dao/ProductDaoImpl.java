package com.dzwz.shop.dao;

import java.util.ArrayList;
import java.util.List;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoIpml<Product> implements ProductDao {

	/**
	 * 根据分页查询数据
	 * 
	 * @author zrui
	 * @time 2015年8月28日16:40:56
	 * @version v.0.1
	 */
	@Override
	public List<Product> QueryJoinProduct(String name, int page, int size) {
		//LEFT JOIN FETCH p.cid
		// 迫切左外连接
		String hql = "FROM Product p WHERE p.name  like :name";
		return getSession().createQuery(hql)
				.setString("name", "%" + name + "%").setFirstResult(
						(page - 1) * size).setMaxResults(size).list();
	}

	/**
	 * 根据类型查询总数
	 * 
	 * @author zrui
	 * @time 2015年8月28日16:40:56
	 * @version v.0.1
	 */
	@Override
	public Integer totalCategory(String name) {
		String hql = "FROM Product p LEFT JOIN FETCH p.cid WHERE p.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%" + name + "%").list().size();
	}

	@Override
	public List<Forder> QueryJoinProduct1(String name, int page, int size) {

		// 迫切左外连接
		String hql = "FROM Forder p ";
		List<Forder> os = new ArrayList<Forder>();
		try {
			os = getSession().createQuery(hql)
					.setFirstResult((page - 1) * size).setMaxResults(size)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
	}

	/**
	 * 根据类型查询总数
	 * 
	 * @author zruir
	 * @time 2015年8月28日16:40:56
	 * @version v.0.1
	 */
	@Override
	public Integer totalCategory1(String name) {
		String hql = "FROM Forder p ";
		return getSession().createQuery(hql)
		// .setString("name","%"+name+"%")
				.list().size();
	}

	/**
	 * 根据id多商品删除
	 * 
	 * @author zrui
	 * @time 2015年8月28日16:40:56
	 * @version v.0.1
	 */
	@Override
	public void deleteByids(String ids) {

		String hql = "DELETE FROM Product  WHERE id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();

	}

	/**
	 * 根据类别热点查询商品信息
	 * 
	 * @author zrui
	 * @time 2015年8月28日16:40:56
	 * @version v.0.1
	 */
	@Override
	public List<Product> querybycid(int cid) {
		String hql = "FROM Product p JOIN FETCH p.cid WHERE p.commend=true AND p.open=true AND p.cid.id=:cid ORDER BY p.date DESC";

		return getSession().createQuery(hql) //
				.setInteger("cid", cid) //
				.setFetchSize(0) //
				.setMaxResults(4) //
				.list(); //
	}

}
