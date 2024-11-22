package com.zs.service;

import java.util.List;

import com.zs.entity.Stock;

public interface StockService {
	
	void add(Stock s);
	
	Stock get(int sid);
	
	List<Stock> list();
	
}
