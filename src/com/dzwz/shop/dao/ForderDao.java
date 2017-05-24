package com.dzwz.shop.dao;

import com.dzwz.shop.model.Forder;

public interface ForderDao extends BaseDao<Forder> {
	
	//更新状态
	public void updateForder(int uid,int sid);
	
}
