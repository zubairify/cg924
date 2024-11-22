package com.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.entity.Order;
import com.zs.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Override
	public void add(Order o) {
		repo.save(o);
	}

	@Override
	public Order get(int oid) {
		return repo.findById(oid).get();
	}
}
