package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.entity.Stock;
import com.zs.exception.StockNotFoundException;
import com.zs.repo.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository repo;
	
	@Override
	public void add(Stock s) {
		repo.save(s);
	}

	@Override
	public Stock get(int sid) {
		return repo.findById(sid).orElseThrow(() -> new StockNotFoundException("Invalid stock id"));
	}

	@Override
	public List<Stock> list() {
		return repo.findAll();
	}

}
