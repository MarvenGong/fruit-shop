package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends BaseDaoIpml<Category> implements CategoryDao {

	
	
	/**
     * 根据分页查询数据
     * @author zrui
     * @time 2015年8月28日16:40:56
     * @version v.0.1
     */
	@Override
	public List<Category> QueryJoinUser(String type, int page, int size) {
		
		//迫切左外连接
		String hql ="FROM Category c LEFT JOIN FETCH c.account WHERE c.type like :type";
		return getSession().createQuery(hql)
				.setString("type", "%"+type+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.list();
	}
    /**
     * 根据类型查询总数
     * @author zrui
     * @time 2015年8月28日16:40:56
     * @version v.0.1
     */
	@Override
	public Integer totalCategory(String type) {
		String hql = "FROM Category C WHERE C.type like :type";
		return getSession().createQuery(hql).setString("type","%"+type+"%").list().size();
	}
	
	/**
     * 根据id多类别删除
     * @author zrui
     * @time 2015年8月28日16:40:56
     * @version v.0.1
     */
	@Override
	public void deleteByids(String ids) {
		
	
		String hql = "DELETE FROM Category  WHERE id in ("+ids+")";
	    getSession().createQuery(hql).executeUpdate();

	}
	
	/**
     * 根据热点查询类别信息
     * @author zrui
     * @time 2015年8月28日16:40:56
     * @version v.0.1
     */
	
	@Override
	public List<Category> queryBycut(boolean b) {
		String hql = "FROM Category c WHERE c.hot=:b";
		int para = 0;
		if(b){
			para = 1;
		}
		
		return getSession()
				.createQuery(hql)  //
//				.setBoolean("b", b)  //
				.setInteger("b", para)
				.list();  //
	}
	
	
	
}
