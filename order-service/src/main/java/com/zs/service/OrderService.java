package com.zs.service;

import com.zs.entity.Order;

public interface OrderService {

	void add(Order o);
	
	Order get(int oid);

}
