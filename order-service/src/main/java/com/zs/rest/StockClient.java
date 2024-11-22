package com.zs.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zs.dto.Stock;

@FeignClient(name = "stock-service", url = "http://localhost:8001")
public interface StockClient {

	@GetMapping("/stock/{sid}")
	Stock getStockById(@PathVariable int sid);
}
