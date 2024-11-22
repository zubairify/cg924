package com.zs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.entity.Stock;
import com.zs.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<String> addStock(@RequestBody Stock s) {
		service.add(s);
		return new ResponseEntity<String>("Stock added.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{sid}", produces = "application/json")
	public ResponseEntity<Stock> getStock(@PathVariable int sid) {
		return new ResponseEntity<Stock>(service.get(sid), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Stock>> listStock() {
		return new ResponseEntity<List<Stock>>(service.list(), HttpStatus.OK);
	}
}
