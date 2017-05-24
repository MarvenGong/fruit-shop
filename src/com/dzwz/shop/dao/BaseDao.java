package com.dzwz.shop.dao;

import java.util.List;

public interface BaseDao<T> {
	public void save(T t);
	public void update(T t);
	public void delete(int id);
	public T queryByid(int id);
	public List<T> query();
}
