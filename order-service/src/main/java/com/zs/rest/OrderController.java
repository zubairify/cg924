package com.zs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.Client;
import com.zs.dto.OrderVO;
import com.zs.dto.Stock;
import com.zs.entity.Order;
import com.zs.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@Autowired
	private PortfolioClient portfolio;
	
	@Autowired
	private StockClient stock;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<String> addOrder(@RequestBody Order order) {
		service.add(order);
		return new ResponseEntity<String>("Order added.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{oid}", produces = "application/json")
	public ResponseEntity<OrderVO> getOrder(@PathVariable int oid) {
		OrderVO vo = new OrderVO();
		Order order = service.get(oid);
		vo.setOid(order.getOid());
		vo.setQty(order.getQty());
		vo.setAmount(order.getAmount());
		
		Client c = portfolio.getClientById(order.getCid());
		Stock s = stock.getStockById(order.getSid());
		vo.setClient(c);
		vo.setStock(s);
		
		return new ResponseEntity<OrderVO>(vo, HttpStatus.OK);
	}
}
