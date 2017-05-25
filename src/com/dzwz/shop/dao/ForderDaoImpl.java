package com.dzwz.shop.dao;

import java.util.List;

import com.dzwz.shop.model.Forder;

public class ForderDaoImpl extends BaseDaoIpml<Forder> implements ForderDao {
	
	
	/**
	 * 根据用户 来更新 状态
	 * 
	 */
	@Override
	public void updateForder(int uid,int sid) {
		String haql = "UPDATE Forder f SET f.status.id=:sid WHERE  f.user.id=:uid";
		getSession().createQuery(haql)
			.setInteger("uid", uid)     //
			.setInteger("sid", sid)     //
			.executeUpdate();
		
	}

	@Override
	public Forder getNewForder() {
		// TODO Auto-generated method stub
		String haql = "FROM Forder f ORDER BY f.createdate DESC";
		List<Forder> forders=getSession().createQuery(haql).list();
		
		return forders.get(0);
	}
	
}
