package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
