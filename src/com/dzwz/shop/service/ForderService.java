package com.dzwz.shop.service;

import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Sorder;

public interface ForderService extends BaseService<Forder> {
		
		/**
		 * 计算总价格
		 * @param forder
		 * @return
		 */
		public Double totalPrice(Forder forder);
		
		/**
		 * 更新状态
		 * @param uid
		 * @param sid
		 */
		public void updateForder(int uid,int sid);
}
