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

import com.zs.entity.Client;
import com.zs.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<String> addClient(@RequestBody Client c) {
		service.add(c);
		return new ResponseEntity<String>("Client added.", HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cid}", produces = "application/json")
	public ResponseEntity<Client> getClient(@PathVariable int cid) {
		return new ResponseEntity<Client>(service.get(cid), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Client>> getList() {
		return new ResponseEntity<List<Client>>(service.list(), HttpStatus.OK);
	}
}
