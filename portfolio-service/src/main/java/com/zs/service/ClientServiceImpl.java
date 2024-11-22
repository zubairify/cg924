package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.entity.Client;
import com.zs.repo.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repo;
	
	@Override
	public void add(Client c) {
		repo.save(c);
	}

	@Override
	public Client get(int cid) {
		return repo.findById(cid).get();
	}

	@Override
	public List<Client> list() {
		return repo.findAll();
	}
}
