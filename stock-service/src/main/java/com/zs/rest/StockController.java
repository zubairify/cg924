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
import com.zs.exception.StockNotFoundException;
import com.zs.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<String> addStock(@RequestBody Stock s) {
		service.add(s);
		return ResponseEntity.ok("Stock added");
//		return new ResponseEntity<String>("Stock added.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{sid}", produces = "application/json")
	public ResponseEntity<?> getStock(@PathVariable int sid) {
		try {
			Stock s = service.get(sid);
			return ResponseEntity.ok(s);
		} catch (StockNotFoundException e) {
			return ResponseEntity.notFound().header("message", e.getMessage()).build();
		}
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Stock>> listStock() {
		return new ResponseEntity<List<Stock>>(service.list(), HttpStatus.OK);
	}
}
