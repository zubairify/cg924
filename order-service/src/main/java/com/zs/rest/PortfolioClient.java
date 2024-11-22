package com.zs.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zs.dto.Client;

@FeignClient(name = "portfolio-service", url = "http://localhost:8002")
public interface PortfolioClient {

	@GetMapping("/client/{cid}")
	Client getClientById(@PathVariable int cid);
}
