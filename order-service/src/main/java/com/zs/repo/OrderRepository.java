package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {

}
