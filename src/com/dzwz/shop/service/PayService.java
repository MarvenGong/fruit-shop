package com.dzwz.shop.service;

import java.util.Map;

import com.dzwz.shop.model.BackData;
import com.dzwz.shop.model.SendData;

public interface PayService {
	
	public Map<String, Object> saveDataToRequest(Map<String, Object> request,
			SendData sendData);
	
	public boolean checkBackData(BackData backData);

}
